package a;

import java.util.LinkedList;

class Element {
	private int key;
	private int value;

	public Element(int k, int v) {
		key = k;
		value = v;
	}

	public int getKey() {
		return key;
	}

	public String toString() {
		return "("+key + " " + value+")";
	}
}

class HashTable {
	private LinkedList list[];
	private int m;

	public HashTable(int m) {
		list = new LinkedList[m];
		for (int i = 0; i < m; i++) {
			list[i] = new LinkedList();
		}
		this.m = m;
	}

	public void insert(Element e) {
		list[e.getKey() % m].addLast(e);
	}

	public Element search(int key) {
		LinkedList l = list[key % m];
		while (l.listIterator().hasNext()) {
			Element e = (Element) l.listIterator().next();
			if (e.getKey() == key) {
				return e;
			}
		}
		return null;
	}

	public void delete(int key) {
		LinkedList l = list[key % m];
		while (l.listIterator().hasNext()) {
			Element e = (Element) l.listIterator().next();
			if (e.getKey() == key) {
				l.remove(e);
			}
		}
	}

	public void print() {
		for (int i = 0; i < m; i++) {
			System.out.println(list[i].toString());
		}
	}

}

public class Test {

	public static void main(String[] args) {
		HashTable table = new HashTable(3);
		Element e1 = new Element(1, 3);
		Element e2 = new Element(2, 3);
		Element e3 = new Element(4, 3);
		table.insert(e1);
		table.insert(e2);
		table.insert(e3);
		table.print();
	}
}
