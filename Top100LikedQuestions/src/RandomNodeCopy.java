import java.util.HashMap;
import java.util.Map;

public class RandomNodeCopy {

	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public static Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<Node, Node>();
		Node newHead = new Node(0);
		Node copy = newHead;
		
		while (head != null) {
			Node nextNode = null;
			// If we created node for curr input, get from map else put in map
			if (!map.containsKey(head)) {
				nextNode = new Node(head.val);
				map.put(head, nextNode);
			}
			else {
				nextNode = map.get(head);
			}
			
			// If map doesn't contain rand pointer node then create it else copy
			if (head.random != null && !map.containsKey(head.random)) {
				Node random = new Node(head.random.val);
				nextNode.random = random;
				map.put(head.random, random);
			}
			else {
				nextNode.random = map.get(head.random);
			}
			
			copy.next = nextNode;
			copy = copy.next;
			head = head.next;
		}
		
		return newHead.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
