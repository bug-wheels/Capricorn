package com.github.bw.capricorn.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("capricorn")
public class CapricornServerProperties {

	private boolean banner;

	public boolean isBanner() {
		return banner;
	}

	public void setBanner(boolean banner) {
		this.banner = banner;
	}
}
