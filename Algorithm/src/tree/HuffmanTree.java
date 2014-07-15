package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static <T> Node<T> createHuffmanTree(List<Node<T>> nodes) {

		while (nodes.size() > 1) {
			Collections.sort(nodes);

			// The last 2 node is the smallest weight in the nodes list after
			// sorting.
			Node<T> last1 = nodes.get(nodes.size() - 1);
			Node<T> last2 = nodes.get(nodes.size() - 2);

			Node<T> parent = new Node<T>(null, last1.getWeight()
					+ last2.getWeight());
			parent.setLeft(last1);
			parent.setRight(last2);
			// Remove last1 and last2 from nodes list
			nodes.remove(last1);
			nodes.remove(last2);
			// Add parent to nodes list
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	public static <T> void printHuffmanTree(Node<T> root) {
		if (root != null && root.getData() != null) {
			System.out.println(root);
		}
		if (root.getLeft() != null) {
			printHuffmanTree(root.getLeft());
		}
		if (root.getRight() != null) {
			printHuffmanTree(root.getRight());
		}

	}

	public static void main(String[] args) {
		List<Node<String>> list = new ArrayList<Node<String>>();
		list.add(new Node<String>("a", 7));
		list.add(new Node<String>("b", 5));
		list.add(new Node<String>("c", 4));
		list.add(new Node<String>("d", 2));
		list.add(new Node<String>("e", 3));
		list.add(new Node<String>("t", 6));

		Node<String> root = HuffmanTree.createHuffmanTree(list);

		printHuffmanTree(root);

	}
	
	

}

class Node<T> implements Comparable<Node<T>> {
	private T data;
	private Node<T> left;
	private Node<T> right;
	private int weight;

	public Node(T data, int weight) {
		this.data = data;
		this.weight = weight;

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Node<T> other) {
		// Make it descending
		if (other.getWeight() > this.getWeight()) {
			return 1;
		}
		if (other.getWeight() < this.getWeight()) {
			return -1;
		}

		return 0;
	}

	@Override
	public String toString() {

		return "[Node:data=" + data + " weight=" + weight;
	}

}