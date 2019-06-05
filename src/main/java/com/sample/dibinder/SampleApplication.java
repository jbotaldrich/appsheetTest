package com.sample.dibinder;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.CORSFilter;
import com.sample.api.DetailsApi;
import com.sample.api.ListApi;
import com.sample.data.DatabaseAdapter;
import com.sample.data.DetailsData;
import com.sample.data.MockDatabase;
import com.sample.manager.ApplicationManager;

public class SampleApplication extends ResourceConfig {

	public SampleApplication() {
		register(DetailsApi.class);
		register(ListApi.class);
		register(ApplicationManager.class);
		register(CORSFilter.class);
		register(new AbstractBinder() {

			@Override
			protected void configure() {
				Class<? super MockDatabase<DetailsData>> clazz;

				bindAsContract(ApplicationManager.class);
				bind(new MockDatabase<DetailsData>(UriBuilder.fromUri("fakedb").build(), getMockData())).to(new TypeLiteral<DatabaseAdapter<DetailsData>>() {
				});
				bind(new GsonBuilder().create()).to(Gson.class);
			}
		});
		packages(true, "com.sample.api");
	}

	private List<DetailsData> getMockData() {
		return ImmutableList.of(DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Senor Pajamas")
				.phoneNumber("2065650212").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("David Pajamas")
				.phoneNumber("2065650212").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Jenny Pajamas")
				.phoneNumber("2065650332").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Dilbert Zelby")
				.phoneNumber("2063232212").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Shnar Donder")
				.phoneNumber("2065453212").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Kevin Will")
				.phoneNumber("2065643534").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Will Bass")
				.phoneNumber("2065345342").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Jane Doe")
				.phoneNumber("2068769896").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("John Doy")
				.phoneNumber("2069879896").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Snap Adams")
				.phoneNumber("2069877688").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Cookie Mondster")
				.phoneNumber("2065888888").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Flip Flop")
				.phoneNumber("2065867888").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Shoop Adoop")
				.phoneNumber("2063456836").photo("SomeUrl").token(null).build(),
				DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Major Major")
				.phoneNumber("2065654356").photo("SomeUrl").token(null).build());
	}

}
