
public class SortLL {

	static ListNode head = null;
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
	}
	
	public static ListNode merge(ListNode n1, ListNode n2) {
		if (n1 == null)
			return n2;
		
		if (n2 == null)
			return n1;
		
		ListNode res = null;
		if (n1.val <= n2.val) {
			res = n1;
			res.next = merge(n1.next, n2);
		}
		else {
			res = n2;
			res.next = merge(n1, n2.next);
		}
		
		return res;
	}
	
	public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        
        
        ListNode mid = getMiddle(head);
        ListNode nextOfMid = mid.next;
        
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMid);
        
        ListNode sortedHead = merge(left, right);
        
        return sortedHead;
    }
	
	public static ListNode getMiddle(ListNode head) {
		if (head == null) return head;
		
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static void push(int new_data) 
    { 
		ListNode new_node = new ListNode(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
