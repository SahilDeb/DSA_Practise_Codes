//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//Follow up: The overall run time complexity should be O(log (m+n)).
public class MedianOfArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) return 0.0;
		
        int[] merged = new int[nums1.length + nums2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            }
            else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        while (i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        
        while (j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }
        
        int mid = merged.length/2;
        double median = 0.0;
        if (merged.length%2 == 0) {
        	median = (merged[mid-1] + merged[mid])/2.0;
        }
        else {
        	median = merged[mid];
        }
        return median;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {1};
		int[] a2 = {2};
		
		System.out.println(findMedianSortedArrays(a1, a2));

	}

}
