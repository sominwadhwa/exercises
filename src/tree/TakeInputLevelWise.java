package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputLevelWise {

	static Scanner scan = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise() {
		System.out.print("Enter Root Data: ");
		int data = scan.nextInt();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<Integer>(data);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> frontNode = queue.poll();
			System.out.print("Enter number of children of node " + frontNode.data + ": ");
			int numChildren = scan.nextInt();
			for (int i = 0; i < numChildren; i++) {
				System.out.print("Enter " + (i + 1) + "th child of " + frontNode.data + ": ");
				int child = scan.nextInt();
				TreeNode<Integer> node = new TreeNode<Integer>(child);
				frontNode.children.add(node);
				queue.add(node);
			}
		}
		return root;
	}

	public static void printLevelWise(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> frontNode = queue.poll();
			String s = frontNode.data + ": ";
			int numChildren = frontNode.children.size();
			for (int i = 0; i < numChildren; i++) {
				s += frontNode.children.get(i).data + ", ";
				queue.add(frontNode.children.get(i));
			}
			System.out.println(s);
		}
	}
	
	public static int findTotalNumberOfNodes(TreeNode<Integer> node) {
		if (node == null)
			return 0; //Edge Case
		int count = 1;
		for (int i = 0; i < node.children.size(); i++) {
			count += findTotalNumberOfNodes(node.children.get(i));
		}
		return count;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		System.out.println(findTotalNumberOfNodes (root));
	}
}
