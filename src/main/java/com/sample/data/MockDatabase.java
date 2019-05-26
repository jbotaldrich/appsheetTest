package com.sample.data;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;


public class MockDatabase implements DatabaseAdapter {

	private final URI databaseURI;
	private TreeSet<IdData> dataStore;
	private Map<Integer, IdData> idPointer;
	private Map<String, IdData> tokenPointer;


	public MockDatabase(URI databaseURI, TreeSet<IdData> initialData) {
		this.databaseURI = databaseURI;
		this.dataStore = initialData;
		idPointer = new HashMap<>();
		tokenPointer = new HashMap<>();
		this.dataStore.stream().forEach(dataElement -> {
			idPointer.put(dataElement.getId(), dataElement);
			tokenPointer.put(dataElement.getToken(), dataElement);
		});
		
	}
	
	
	
	
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
	
	public List<IdData> scanTable(int numRecords, String token) throws NotFoundException {
		if(!tokenPointer.containsKey(token)) {
			throw new NotFoundException("Unknown token " + token);
		}
		List<IdData> output = new ArrayList<>();
		if(token == null) {
			output = dataStore.stream().limit(numRecords).collect(Collectors.toList());
		} else {
			output = dataStore.tailSet(tokenPointer.get(token)).stream().limit(numRecords).collect(Collectors.toList());
		}
		return output;
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
	public IdData get(int id) throws NotFoundException {
		if(!idPointer.containsKey(id)) {
			throw new NotFoundException("Unknown id passed to host " + id);
		}
		return idPointer.get(id);
	}
	
	

}
