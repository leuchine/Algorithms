package a;

import java.util.LinkedList;
import java.util.Random;

class Node {
	public int key;
	public Node before;
	public Node next;
	public Node below;

	public Node(int k) {
		this.key = k;
		this.before = null;
		this.next = null;
		this.below = null;
	}

	public Node search(int k) {
		Node b = null;
		Node go = this;
		while (go != null && go.key < k) {
			b = go;
			go = go.next;
		}
		if (go == null)
			return b;
		else {
			if (go.key == k) {
				System.out.println(go.key);
				return null;
			} else {
				return go.before;
			}

		}

	}
}

class List {
	private Node head;
	private Node tail;

	public List() {
		this.head = null;
		this.tail = null;
	}

	public Node head() {
		return head;
	}

	public Node insert(int k) {
		if (head == null) {
			this.head = this.tail = new Node(k);
			return head;
		}
		Node go = head;
		while (go != null && go.key <= k)
			go = go.next;
		if (go == null) {
			tail.next = new Node(k);
			tail.next.before = tail;
			tail = tail.next;
			return tail;
		} else {
			go = go.before;
			if (go == null) {
				head.before = new Node(k);
				head.before.next = head;
				head = head.before;
				return head;
			} else {
				Node node = new Node(k);
				go.next.before = node;
				node.before = go;
				node.next = go.next;
				go.next = node;
				return node;
			}
		}
	}

	public void delete(int k) {
		Node go = head;
		while (go != null && go.key != k) {
			go = go.next;
		}
		if (go == null)
			return;
		go = go.before;
		if (go == null) {
			head = head.next;
			if (head == null)
				tail = null;
			else
				head.before = null;
		} else {
			if (go.next == tail) {
				go.next = null;
				tail = go;
			} else {
				go.next = go.next.next;
				go.next.before = go;
			}
		}
	}

	public void print() {
		Node go = head;
		System.out.print("{");
		while (go != null) {
			System.out.print(go.key + ",");
			go = go.next;
		}
		System.out.println("}");
	}

	public Node search(int k) {
		return this.head.search(k);
	}
}

class SkipList {
	private LinkedList<List> listhead;

	public SkipList() {
		listhead = new LinkedList<List>();
		listhead.addFirst(new List());
		listhead.get(0).insert(Integer.MIN_VALUE);
	}

	public void insert(int k) {
		int length = listhead.size();
		Random random = new Random();
		Node below = listhead.get(0).insert(k);
		int i;
		for (i = 1; i < length; i++) {
			if (random.nextFloat() < 0.5) {
				Node node = listhead.get(i).insert(k);
				node.below = below;
				below = node;
			} else {
				break;
			}
		}
		if (i >= length) {
			while (true) {
				if (random.nextFloat() < 0.5) {
					listhead.addLast(new List());
					Node h = listhead.getLast().insert(Integer.MIN_VALUE);
					h.below = listhead.get(listhead.size() - 2).head();
					Node node = listhead.getLast().insert(k);
					node.below = below;
					below = node;
				} else {
					break;
				}
			}
		}
	}

	public void delete(int k) {
		for (int i = 0; i < listhead.size(); i++) {
			listhead.get(i).delete(k);
		}
	}

	public void search(int k) {
		List l = listhead.getLast();
		Node next = l.search(k);
		while (next != null) {
			next = next.below.search(k);
			if (next == null) {
				return;
			}
			next = next.below;
		}
	}

	public void print() {
		for (int i = 0; i < listhead.size(); i++) {
			listhead.get(i).print();
		}
	}
}

public class Test {

	public static void main(String[] args) {
		SkipList l = new SkipList();
		l.insert(4);
		l.insert(2);
		l.insert(9);
		l.insert(5);
		l.print();
		System.out.println("delete");
		l.delete(4);
		l.print();
		System.out.println("insert");
		l.insert(3);
		l.print();
		l.search(2);
	}
}
