package com.fishdemon.serialize;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
    	
    	Set<Integer> set = new HashSet<>();
    	
        // 输入语句
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        for (int i=0; i< input.length(); i++) {
            char c = input.charAt(i);
            if (c < 'A' || (c > 'Z' && c < 'a') || c > 'z') {
            	input = input.replace(c , ' ');
            }
        }
        String[] arr = input.split(" ");
       
        List<String> list = new ArrayList<String>();
        for (String e : arr) {
        	if (!e.isEmpty()) {
        		list.add(e);
        	}
        }
        arr = list.toArray(new String[0]);
        
        
        for (int i = 0; i< arr.length/2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        
        for (int i = 0; i<arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length-1]);
    }
}