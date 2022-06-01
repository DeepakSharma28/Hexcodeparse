package com.miracle.hexparse.dto;

import java.util.ArrayList;
import java.util.List;

public class DictionaryClass {
	
	String name;
	String length;
	List<ByteClass> byteClassList;
	public DictionaryClass(String name, String length) {
		this.name = name;
		this.length = length;
		byteClassList = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public List<ByteClass> getByteClassList() {
		return byteClassList;
	}
	public void setByteClassList(List<ByteClass> byteClassList) {
		this.byteClassList = byteClassList;
	}
	

}
