package com.sample.api;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ListResponse {
	private final List<Integer> result;
	private final String token;
	
}