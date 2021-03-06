
public class ReverseLinkedList {

	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
	}
	
	static ListNode newHead;
	public static ListNode reverseListUtil(ListNode node) {
        if (node.next == null) {
            newHead = node;
            return node;
        }
        
        ListNode ret = reverseListUtil(node.next);
        System.out.println(ret.val + "->" + node.val);
        ret.next = node;
        return node;
    }
    
    public static ListNode reverseList(ListNode head) {
    	if (head == null) return null;
        ListNode ret = reverseListUtil(head);
        ret.next = null;
        return newHead;
    }
    
    public static void printList(ListNode head) {
    	while (head != null) {
    		System.out.print(head.val + "->");
    		head = head.next;
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		head = reverseList(head);
		printList(head);
	}

}
