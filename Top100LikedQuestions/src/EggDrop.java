
public class EggDrop {

	public static int eggDrop(int e, int f, int[][] qb) {
		if (f == 1 || f == 0)
			return f;
		
		if (e == 1)
			return f;
		
		if (qb[e][f] != 0) return qb[e][f];
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= f; i++) {
			int effort = Math.max(eggDrop(e-1, i-1, qb), eggDrop(e, f-i, qb));
			min = Math.min(min, effort);
		}
		
		return qb[e][f] = min + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int eggs = 1;
		int floors = 2;
		int[][] qb = new int[eggs+1][floors+1];
		System.out.println(eggDrop(eggs, floors, qb));

	}

}
