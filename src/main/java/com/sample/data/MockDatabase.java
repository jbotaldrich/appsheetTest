package com.sample.data;

import java.net.URI;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MockDatabase implements DatabaseAdapter {

	private final URI databaseURI;
	private TreeSet<IdData> dataStore;
	private Map<Integer, IdData> idPointer;
	private Map<String, IdData> tokenPointer;

	
	
	@Override
	public void connect() {
		System.out.println(String.format("Connecting to database %s, beep boop.", databaseURI.toASCIIString()));

	}

	@Override
	public void disconnect() {
		System.out.println(String.format("Disconnecting from database %s, beep boop.", databaseURI.toASCIIString()));

	}

	@Override
	public void put(IdData data) {
		if (idPointer.containsKey(data.getId()) && data.getId() != -1) {
			IdData oldData = idPointer.get(data.getId());
			oldData = data;
		} else {
			data.setId(dataStore.last().getId() + 1);
			data.setToken(UUID.randomUUID().toString());
			idPointer.put(data.getId(), data);
			tokenPointer.put(data.getToken(), data);
		}
		

	}

	@Override
	public void delete(int id) {
		IdData data = idPointer.get(id);
		String token = data.getToken();
		dataStore.remove(data);
		idPointer.remove(id);
		tokenPointer.remove(token);
		
		

	}

	@Override
	public IdData get(int id) {
		return idPointer.get(id);
	}
	
	

}
