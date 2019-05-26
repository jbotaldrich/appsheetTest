package com.sample.manager;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.sample.data.DatabaseAdapter;
import com.sample.data.DetailsData;

public class ApplicationManager {

	@Inject
	private DatabaseAdapter<DetailsData> adapter;
	
	@Inject
	private Gson gson;
	
	
	public DetailsData getDetails(int id) {
		return adapter.get(id);
	}
	
	
	
}
