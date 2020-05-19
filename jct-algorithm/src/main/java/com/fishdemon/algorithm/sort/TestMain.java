package com.fishdemon.algorithm.sort;

import java.util.Random;

import com.fishdemon.algorithm.sort.optimization.SelectSortOptimization1;

public class TestMain {
	
	static int[] src = {2,1,3,9,5,4};
	
	public static void main(String[] args) {
		src = generateRandomNumbers(50000);
		
		int[] temp = src.clone();
		long now = System.currentTimeMillis();
		MergeSort.sort(temp);
		System.out.println("MergeSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		InsertSort.sort(temp);
		System.out.println("InsertSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		ShellSort.sort(temp);
		System.out.println("ShellSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		SelectSort.sort(temp);
		System.out.println("SelectSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		SelectSortOptimization1.sort(temp);
		System.out.println("SelectSortOptimization1: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		HeapSort.sort(temp);
		System.out.println("HeapSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		BubbleSort.sort(temp);
		System.out.println("BubbleSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		QuickSort.sort(temp);
		System.out.println("QuickSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
		temp = src.clone();
		now = System.currentTimeMillis();
		RadixSort.sort(temp);
		System.out.println("RadixSort: spend " + (System.currentTimeMillis() - now) + " ms");
		
//		for (int i = 0; i < src.length; i++) {
//			System.out.println(src[i]);
//		}
	}
	
	private static int[] generateRandomNumbers(int number) {
		Random random = new Random();
		int[] src = new int[number];
		for(int i=0; i<number; i++) {
			src[i] = random.nextInt(100000);
		}
		return src;
	}

}
