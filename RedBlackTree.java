package a;

enum Color {
	red, black
};

class RedBlackTree {
	private Node root;
	public static Node nil = new Node();

	public RedBlackTree() {
		root = this.nil;
	}

	public Node successor(Node z) {
		Node r = z.right;
		while (r.left != this.nil) {
			r = r.left;
		}
		return r;
	}

	public Node delete(Node z){
		Node x,y;
		if(z.left==this.nil || z.right==this.nil)
			y=z;
		else
			y=successor(z);
		if(y.left!=this.nil)
			x=y.left;
		else
			x=y.right;
		x.p=y.p;
		if(y.p==this.nil)
			this.root=x;
		else{
			if(y==y.p.left)
				y.p.left=x;
			else
				y.p.right=x;
		}
		if(y!=z)
			z.key=y.key;
		if(y.color==Color.black)
			rb_delete_fixup(x);
		return y;
	}

	public void rb_delete_fixup(Node x) {
		while(x==this.root && x.color==Color.black){
			if(x==x.p.left){
				Node w=x.p.right;
				if(w.color==Color.red){
					w.color=Color.black;
					x.p.color=Color.red;
					left_rotate(x.p);
					w=x.p.right;
				}
				if(w.left.color==Color.black && w.right.color==Color.black){
					w.color=Color.red;
					x=x.p;
				}
				else{
					if(w.right.color==Color.black){
						w.left.color=Color.black;
						w.left.color=Color.black;
						w.color=Color.red;
						right_rotate(w);
						w=x.p.right;
					}
					w.color=x.p.color;
					x.p.color=Color.black;
					w.right.color=Color.black;
					left_rotate(x.p);
					x=this.root;
				}
			}
			else{
				Node w=x.p.left;
				if(w.color==Color.red){
					w.color=Color.black;
					x.p.color=Color.red;
					right_rotate(x.p);
					w=x.p.left;
				}
				if(w.right.color==Color.black && w.left.color==Color.black){
					w.color=Color.red;
					x=x.p;
				}
				else{
					if(w.left.color==Color.black){
						w.right.color=Color.black;
						w.left.color=Color.black;
						w.color=Color.red;
						left_rotate(w);
						w=x.p.left;
					}
					w.color=x.p.color;
					x.p.color=Color.black;
					w.left.color=Color.black;
					right_rotate(x.p);
					x=this.root;
				}
			}
		}
		x.color=Color.black;
	}

	public void insert(Node z) {
		Node y = this.nil;
		Node x = this.root;
		while (x != this.nil) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.p = y;
		if (y == this.nil)
			this.root = z;
		else {
			if (z.key < y.key)
				y.left = z;
			else
				y.right = z;
		}
		z.left = this.nil;
		z.right = this.nil;
		z.color = Color.red;
		rb_insert_fixup(z);
	}

	private void rb_insert_fixup(Node z) {
		while (z.p.color == Color.red) {
			if (z.p == z.p.p.left) {
				Node y = z.p.p.right;
				if (y.color == Color.red) {
					z.p.color = Color.black;
					y.color = Color.black;
					z.p.p.color = Color.red;
					z = z.p.p;
				} else {
					if (z == z.p.right) {
						z = z.p;
						left_rotate(z);
					}
					z.p.color = Color.black;
					z.p.p.color = Color.red;
					right_rotate(z.p.p);
				}
			} else {
				Node y = z.p.p.left;
				if (y.color == Color.red) {
					z.p.color = Color.black;
					y.color = Color.black;
					z.p.p.color = Color.red;
					z = z.p.p;
				} else {
					if (z == z.p.left) {
						z = z.p;
						right_rotate(z);
					}
					z.p.color = Color.black;
					z.p.p.color = Color.red;
					left_rotate(z.p.p);
				}
			}
		}
		this.root.color = Color.black;
	}

	private void left_rotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != this.nil)
			y.left.p = x;
		y.p = x.p;
		if (x.p == this.nil)
			this.root = y;
		else {
			if (x == x.p.left)
				x.p.left = y;
			else
				x.p.right = y;
		}
		y.left = x;
		x.p = y;
	}

	private void right_rotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != this.nil)
			y.right.p = x;
		y.p = x.p;
		if (x.p == this.nil)
			this.root = y;
		else {
			if (x == x.p.left)
				x.p.left = y;
			else
				x.p.right = y;
		}
		y.right = x;
		x.p = y;
	}

	public void tranverse() {
		this.root.tranverse();
	}
}

class Node {
	public Color color;
	public int key;
	public Node p = null;
	public Node left = null;
	public Node right = null;

	public Node() {

	}

	public Node(int key) {
		this.key = key;
	}

	public String toString() {
		return "{" + color + "," + key + "}";
	}

	public void tranverse() {
		if (this == RedBlackTree.nil)
			return;
		System.out.println(this);
		this.left.tranverse();
		this.right.tranverse();
	}
}

public class Test {

	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		tree.insert(new Node(6));
		tree.insert(new Node(8));
		tree.insert(new Node(7));
		tree.insert(new Node(5));
		tree.insert(new Node(4));
		tree.tranverse();
	}
}
