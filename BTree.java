package a;

class BTree {
	Node root;
	int t;

	public BTree(int t) {
		this.t = t;
		this.root = new Node(t);
	}

	public Node search(int k) {
		return this.root.search(k);
	}

	public void insert(int k) {
		Node r = this.root;
		if (r.n == 2 * t - 1) {
			Node s = new Node(t);
			this.root = s;
			s.leaf = false;
			s.n = 0;
			s.c[1] = r;
			s.splitChild(1, r);
			s.insertNonFull(k);
		} else
			r.insertNonFull(k);

	}

	public void print() {
		this.root.print();
	}
}

class Node {
	public int n;
	public int key[];
	public boolean leaf;
	public Node c[];
	public int t;

	public Node(int t) {
		this.t = t;
		key = new int[2 * t];
		c = new Node[2 * t + 1];
		n = 0;
		leaf = true;
	}

	public Node search(int k) {
		int i;
		for (i = 1; i <= n; i++) {
			if (key[i] >= k)
				break;
		}
		if (i <= n && key[i] == k)
			return this;
		if (this.leaf == true)
			return null;
		else
			return c[i].search(k);
	}

	public void splitChild(int i, Node y) {
		Node z = new Node(t);
		z.leaf = y.leaf;
		z.n = t - 1;
		for (int j = 1; j <= t - 1; j++) {
			z.key[j] = y.key[j + t];
		}
		if (!y.leaf) {
			for (int j = 1; j <= t; j++) {
				z.c[j] = y.c[j + t];
			}
		}
		y.n = t - 1;
		for (int j = this.n + 1; j >= i + 1; j--) {
			this.c[j + 1] = this.c[j];
		}
		this.c[i + 1] = z;
		for (int j = this.n; j >= i; j--) {
			this.key[j + 1] = this.key[j];
		}
		this.key[i] = y.key[t];
		this.n = this.n + 1;
	}

	public void insertNonFull(int k) {
		Node x = this;
		int i = x.n;
		if (x.leaf) {
			while (i >= 1 && k < x.key[i]) {
				x.key[i + 1] = x.key[i];
				i--;
			}
			x.key[i + 1] = k;
			x.n = x.n + 1;
		} else {
			while (i >= 1 && k < x.key[i]) {
				i = i - 1;
			}
			i = i + 1;
			if (x.c[i].n == 2 * t - 1) {
				x.splitChild(i, x.c[i]);
				if (k > x.key[i])
					i = i + 1;
			}
			x.c[i].insertNonFull(k);
		}
	}

	public String toString() {
		String str = "[";
		for (int i = 1; i <= n; i++) {
			str = str + key[i] + ",";
		}
		str = str + "]";
		return str;
	}

	public void print() {
		System.out.println(this.toString());
		if (leaf)
			return;
		else {
			for (int i = 1; i <= n + 1; i++) {
				this.c[i].print();
			}
		}
	}
}

public class Test {

	public static void main(String[] args) {
		BTree tree = new BTree(3);
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.print();
		System.out.println(tree.search(9));
	}
}
