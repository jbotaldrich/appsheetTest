package com.sample.manager;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.sample.api.DetailsResponse;
import com.sample.api.ListResponse;
import com.sample.data.DatabaseAdapter;
import com.sample.data.DetailsData;
import com.sample.data.MockDatabase;
import com.sample.exceptions.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class ApplicationManager {

	private static final int MAX_NUM_RECORDS = 10;

	
	private final DatabaseAdapter<DetailsData> adapter;
	private final Gson gson;

	public String getDetails(int id) throws NotFoundException {
		DetailsData data = adapter.get(id);
		DetailsResponse result = DetailsResponse.builder().id(data.getId()).age(data.getAge()).bio(data.getBio())
				.image(data.getPhoto()).name(data.getName()).phoneNumber(data.getPhoneNumber()).build();
		return gson.toJson(result);

	}

	public String listIds() throws NotFoundException {
		return listIds(null);

	}

	public String listIds(String token) throws NotFoundException {
		List<DetailsData> detailsData = adapter.scanTable(MAX_NUM_RECORDS + 1, token);
		
		List<Integer> ids = detailsData.stream().limit(MAX_NUM_RECORDS).map(DetailsData::getId)
				.collect(Collectors.toList());
		String newToken = detailsData.size() > MAX_NUM_RECORDS ? detailsData.get(MAX_NUM_RECORDS).getToken() : null;
		return gson.toJson(new ListResponse(ids, newToken));
	}

}
