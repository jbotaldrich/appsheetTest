package com.sample.data;

import java.util.List;

import org.glassfish.jersey.spi.Contract;

import com.sample.exceptions.NotFoundException;

@Contract
public interface DatabaseAdapter<K> {

	public void connect();
	
	public void disconnect();
	
	public void put(K data);
	
	public void delete(int id);
	
	public List<K> scanTable(int numRecords, String token) throws NotFoundException;
	
	public K get(int id) throws NotFoundException;
	
}
