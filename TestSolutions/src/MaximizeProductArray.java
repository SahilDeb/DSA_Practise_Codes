import java.util.Arrays;
import java.util.PriorityQueue;

//Maximize product of array by replacing array elements with its sum or product with element from another array
//Given two arrays A[] and B[] consisting of N integers, the task is to update array A[] by assigning every array element A[i] to a single element B[j] and update A[i] to A[i] + B[j] or A[i] * B[j], such that the product of the array A[] is maximized.
//Note: Every array element in both the arrays can be paired with a single element from the other array only once.
//Sample Input 0
//3 3
//1 1 6
//1 2 3
//
//Sample Output 0
//108
//
//Explanation 0
//
//Update A[0] = A[0] + B[0], A[] modifies to {2, 1, 6}
//Update A[1] = A[1] + B[1], A[] modifies to {2, 3, 6}
//Update A[0] = A[0] * B[2], A[] modifies to {6, 3, 6}
//Therefore, the product of the array A[] is 6 * 3 * 6 = 108.
public class MaximizeProductArray {

	public static int largeProduct( int arr1[], int arr2[], int n){
        if (n == 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            pq.add(arr1[i]);
        
        System.out.println(pq);
        
        Arrays.sort(arr2);
        
        for (int i = 0; i < n; i++) {
            int minn = pq.poll();
            int maximized_element = Math.max(minn * arr2[i], minn + arr2[i]);
            pq.add(maximized_element);
            System.out.println(pq);
        }
        
        int max_product = 1;
        while (pq.size() > 0)
            max_product *= pq.poll();
        
        return max_product;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan=new Scanner(System.in);
//        int n=scan.nextInt(),m=scan.nextInt();
//        int arr1[] = new int[n];
//        int arr2[] = new int[m];
        
        int[] arr1 = {1, 1, 6};
        int[] arr2 = {1, 2, 3};
        
//        for(int i=0;i<n;i++)
//            arr1[i]=scan.nextInt();
//        
//        for(int i=0;i<m;i++)
//            arr2[i]=scan.nextInt();
        
        System.out.println(largeProduct(arr1, arr2, 3));
	}

}
