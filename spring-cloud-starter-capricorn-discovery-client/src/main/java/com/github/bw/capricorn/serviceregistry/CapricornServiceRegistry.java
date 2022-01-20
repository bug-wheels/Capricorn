package com.github.bw.capricorn.serviceregistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;

/**
 * @author Spencer Gibb
 */
public class CapricornServiceRegistry implements ServiceRegistry<CapricornRegistration> {

	private static final Logger logger = LoggerFactory.getLogger(CapricornServiceRegistry.class);

	@Override
	public void register(CapricornRegistration registration) {

	}

	@Override
	public void deregister(CapricornRegistration registration) {

	}

	@Override
	public void close() {

	}

	@Override
	public void setStatus(CapricornRegistration registration, String status) {

	}

	@Override
	public <T> T getStatus(CapricornRegistration registration) {
		return null;
	}
}
