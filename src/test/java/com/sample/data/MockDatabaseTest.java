package com.sample.data;

import static org.junit.Assert.fail;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.junit.Before;
import org.junit.Test;

import jersey.repackaged.com.google.common.collect.ImmutableList;

public class MockDatabaseTest {

	private static final List<DetailsData> details = ImmutableList.of(DetailsData.builder().age(16).bio("Did a bunch of stuff").id(-1).name("Senor Pajamas")
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
	private DatabaseAdapter<DetailsData> db;

	@Before
	public void setUp() throws Exception {
		
		db = new MockDatabase(UriBuilder.fromUri("FakeURI").build() ,details);
	}
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
