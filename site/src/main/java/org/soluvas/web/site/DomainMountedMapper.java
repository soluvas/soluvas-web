package org.soluvas.web.site;

import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.mapper.parameter.IPageParametersEncoder;
import org.apache.wicket.util.IProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;

/**
 * Mounts a page that works only for specific domain(s).
 * @author ceefour
 */
public class DomainMountedMapper extends MountedMapper {

	private static final Logger log = LoggerFactory
			.getLogger(DomainMountedMapper.class);
	private final ImmutableSet<String> domains;

	/**
	 * @param mountPath
	 * @param pageClass
	 */
	public DomainMountedMapper(String domain, String mountPath,
			Class<? extends IRequestablePage> pageClass) {
		this(ImmutableSet.of(domain), mountPath, pageClass);
	}

	/**
	 * @param mountPath
	 * @param pageClassProvider
	 */
	public DomainMountedMapper(String domain, String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider) {
		this(ImmutableSet.of(domain), mountPath, pageClassProvider);
	}

	/**
	 * @param mountPath
	 * @param pageClass
	 * @param pageParametersEncoder
	 */
	public DomainMountedMapper(String domain, String mountPath,
			Class<? extends IRequestablePage> pageClass,
			IPageParametersEncoder pageParametersEncoder) {
		this(ImmutableSet.of(domain), mountPath, pageClass, pageParametersEncoder);
	}

	/**
	 * @param mountPath
	 * @param pageClassProvider
	 * @param pageParametersEncoder
	 */
	public DomainMountedMapper(String domain, String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider,
			IPageParametersEncoder pageParametersEncoder) {
		this(ImmutableSet.of(domain), mountPath, pageClassProvider, pageParametersEncoder);
	}

	/**
	 * @param mountPath
	 * @param pageClass
	 */
	public DomainMountedMapper(ImmutableSet<String> domains, String mountPath,
			Class<? extends IRequestablePage> pageClass) {
		super(mountPath, pageClass);
		this.domains = domains;
	}

	/**
	 * @param mountPath
	 * @param pageClassProvider
	 */
	public DomainMountedMapper(ImmutableSet<String> domains, String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider) {
		super(mountPath, pageClassProvider);
		this.domains = domains;
	}

	/**
	 * @param mountPath
	 * @param pageClass
	 * @param pageParametersEncoder
	 */
	public DomainMountedMapper(ImmutableSet<String> domains, String mountPath,
			Class<? extends IRequestablePage> pageClass,
			IPageParametersEncoder pageParametersEncoder) {
		super(mountPath, pageClass, pageParametersEncoder);
		this.domains = domains;
	}

	/**
	 * @param mountPath
	 * @param pageClassProvider
	 * @param pageParametersEncoder
	 */
	public DomainMountedMapper(ImmutableSet<String> domains, String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider,
			IPageParametersEncoder pageParametersEncoder) {
		super(mountPath, pageClassProvider, pageParametersEncoder);
		this.domains = domains;
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		final String origHost = request.getUrl().getHost();
		final String canonicalHost = origHost.startsWith("www.") ? origHost.substring(4) : origHost;
		log.trace("Canonical Host: {} (from {}) for {}", canonicalHost, origHost, request.getUrl());
		if (domains.contains(canonicalHost)) {
			return super.parseRequest(request);
		} else {
			return null;
		}
	}

}
