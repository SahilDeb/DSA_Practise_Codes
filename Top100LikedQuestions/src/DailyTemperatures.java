import java.util.Stack;

public class DailyTemperatures {

	public static int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
        Stack<Integer> st = new Stack<Integer>();        
        for (int i = T.length - 1; i >= 0; i--) {
        	while (!st.isEmpty() && T[i] >= T[st.peek()])
        		st.pop();
        	
        	res[i] = st.isEmpty() ? 0 : st.peek() - i;
        	st.push(i);
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {89,62,70,58,47,47,46,76,100,70};
		System.out.println(dailyTemperatures(arr));

	}

}
