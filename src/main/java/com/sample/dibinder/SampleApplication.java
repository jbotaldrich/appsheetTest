package com.sample.dibinder;

import org.glassfish.jersey.server.ResourceConfig;

public class SampleApplication extends ResourceConfig {
	
	public SampleApplication() {
		register(new AppBinder());
		packages(true, "com.sample.api");
	}

}
