
public class SortArrayOf012 {

	public static void sort012(int a[], int n)
    {
		int lo = 0, mid = 0, hi = n - 1;
		while (mid <= hi) {
			if (a[mid] == 0) {
                int temp = a[mid];
                a[mid] = a[lo];
                a[lo] = temp;
                lo++;
            }
            else if (a[mid] == 2) {
                int temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
            }
            mid++;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {0,2,1,2,0};
		sort012(ar, ar.length);
		for (int n: ar) {
			System.out.print(n + " ");
		}
	}

}
