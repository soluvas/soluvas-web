package org.soluvas.web.nav.live;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;
import org.soluvas.push.CollectionAdd;
import org.soluvas.push.CollectionDelete;
import org.soluvas.web.nav.MenuItem;
import org.soluvas.web.nav.MenuItemContainer;

import com.google.common.base.Preconditions;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ceefour
 *
 */
public class LiveMenuRepositoryAdapter extends EContentAdapter {

	private transient Logger log = LoggerFactory.getLogger(LiveMenuRepositoryAdapter.class);
	private Channel channel;
	private String topic;
	
	public LiveMenuRepositoryAdapter(Connection amqp, String topic) throws IOException {
		super();
		this.topic = topic;
		channel = amqp.createChannel();
		Preconditions.checkNotNull(channel, "AMQP channel must not be null");
	}

	@PreDestroy
	public void destroy() {
		try {
			channel.close();
		} catch (IOException e) {
			log.warn("Cannot close AMQP Channel", e);
		}
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		log.trace("Menu notification {}", notification);
		switch (notification.getEventType()) {
		case Notification.ADD:
			if (notification.getNotifier() instanceof MenuItemContainer && notification.getNewValue() instanceof MenuItem) {
				final MenuItem newItem = (MenuItem) notification.getNewValue();
				CollectionAdd<MenuItem> push = new CollectionAdd<MenuItem>(topic, newItem);
				String pushJson = JsonUtils.asJson(push);
				log.info("Publishing CollectionAdd {} to {}", newItem, topic);
				try {
					Preconditions.checkNotNull(channel, "AMQP channel must not be null");
					Preconditions.checkNotNull(pushJson, "pushJson must not be null");
					channel.basicPublish("amq.topic", topic, null, pushJson.getBytes());
				} catch (IOException e) {
					log.error("Cannot publish CollectionAdd " + newItem + " to " + topic, e);
				}
			}
			break;
		case Notification.REMOVE:
			if (notification.getNotifier() instanceof MenuItemContainer && notification.getOldValue() instanceof MenuItem) {
				final MenuItem oldItem = (MenuItem) notification.getOldValue();
				final String removedId = oldItem.getId();
				CollectionDelete push = new CollectionDelete(topic, removedId);
				String pushJson = JsonUtils.asJson(push);
				log.info("Publishing CollectionDelete {} to {}", removedId, topic);
				try {
					Preconditions.checkNotNull(channel, "AMQP channel must not be null");
					Preconditions.checkNotNull(pushJson, "pushJson must not be null");
					channel.basicPublish("amq.topic", topic, null, pushJson.getBytes());
				} catch (IOException e) {
					log.error("Cannot publish CollectionDelete " + removedId + " to " + topic, e);
				}
			}
			break;
		}
	}

}
