import java.util.HashSet;

public class LinkedListLoop {

	static class ListNode {
	    int val;
	    ListNode next;

	    public ListNode(int val) {
	        this.val = val;
	        this.next = null;
	    }
	}
	
	public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        HashSet<ListNode> visited = new HashSet<>();
        visited.add(slow);
        ListNode tail = null;
        
        // Determine tail
        while (slow != null && slow.next != null) {
        	slow = slow.next;
        	if (visited.contains(slow.next)) {
        		tail = slow;
        		System.out.println("Tail " + tail.val);
        		break;
        	}
        	else
            	visited.add(slow);
        }
        
        // Detect loop
        slow = head;
        while (fast != null && fast.next != null && slow != null) {  
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast && tail != null)
                return tail.next;
        }

        return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nodes = {1};
		int idx = -1;
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for (int i = 0; i < nodes.length; i++) {
			temp.next = new ListNode(nodes[i]);
			temp = temp.next;
		}
		
//		ListNode loop = head.next;
//		while (idx >= 0) {
//			loop = loop.next;
//			idx--;
//		}
		
//		System.out.println(loop.val);
		
//		temp.next = loop;
		head = head.next;
		System.out.println(detectCycle(head));
		
		int x = 20;
		long a = (long)x;
		System.out.println(a);

	}

}
