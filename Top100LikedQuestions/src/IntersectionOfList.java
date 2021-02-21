
public class IntersectionOfList {

	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 val = x;
		 next = null;
		 }
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headB;
		
		int l1 = 0, l2 = 0;
		while (p1 != null) {
			p1 = p1.next;
			l1++;
		}
		
		while (p2 != null) {
			p2 = p2.next;
			l2++;
		}
		
		p1 = headA;
		p2 = headB;
		// equalize the length of 2 lists
		if (l1 > l2) {
			int diff = l1 - l2;
			while (diff != 0) {
				p1 = p1.next;
				diff--;
			}
		}
		else {
			int diff = l2 - l1;
			while (diff != 0) {
				p2 = p2.next;
				diff--;
			}
		}
		
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
