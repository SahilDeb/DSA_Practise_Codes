import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
	public static boolean canFinishUtil(List<List<Integer>> courses, int[] visited, int idx) {
		visited[idx] = 1;
		
		List<Integer> eligableCourses = courses.get(idx);
		
		for (int i = 0; i < eligableCourses.size(); i++) {
			int course = eligableCourses.get(i);
			
			if (visited[course] == 1) return false;
			
			if (visited[course] == 0) {
				if (!canFinishUtil(courses, visited, course))
					return false;
			}
		}
		
		visited[idx] = 2;
		return true;
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if(prerequisites.length == 0) return true;
		
		// create a dependency graph (prerequisite graph)
		List<List<Integer>> courses = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] visited = new int[numCourses];
        
        System.out.println(courses);
        
        // visit each course using dfs and is there is a cycle return false
        // cycle means you can't complete the prerequisite
        for (int i = 0; i < numCourses; i++) {
        	if (!canFinishUtil(courses, visited, i))
        		return false;
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 4;
		int[][] prerequisites = {{0,1},{1,0}};
		System.out.println(canFinish(numCourses, prerequisites));
	}
}
