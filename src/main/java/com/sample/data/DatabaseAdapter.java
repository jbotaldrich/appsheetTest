package com.sample.data;

import java.util.List;

public interface DatabaseAdapter<K extends IdData> {

	public void connect();
	
	public void disconnect();
	
	public void put(K data);
	
	public void delete(int id);
	
	public List<K> scanTable(int numRecords, String token) throws NotFoundException;
	
	public K get(int id) throws NotFoundException;
	
	
}
