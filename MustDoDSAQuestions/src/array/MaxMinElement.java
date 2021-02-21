package array;

import java.util.ArrayList;

public class MaxMinElement {

	public static ArrayList<Integer> maxMin(int[] arr) {
		ArrayList<Integer> res = new ArrayList<>();
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
			if (arr[i] < minVal) {
				minVal = arr[i];
			}
		}
		
		res.add(maxVal);
		res.add(minVal);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 32, 1, 23, 3};
		System.out.println(maxMin(arr));
	}

}
