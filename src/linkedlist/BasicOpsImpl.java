package linkedlist;

import java.util.HashSet;

class LinkedList {

	Node head;

	public LinkedList mergeSortedLists(LinkedList list2) {

		Node head1 = this.head;
		Node head2 = list2.head;

		LinkedList list = new LinkedList();

		if (head1.data < head2.data) {
			list.insertElement(head1.data);
			head1 = head1.next;
		} else {
			list.insertElement(head2.data);
			head2 = head2.next;
		}

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				list.insertElement(head1.data);
				head1 = head1.next;
			} else {
				list.insertElement(head2.data);
				head2 = head2.next;
			}
		}

		while (head1 != null) {
			list.insertElement(head1.data);
			head1 = head1.next;
		}
		while (head2 != null) {
			list.insertElement(head2.data);
			head2 = head2.next;
		}

		return list;
	}

	public void unionOfLists(LinkedList list_temp) {
		Node currHead = this.head;
		HashSet<Integer> set = new HashSet<Integer>();
		while (currHead.next != null) {
			set.add(currHead.data);
			currHead = currHead.next;
		}
		set.add(currHead.data);
		Node tempHead = list_temp.head;
		while (tempHead != null) {
			if (!set.contains(tempHead.data)) {
				set.add(tempHead.data);
				currHead.next = new Node(tempHead.data);
				tempHead = tempHead.next;
				currHead = currHead.next;
			} else
				tempHead = tempHead.next;
		}
	}

	public void deleteMAfterN(int m, int n) {

		if (this.head == null)
			return;

		Node fastNode = this.head;
		Node prevNode = null;
		int i = 0;
		int j = 0;

		while (fastNode != null) {
			while (i < m && fastNode != null) {
				i++;
				prevNode = fastNode;
				fastNode = fastNode.next;
			}
			while (j < n && fastNode != null) {
				j++;
				fastNode = fastNode.next;
			}
			prevNode.next = fastNode;
			i = 0;
			j = 0;
		}
	}

	public void lastElementToFirstPosition() {
		Node tempHead = this.head;
		while (tempHead.next.next != null) {
			tempHead = tempHead.next;
		}
		tempHead.next.next = this.head;
		this.head = tempHead.next;
		tempHead.next = null;
	}

	public void alternatingReversedArrangement() {
		this.reverseList();

		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();

		Node tempHead = this.head;
		int index = 0;
		while (tempHead != null) {
			if (index % 2 == 0) {
				list1.insertElement(tempHead.data);
			} else {
				list2.insertElement(tempHead.data);
			}
			index++;
			tempHead = tempHead.next;
		}

		list1.printList();
		list2.printList();
	}

	public void oddEvenArrangement() {
		LinkedList oddList = new LinkedList();
		LinkedList evenList = new LinkedList();

		Node currHead = this.head;

		while (currHead != null) {
			if (currHead.data % 2 == 0) {
				evenList.insertElement(currHead.data);
			} else {
				oddList.insertElement(currHead.data);
			}
			currHead = currHead.next;
		}
		Node oddHead = oddList.head;
		while (oddHead.next != null)
			oddHead = oddHead.next;
		oddHead.next = evenList.head;

		this.head = oddList.head;
	}

	public void reverseAtInterval(int k) {
		if (k >= this.getSize()) {
			this.reverseList();
			return;
		}

		LinkedList tempList = new LinkedList();

		Node currNode = this.head;
		Node prevNode = null;
		Node nextNode = null;

		while (currNode != null) {

			int counter = 1;
			while (counter <= k && currNode != null) {
				counter++;
				nextNode = currNode.next;
				currNode.next = prevNode;
				prevNode = currNode;
				currNode = nextNode;
			}

			while (prevNode != null) {
				tempList.insertElement(prevNode.data);
				prevNode = prevNode.next;
			}
			counter = 1;
			prevNode = null;
			nextNode = null;
		}

		this.head = tempList.head;
	}

	public void swapTwoElements(int i, int j) {
		Node i_node = null;
		Node j_node = null;
		Node temp = this.head;
		int index = 0;
		while (index != i) {
			temp = temp.next;
			index++;
		}
		i_node = temp;
		temp = this.head;
		index = 0;
		while (index != j) {
			temp = temp.next;
			index++;
		}
		j_node = temp;
		int holder = i_node.data;
		i_node.data = j_node.data;
		j_node.data = holder;
	}

	public boolean isPalindrome() {

		LinkedList revList = new LinkedList();
		this.reverseList();
		Node tempHead = this.head;
		while (tempHead != null) {
			revList.insertElement(tempHead.data);
			tempHead = tempHead.next;
		}
		this.reverseList();
		Node currHead = this.head;
		Node revHead = revList.head;

		while (currHead != null) {
			if (currHead.data != revHead.data)
				return false;
			currHead = currHead.next;
			revHead = revHead.next;
		}

		return true;
	}

	public void deleteByElement(int element) {
		if (this.head == null) {
			System.out.println("Empty List! Add some elements first!");
			return;
		}
		int prevSize = this.getSize();
		while (this.head.data == element && this.head != null) {
			this.head = this.head.next;
		}
		Node currNode = this.head;
		Node prevNode = null;
		while (currNode != null) {
			if (currNode.data == element) {
				System.out.println("Element deleted!");
				prevNode.next = currNode.next;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
		if (prevSize == this.getSize())
			System.out.println("Node not found!!");
	}

	public void deleteByIndex(int index) {
		if (this.head == null || index + 1 > this.getSize() || index < 0) {
			System.out.println("Could not delete. Either list is empty or index is invalid");
			return;
		}
		if (index == 0) {
			this.head = this.head.next;
			System.out.println("Element deleted at index: " + index);
			return;
		}
		Node tempNode = this.head;
		Node prevNode = null;
		int count = 0;
		while (count != index) {
			count++;
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		System.out.println("Element deleted at index: " + index);
		prevNode.next = tempNode.next;
	}

	public void reverseList() {
		if (this.head == null || this.getSize() <= 1) {
			System.out.println("Could not reverse, add some elements!");
			return;
		}
		Node currNode = this.head;
		Node prevNode = null;
		Node nextNode = null;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		this.head = prevNode;
		System.out.println("LIST REVERSED!");
	}

	public void search(int element) {
		Node tempHead = this.head;
		int index = 0;
		while (tempHead != null) {
			if (tempHead.data == element) {
				System.out.println("Element found at index: " + index);
				return;
			}
			tempHead = tempHead.next;
			index++;
		}
		System.out.println("Element not found!");
	}

	public int returnMiddleElement() {
		int size = this.getSize();
		Node curr = this.head;
		if (size % 2 == 0) {
			int index = (size / 2) - 1;
			int count = 0;
			while (count != index) {
				curr = curr.next;
				count++;
			}
			return curr.data;
		} else {
			int index = size / 2;
			int count = 0;
			while (count != index) {
				curr = curr.next;
				count++;
			}
			return curr.data;
		}
	}

	public int getSize() {
		Node tempHead = this.head;
		int count = 0;
		while (tempHead != null) {
			count++;
			tempHead = tempHead.next;
		}
		return count;
	}

	public void insertElement(int element) {
		Node tempHead = this.head;
		if (tempHead == null) {
			this.head = new Node(element);
			System.out.println("Successfully inserted element into a new list (index 0).");
			return;
		}
		int count = 1;
		while (tempHead.next != null) {
			count++;
			tempHead = tempHead.next;
		}
		Node node = new Node(element);
		tempHead.next = node;
		System.out.println("Successfully inserted element at index: " + count);
	}

	public void insertElementByIndex(int element, int index) {
		if (index >= this.getSize() || this.head == null) {
			System.out.println("Invalid entry!");
			return;
		}

		Node curr = this.head;
		int i = 0;

		while (i != index) {
			curr = curr.next;
			i++;
		}

		Node next = curr.next;
		curr.next = new Node(element);
		curr.next.next = next;
	}

	public void printList() {
		Node tempHead = this.head;
		if (tempHead == null) {
			System.out.println("Empty list!");
			return;
		}
		System.out.print("Current List -> ");
		while (tempHead != null) {
			System.out.print(tempHead.data + "\t");
			tempHead = tempHead.next;
		}
		System.out.println();
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

}

public class BasicOpsImpl {
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		LinkedList list2 = new LinkedList();
		list.insertElement(1);
		list.insertElement(3);
		list.insertElement(5);
		list.insertElement(7);
		list.insertElement(9);
		list2.insertElement(2);
		list2.insertElement(4);
		list2.insertElement(6);
		list2.insertElement(8);

		list.mergeSortedLists(list2).printList();

	}
}
