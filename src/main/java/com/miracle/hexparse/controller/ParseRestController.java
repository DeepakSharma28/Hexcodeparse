package com.miracle.hexparse.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.hexparse.dto.DataDictionary;
import com.miracle.hexparse.service.ParseService;

@RestController
public class ParseRestController {
	
	@Autowired
	private ParseService parseServiceImpl;
	
	@Autowired
	DataDictionary dataDictionary;

	@PostMapping(value = "parse")
	public Map<String,String> parseHexCode(@RequestBody Map<String,String> hexCodeMap) {
		
		return parseServiceImpl.parseHexCode(hexCodeMap);
	}
	
	@GetMapping(value = "data")
	public DataDictionary getData() {
		return dataDictionary;
	}
	
}
