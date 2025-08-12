package com.webage.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.webage.domain.Customer;
import org.springframework.web.client.RestClient;


@Repository
public class ApiClientCustomersDao implements CustomersDao {

	@Value("${api.server.port}")
	String apiServerPort;

	@Value("${api.server.url}")  
	String apiServerUrl;

	private String apiUrl() {
		String url =  String.format(apiServerUrl,apiServerPort);
		System.out.println("API URL: " + url);
		return url;
	}

	//	PART 3:
	//  Alter the code in the getAllCustomers() method.
	//	Remove the hard-coded empty array of customers.
	//	Use a RestClient to make a GET call to the /customers resource on the API
	//  Use the apiUrl() method to obtain the URL to call.

	@Override
	public List<Customer> getAllCustomers() {
		RestClient restClient = RestClient.create(apiUrl());
		Customer[] customers = restClient
				.get()
				.retrieve()
				.body(Customer[].class);
		return Arrays.asList(customers);
	}

}
