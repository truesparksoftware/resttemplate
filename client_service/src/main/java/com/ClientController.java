package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getallbanks")
	public List<Bank> getAllBank() {
		Bank b = new Bank();
		HttpEntity entity = new HttpEntity(b);
		ResponseEntity  res = restTemplate.exchange("http://localhost:9090/bank/onebank", HttpMethod.GET, entity,
				Bank.class);

		System.out.println(res.getBody().toString());

		return null;
	}
	
	@PostMapping("/save")
	public Bank saveBank(@RequestBody Bank bank) {
		HttpEntity<Bank> entity=new HttpEntity<Bank>(bank);
		ResponseEntity  res = restTemplate.exchange("http://localhost:9090/bank/save", HttpMethod.POST, entity,
				Bank.class);
		System.out.println(res.toString());
		return null;
	}

}
