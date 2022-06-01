package com.miracle.hexparse.dto;

import java.util.HashMap;
import java.util.Map;

public class DataDictionary {
	Map<String,DictionaryClass> keyMap;
	public DataDictionary(){
		keyMap = new HashMap<>();
	}

	public Map<String, DictionaryClass> getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map<String, DictionaryClass> keyMap) {
		this.keyMap = keyMap;
	}
}
