package com.revature.arrays;

import java.util.Arrays;

public class ArrayFun {

	public static void main(String[] args) {
		/*
		//but first, some for loops
		
		int j = 1;
		int k = ++j;
		int l = j++;
		//what are j,k,l? 
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		
		for (int i =0 ;i<10;i++)
		{
			if (i==3 ) {
				//continue;
				//break would escape the loop
				break;
			}
			System.out.println(i);
		}
		*/
		
		//ARRAYS
		/*
		 * Elements must be same type, must specify array length
		 * length is immutable (block of contiguous memory is 
		 * allocated at instantiation) 
		 * Arrays can hold primitives or objects 
		 * At initialization, all elements are set to default value
		 * java.util.Arrays (note the s) for useful methods 
		 */
		
		int[] intArray1D = {5,6,7};
		int[] intArray1D2 = new int[7];
		int intArray1D3[] = new int[7];
		
		int[][] intArray2D = {{5},{6},{7,8}};
		int[][] intArray2D2 = new int[7][6];
	
		//traversing arrays
		for (int i = 0;i<intArray2D.length;i++){
			for (int j = 0;j<intArray2D[i].length;j++){
				System.out.print(intArray2D[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(intArray1D[0]);
		//Throws ArrayIndexOutOfBoundsException
		//System.out.println(intArray1D[3]);
		
		System.out.println(intArray1D);
		
		//using utility class java.util.Arrays
		System.out.println(Arrays.toString(intArray1D));
		
		int[] messyArray = {38,9,2,74,0};
		System.out.println(Arrays.toString(messyArray));
		Arrays.sort(messyArray);
		System.out.println(Arrays.toString(messyArray));
		
		//binary search
		System.out.println(Arrays.binarySearch(messyArray,2));
	}

}
