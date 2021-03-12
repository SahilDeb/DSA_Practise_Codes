import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Two Steps :
// Step 1. Sort the people based on heights in descending order. 
// If they have the same heights, sort them based on their index in ascending order.
// We sort the people with the same heights in ascending order index-wise because
// we want smaller index people come before others of the same height.
//
// Step 2. Add the person to the resulting array one by one.
// This is exactly similar to adding the tallest group first, and then the second tallest group
// (We are adding them one by one anyway in each group). k is the index where each person should be.
public class QueueReconstruction {

	public static int[][] reconstructQueue(int[][] people) {
		int n = people.length;
		List<int[]> res = new ArrayList<int[]>(); 
		
		// For step 1, we need a comparator to do this
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if (p1[0] != p2[0])
					return p2[0] - p1[0]; // Descending order
				else
					return p1[1] - p2[1]; // Same height, then sort in ascending order of k
			}
		});
		
		// Better runtime
		// Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0]-a[0] : a[1] — b[1]);
		
		// Step 2, add people[i] to its correct position based on k
		for (int i = 0; i < n; i++) {
			res.add(people[i][1], people[i]);
		}
		
		return res.toArray(new int[n][2]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] persons = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] res = reconstructQueue(persons);
		for (int[] p: persons) {
			System.out.print("(" + p[0] + "," + p[1] + ") -> ");
		}
		System.out.println();
		for (int[] p: res) {
			System.out.print("(" + p[0] + "," + p[1] + ") -> ");
		}
	}

}
