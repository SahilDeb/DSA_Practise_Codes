package array;

public class KthMaxMinElement {

	public static int kthLargest(int[] arr, int low, int high, int k) {
        while(low < high){
            int p = largeElementpartition(arr, low, high);
            if(p == k - 1){
				// k-th largest element is at the correct position
                return arr[p];
            }
            else if(p < k - 1){
				// number must be on right side of partition
                low = p + 1;
            }
            else{
				// number must be on left side of partition
                high = p - 1;
            }
        }
        return arr[low];
    }
	
	// Using Randomized QuickSort, Best case is O(n), worse case O(n^2)
	public static int kthSmallest(int arr[], int l, int r, int k) {
		if (k > 0 && k <= r - l + 1) {
			int pos = smallElementPartition(arr, l, r);
			
			if (pos-l == k-1) {
				return arr[pos];
			}
			
			if (pos-l > k-1) {
				return kthSmallest(arr, l, pos-1, k);
			}
			return kthSmallest(arr, pos+1, r, k-pos+l-1);
		}
		return Integer.MAX_VALUE;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int largeElementpartition(int[] arr, int l, int r){
        swap(arr, l, getRandomPivot(l, r));
        int pivot = arr[l];
        int i = l;
        for(int j = l + 1; j <= r; j++){
            if(arr[j] > pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, i);
        return i;
    }
	
	public static int smallElementPartition(int[] arr, int l, int r) {
		swap(arr, l + getRandomPivot(l, r), r);
		// Considering last element as Pivot
		int x = arr[r];
		int i = l;
		for (int j = l; j <= r-1; j++) {
			if (arr[j] <= x) {
				swap(arr, i, j);
				i++;
			}
		}
		// At last swap to place the last element at correct position in the array
		swap(arr, i, r);
		return i;
	}
	
	public static int getRandomPivot(int l, int r) {
		int n = r-l+1;
		int pivot = (int)((Math.random()) * (n-1));
		return pivot;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 10, 4, 3, 20, 15};
		System.out.println(kthSmallest(arr, 0, arr.length-1, 3));
		System.out.println(kthLargest(arr, 0, arr.length-1, 2));
	}

}
