package com.example.pokemonapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class FotomultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FotomultaApplication.class, args);
		StringBuilder str = new StringBuilder();
		getReverseStringUsingApi(str.toString());
		getReverseStringManually(str.toString());
		int[] a = new int[]{5,1,2,2,3,4,4};
		int[] b = new int[]{5,1,2,2,3,4,4,5,5};
		System.out.println(getOrderedArrayManually(a));
		Arrays.sort(b);
		for (int i = 0; i < b.length; i++) {
			//System.out.println(b[i]);
		}
		int highNumber =   getHighNumber(b);
		int times = getTimes(b,highNumber);
		//System.out.println("hightNumber "+ highNumber);
		//stem.out.println("times"+times);


	}


	public static int getHighNumber(int[] arr) {
		int highNumber =0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>highNumber){
				highNumber= arr[i];
			}
		}
		return highNumber;
	}

	public static int getTimes(int[] arr,int repeated){
		int counter=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == repeated){
				counter++;
			}
		}
		return counter;
	}
	public static int[]  getOrderedArrayManually(int[] arr){
		int n = arr.length;
	//6
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j <n-1-i ; j++) {
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;

				}
			}
		}

		return arr;
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
