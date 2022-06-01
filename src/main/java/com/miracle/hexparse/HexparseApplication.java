package com.miracle.hexparse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.miracle.hexparse.dto.ByteClass;
import com.miracle.hexparse.dto.DataDictionary;
import com.miracle.hexparse.dto.DictionaryClass;

@SpringBootApplication
public class HexparseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexparseApplication.class, args);
	}

	@Bean
	DataDictionary getDataDictionary() {
		DataDictionary dataDictionary = new DataDictionary();
		//key 0000001
		DictionaryClass dictionaryClass =  getDictionaryClass("Door Status","1 byte");
		ByteClass byteClass = getByteClass("0","-","Door Status","Enum/UInt8");
		byteClass.getDetailsMap().put(0, "Closed");
		byteClass.getDetailsMap().put(1, "Open");
		dictionaryClass.getByteClassList().add(byteClass);
		dataDictionary.getKeyMap().put("0000001",dictionaryClass );
		
		//key 0000002
		DictionaryClass dictionaryClass2 =  getDictionaryClass("Cooking Notifications","1 byte");
		ByteClass byteClass2 = getByteClass("0","0","Target Temperature Achieved","bit");
		ByteClass byteClass3 = getByteClass("0","1","Cooking Started","bit");
		ByteClass byteClass4 = getByteClass("0","2","Cooktime One Minute Remaining","bit");
		ByteClass byteClass5 = getByteClass("0","3","Cooking Complete","bit");
		ByteClass byteClass6 = getByteClass("0","4-7","n/a","unused");

		dictionaryClass2.getByteClassList().add(byteClass2);
		dictionaryClass2.getByteClassList().add(byteClass3);
		dictionaryClass2.getByteClassList().add(byteClass4);
		dictionaryClass2.getByteClassList().add(byteClass5);
		dictionaryClass2.getByteClassList().add(byteClass6);
		dataDictionary.getKeyMap().put("0000002", dictionaryClass2);
		
		//key 0000004
		DictionaryClass dictionaryClass3 =  getDictionaryClass("Current Cooking Parameters","11 byte");
		
		ByteClass byteClass7 = getByteClass("0","0","Shade","UInt8");
		ByteClass byteClass8 = getByteClass("1","0","Size","Enum/UInt8");
		byteClass8.getDetailsMap().put(0, "Small");
		byteClass8.getDetailsMap().put(1, "Medium");
		byteClass8.getDetailsMap().put(2, "Large");
		
		ByteClass byteClass9 = getByteClass("2-3","0","Temperature (F)","UInt16");
		ByteClass byteClass10 = getByteClass("4-7","-","Cook Time (Seconds)","UInt32");
		ByteClass byteClass11 = getByteClass("8","-","Count","UInt8");
		ByteClass byteClass12 = getByteClass("9","-","Cook Mode","Enum/UInt8");
		byteClass12.getDetailsMap().put(0, "Air Fry");
		byteClass12.getDetailsMap().put(1, "Bake");
		byteClass12.getDetailsMap().put(2, "Broil");
		byteClass12.getDetailsMap().put(3, "Roast");
		byteClass12.getDetailsMap().put(4, "Reheat");
		byteClass12.getDetailsMap().put(5, "Warm");
		byteClass12.getDetailsMap().put(6, "Slow Cook");
		byteClass12.getDetailsMap().put(7, "Dehydrate");
		byteClass12.getDetailsMap().put(8, "Proof");
		byteClass12.getDetailsMap().put(9, "Cookie");
		byteClass12.getDetailsMap().put(10, "Pizza");
		byteClass12.getDetailsMap().put(11, "Bagel");
		byteClass12.getDetailsMap().put(12, "Toast");
		byteClass12.getDetailsMap().put(13, "Crisp Finish");
		byteClass12.getDetailsMap().put(14, "Cake");
		byteClass12.getDetailsMap().put(15, "Cookie with Preference");
		byteClass12.getDetailsMap().put(16, "Pizza with Preference");

		ByteClass byteClass13 = getByteClass("10","-","Preferences","UInt8");
		ByteClass byteClass14 = getByteClass("11","-","n/a","unused");
		dictionaryClass3.getByteClassList().add(byteClass7);
		dictionaryClass3.getByteClassList().add(byteClass8);
		dictionaryClass3.getByteClassList().add(byteClass9);
		dictionaryClass3.getByteClassList().add(byteClass10);
		dictionaryClass3.getByteClassList().add(byteClass11);
		dictionaryClass3.getByteClassList().add(byteClass12);
		dictionaryClass3.getByteClassList().add(byteClass13);
		dictionaryClass3.getByteClassList().add(byteClass14);


		
		dataDictionary.getKeyMap().put("0000004",dictionaryClass3);
		return dataDictionary;
	}

	
	DictionaryClass getDictionaryClass(String name , String length) {
		return new DictionaryClass( name , length);		
	}


	ByteClass getByteClass(String bytePosition, String bitPosition, String name, String type) {
		return new ByteClass(bytePosition, bitPosition, name, type);
	}

}
