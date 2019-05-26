package com.sample.dibinder;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.data.DatabaseAdapter;
import com.sample.data.MockDatabase;

public class AppBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(MockDatabase.class).to(DatabaseAdapter.class).in(Singleton.class);
		bind(new GsonBuilder().create()).to(Gson.class);

	}


}
