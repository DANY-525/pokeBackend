package com.example.pokemonapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FotomultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FotomultaApplication.class, args);
		StringBuilder str = new StringBuilder();
		str.append("string");
		getReverseStringUsingApi(str.toString());
		getReverseStringManually(str.toString());
	}

	 public static String  getReverseStringUsingApi(String str){
		StringBuilder strIntenal = new StringBuilder(str);
		strIntenal.reverse();
		return strIntenal.toString();
	}
	public  static  String getReverseStringManually(String str){
		StringBuilder strInternal = new StringBuilder();
		for (int i = str.length()-1; i >=0 ; i--) {
			strInternal.append(str.charAt(i));
		}
		return str;
	}

}
