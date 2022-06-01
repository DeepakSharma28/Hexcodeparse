package com.miracle.hexparse.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miracle.hexparse.dto.ByteClass;
import com.miracle.hexparse.dto.DataDictionary;
import com.miracle.hexparse.dto.DictionaryClass;
import com.miracle.hexparse.exception.InsufficientNoOfBytesException;
import com.miracle.hexparse.exception.InvalidInputException;

@Service
public class ParseServiceImpl implements ParseService {

	@Autowired
	DataDictionary dataDictionary;

	private Map<String, String> map;
	private Map<String, String> hexToBinarymap;

	@PostConstruct
	void init() {
		map = new HashMap<>();
		map.put("B", "11");
		map.put("C", "12");
		map.put("D", "13");
		map.put("E", "14");
		map.put("F", "15");

		hexToBinarymap = new HashMap<>();
		hexToBinarymap.put("0", "0000");
		hexToBinarymap.put("1", "0001");
		hexToBinarymap.put("2", "0010");
		hexToBinarymap.put("3", "0011");
		hexToBinarymap.put("4", "0100");
		hexToBinarymap.put("5", "0101");
		hexToBinarymap.put("6", "0110");
		hexToBinarymap.put("7", "0111");
		hexToBinarymap.put("8", "1000");
		hexToBinarymap.put("9", "1001");
		hexToBinarymap.put("A", "1010");
		hexToBinarymap.put("B", "1011");
		hexToBinarymap.put("C", "1100");
		hexToBinarymap.put("D", "1101");
		hexToBinarymap.put("E", "1110");
		hexToBinarymap.put("F", "1111");
	}

	@Override
	public Map<String, String> parseHexCode(Map<String, String> hexCodeMap) {
		Map<String, String> parseMap = new HashMap<String, String>();
		DictionaryClass dictionaryClass = dataDictionary.getKeyMap().get(hexCodeMap.get("key"));

		String value = hexCodeMap.get("value");
		Map<Integer, String> valueMap = new HashMap<>();
		for (int i = 0, j = 0; i < value.length(); i = i + 2, j++) {
			valueMap.put(j, value.substring(i, i + 2));
		}

		for (ByteClass byteClass : dictionaryClass.getByteClassList()) {
			String bytePosition = byteClass.getBytePosition();
			String bytes = "";
			if (bytePosition.contains("-")) {
				Integer firstPosition = Integer.parseInt(bytePosition.charAt(0) + "");
				Integer lastPosition = Integer.parseInt(bytePosition.charAt(2) + "");
				for (int i = firstPosition; i <= lastPosition; i++) {
					bytes = bytes + valueMap.get(i);
				}
			} else {
				bytes = valueMap.get(Integer.parseInt(bytePosition));
				if (bytes == null || bytes.equals(""))
					throw new InsufficientNoOfBytesException(hexCodeMap.get("key"));
			}

			if (byteClass.getType().equals("Enum/UInt8")) {
				int hexToDecimal = hexToDecimal(bytes);
				parseMap.put(byteClass.getName(), byteClass.getDetailsMap().get(hexToDecimal) == null ? "Invalid input"
						: byteClass.getDetailsMap().get(hexToDecimal));
			} else if (byteClass.getType().equals("UInt8") || byteClass.getType().equals("UInt16")
					|| byteClass.getType().equals("UInt32")) {
				int hexToDecimal = hexToDecimal(bytes);
				parseMap.put(byteClass.getName(), hexToDecimal + "");
			} else if (byteClass.getType().equals("bit")) {
				boolean isbitValOne = hexToBinary(bytes, byteClass.getBitPosition());
				if (isbitValOne) {
					parseMap.put(dictionaryClass.getName(), byteClass.getName());
				}
			}

		}
		return parseMap;
	}

	private boolean hexToBinary(String bytes, String bitPosition) {
		StringBuilder hexToBinary = new StringBuilder();
		for (int i = 0; i < bytes.length(); i++) {
			String byteVal = bytes.charAt(i) + "";
			hexToBinary.append(hexToBinarymap.get(byteVal));
		}
		String binaryVal = hexToBinary.toString();
		String charVal = "";
		try {
			charVal = binaryVal.charAt(binaryVal.length() - 1 - Integer.parseInt(bitPosition)) + "";
		} catch (NumberFormatException ex) {
			throw new InvalidInputException();
		}
		if (charVal.equals("1"))
			return true;
		else
			return false;
	}

	private int hexToDecimal(String bytes) {
		int sum = 0;
		for (int i = bytes.length() - 1, j = 0; i >= 0; i--, j++) {
			String byteVal = bytes.charAt(j) + "";
			if (map.containsKey(byteVal)) {
				byteVal = map.get(byteVal);
			}
			try {
				int val = Integer.parseInt(byteVal);
				sum = (int) (sum + val * Math.pow(16, i));
			} catch (NumberFormatException ex) {
				throw new InvalidInputException();
			}
		}
		return sum;
	}

}
