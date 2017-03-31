package com.revature.arrays;

import java.util.Arrays;

public class ArrayFun {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		
		int j = 1;
		int k = ++j;
		int l = j++;
		
		//what are j, k, l?
		//System.out.println(j + " " + k + " " + l);
		
		//for loops
		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				continue;
			}
			else if (i == 7) {
				break;
			}
			else {
				//System.out.println(i);
			}
		}
		
		
		int[] intArray1D = {5, 6, 7};
		int[] inArray1D2 = new int[7];
		int intArray1D3[] = new int[7]; //technically allowed, but try to avoid this
		
		int[][] intArray2D = {{5},{6},{7 , 8}};
		int[][] intArray2D2 = new int[7][6];
		int[] intArray2D3[] = new int [7][6]; //allowed, but discouraged
		
		//traversing 2D arrays
		for (int i = 0; i < intArray2D.length; i++) {
			for (int m = 0; m < intArray2D[i].length; m++) {
				System.out.println(intArray2D[i][m] + " ");
			}
			System.out.println("");
		}
		
		System.out.println(intArray1D[0]);
		//throws ArrayIndexOutOfBoundsException
		
		System.out.println(intArray1D);
		
		//using java.util.Arrays
		System.out.println(Arrays.toString(intArray1D));
		
		int[] messyArray = {38,9,2,74,0};
		
		Arrays.sort(messyArray);
		
		System.out.println(Arrays.toString(messyArray));
		
		//binary search
		System.out.println(Arrays.binarySearch(messyArray, 2));
	}

}
