import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {

	public static int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        
        if (tasks.length == 0)
        	return 0;
        
        int[] freq = new int[26];
        for (char ch: tasks) {
        	freq[ch - 'A'] += 1;
        }
        
        Arrays.sort(freq);
        
        int maxFreq = freq[25] - 1; // -1 as we don't want any idle state if we are at end
        
        int availableIdleSlot = maxFreq * n; // this many idle slots will be available
        
        for (int i = 24; i >= 0; i--) {
        	availableIdleSlot -= Math.min(maxFreq, freq[i]);
        }
        
        return availableIdleSlot > 0 ? availableIdleSlot + tasks.length : tasks.length;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] tasks = {'A','A','A','A','A','B','B','C','D','E','F','G'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}

}
