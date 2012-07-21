// Stomp via SockJS
jQuery(document).ready(function() {

	WebSocketStompMock = SockJS;
	client = Stomp.client('http://' + window.location.hostname + ':55674/stomp');
	client.debug = function(x) { console.debug(x); };
	
	MenuItem = Backbone.Model.extend({});
	MenuItemList = Backbone.Collection.extend({
		model: MenuItem,
		initialize: function() {
			_.bindAll(this);
		}
	});
	SidebarMenuItemView = Backbone.View.extend({
		model: MenuItem,
		initialize: function() {
			_.bindAll(this);
			this.model.view = this; // code smell?
			this.model.on('remove', this.onRemove);
		},
		render: function() {
			this.$el.attr('id', '#sidebar-nav-item-' + this.model.id).text(this.model.get('label'));
			return this;
		},
		onRemove: function(item, collection) {
			this.remove();
		}
	});
	SidebarNavView = Backbone.View.extend({
		model: MenuItemList,
		initialize: function() {
			_.bindAll(this);
			this.model.on('reset', this.attachViews);
			this.model.on('add', this.addItemView);
		},
		attachViews: function() {
			this.model.each( function(item) {
				console.log('attaching', item);
				var view = new SidebarMenuItemView({model: item, el: $('#sidebar-nav-item-' + item.id)});
				view.render();
			});
		},
		addItemView: function(item, collection) {
			var el = $('<li>');
			var view = new SidebarMenuItemView({model: item, el: el}).render();
			var newIndex = collection.indexOf(item);
			var nextItem = collection.at(newIndex + 1);
			if (nextItem == undefined) {
				this.$el.append(el);
			} else {
				nextItem.view.$el.before(el);
			}
		},
	});
	sidebarMenuItems = new MenuItemList();
	var sidebarNavView = new SidebarNavView({model: sidebarMenuItems, el: $('.sidebar-nav .nav')});
	
	// this must be AFTER the sidebarNavView is created
	sidebarMenuItems.reset([{id: 'checkin', label: 'Checkin'}, {id: 'processList', label: 'Process List'}]);

	client.connect('guest', 'guest', function(x) {
		client.subscribe("/topic/notify", function(d) {
			$('#notify-container').notify('create', JSON.parse(d.body));
		});

		client.subscribe("/topic/menu.main", function(d) {
			var message = JSON.parse(d.body);
			if (message['@class'] == 'org.soluvas.push.CollectionAdd') {
				sidebarMenuItems.add(message.entry, {at: message.position});
			}
			if (message['@class'] == 'org.soluvas.push.CollectionUpdate') {
//				productCategories.get(message.entryId).set(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionDelete') {
				sidebarMenuItems.remove(message.entryId);
			}
		});
	
		client.subscribe("/topic/product_category", function(d) {
			var message = JSON.parse(d.body);
			console.debug('product_category push', message);
			if (message['@class'] == 'org.soluvas.push.CollectionAdd') {
				productCategories.add(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionUpdate') {
				productCategories.get(message.entryId).set(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionDelete') {
				productCategories.remove(message.entryId);
			}
		});
		
		client.subscribe("/topic/product", function(d) {
			var message = JSON.parse(d.body);
			console.debug('product push', message);
			if (message['@class'] == 'org.soluvas.push.CollectionAdd') {
				featuredProducts.add(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionUpdate') {
				featuredProducts.get(message.entryId).set(message.entry);
			}
			if (message['@class'] == 'org.soluvas.push.CollectionDelete') {
				featuredProducts.remove(message.entryId);
			}
		});
		
	});

});
