import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalViewOfBinaryTree {

	public static class Node
    {
		int key;
	    Node left, right;
	    // A utility function to create a new node
	    Node newNode(int key)
	    {
	        Node node = new Node();
	        node.key = key;
	        node.left = node.right = null;
	        return node;
	    }
    }
	
	static class Qobj {
	    int hd;
	    Node node;
	    Qobj(int hd, Node node)
	    {
	        this.hd = hd;
	        this.node = node;
	    }
	}
	
	public static List<List<Integer>> verticalTraversal(Node root) {
		if (root == null) return null;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		int hd = 0;
		
		Queue<Qobj> q = new LinkedList<Qobj>();
		q.add(new Qobj(0, root));
		
		while (!q.isEmpty()) {
			Qobj temp = q.poll();
			hd = temp.hd;
			
			Node node = temp.node;
			if (map.containsKey(hd))
				map.get(hd).add(node.key);
			else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(node.key);
				map.put(hd, al);
			}
			
			if (node.left != null)
				q.add(new Qobj(hd - 1, node.left));
			if (node.right != null)
				q.add(new Qobj(hd + 1, node.right));
		}
		
		for (Map.Entry<Integer, ArrayList<Integer> > entry : map.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
            al.sort(null);
            res.add(al);
            for (Integer i : al)
                System.out.print(i + " ");
            System.out.println();
        }
		
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node();
        Node root;
        root = n.newNode(1);
        root.left = n.newNode(2);
        root.right = n.newNode(3);
        root.left.left = n.newNode(4);
        root.left.right = n.newNode(5);
        root.right.left = n.newNode(6);
        root.right.right = n.newNode(7);
        root.right.left.right = n.newNode(8);
        root.right.right.right = n.newNode(9);
        root.right.right.left = n.newNode(10);
        root.right.right.left.right = n.newNode(11);
        root.right.right.left.right.right = n.newNode(12);
        System.out.println("Vertical order traversal is ");
        System.out.println(verticalTraversal(root));
	}

}
