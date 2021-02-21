//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//Return true if there is a cycle in the linked list. Otherwise, return false.
public class LinkedListCycle {

	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
	public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow != null && fast != null && fast.next != null) {           
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;           
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(3);
		l.next = new ListNode(2);
		l.next.next = new ListNode(0);
		l.next.next.next = new ListNode(-4);
		l.next.next.next.next = l.next.next;
		
		System.out.println(hasCycle(l));
	}

}
