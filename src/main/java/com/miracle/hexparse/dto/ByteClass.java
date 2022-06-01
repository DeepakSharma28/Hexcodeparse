package com.miracle.hexparse.dto;

import java.util.HashMap;
import java.util.Map;

public class ByteClass {
	String bytePosition;	
	String bitPosition;	
	String name;	
	String type;	
	Map<Integer,String> detailsMap;
	
	public ByteClass(String bytePosition, String bitPosition, String name, String type) {
		this.bytePosition = bytePosition;	
		this.bitPosition = bitPosition;	
		this.name= name;	
		this.type= type;	
		this.detailsMap= new HashMap<>();
	}
	
	public String getBytePosition() {
		return bytePosition;
	}
	public void setBytePosition(String bytePosition) {
		this.bytePosition = bytePosition;
	}
	public String getBitPosition() {
		return bitPosition;
	}
	public void setBitPosition(String bitPosition) {
		this.bitPosition = bitPosition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<Integer, String> getDetailsMap() {
		return detailsMap;
	}
	public void setDetailsMap(Map<Integer, String> detailsMap) {
		this.detailsMap = detailsMap;
	}
}
