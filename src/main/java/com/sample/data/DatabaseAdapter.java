package com.sample.data;

public interface DatabaseAdapter<K extends IdData> {

	public void connect();
	
	public void disconnect();
	
	public void put(K data);
	
	public void delete(int id);
	
	public K get(int id);
	
	
}
