package com.github.bw.capricorn.commons;

public interface ServiceRegistry<R extends ServiceInstance> {

	void register(R serviceInstance);

	void deregister(R serviceInstance);

	void setStatus(R serviceInstance, String status);

	<T> T getStatus(R serviceInstance);

}
