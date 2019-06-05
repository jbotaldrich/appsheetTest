package com.sample.data;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sample.exceptions.NotFoundException;


@SuppressWarnings("rawtypes")
public class MockDatabase<K extends IdData> implements DatabaseAdapter<K> {

	private final URI databaseURI;
	private TreeSet<K> dataStore;
	private Map<Integer, K> idPointer;
	private Map<String, K> tokenPointer;


	public MockDatabase(URI databaseURI, TreeSet<K> initialData) {
		this.databaseURI = databaseURI;
		this.dataStore = initialData;
		idPointer = new HashMap<>();
		tokenPointer = new HashMap<>();
		this.dataStore.stream().forEach(dataElement -> {
			idPointer.put(dataElement.getId(), dataElement);
			tokenPointer.put(dataElement.getToken(), dataElement);
		});
		
	}
	
	public MockDatabase(URI databaseURI, List<K> initialData) {
		idPointer = new HashMap<>();
		tokenPointer = new HashMap<>();
		this.databaseURI = databaseURI;
		this.dataStore = new TreeSet<>();
		initialData.stream().forEach(element -> this.put(element));
	}
	
	public MockDatabase() {
		this.databaseURI = URI.create("fake");
		this.dataStore = new TreeSet<K>();
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
	public void put(K data) {
		if (idPointer.containsKey(data.getId()) && data.getId() != -1) {
			idPointer.put(data.getId(), data);
		} else {
			data.setId(dataStore.isEmpty() ? 1 : dataStore.last().getId() + 1);
			data.setToken(UUID.randomUUID().toString());
			idPointer.put(data.getId(), data);
			tokenPointer.put(data.getToken(), data);
			dataStore.add(data);
		}
	}
	
	public List<K> scanTable(int numRecords, String token) throws NotFoundException {
		if(token != null && !tokenPointer.containsKey(token)) {
			throw new NotFoundException("Unknown token " + token);
		}
		int accessibleRecords = dataStore.size() < numRecords ? dataStore.size() : numRecords;
		List<K> output = new ArrayList<>();
		if(token == null) {
			output = dataStore.stream().limit(accessibleRecords).collect(Collectors.toList());
		} else {
			output = dataStore.tailSet(tokenPointer.get(token)).stream().limit(accessibleRecords).collect(Collectors.toList());
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
	public K get(int id) throws NotFoundException {
		if(!idPointer.containsKey(id)) {
			throw new NotFoundException("Unknown id passed to host " + id);
		}
		return idPointer.get(id);
	}
	
	

}
