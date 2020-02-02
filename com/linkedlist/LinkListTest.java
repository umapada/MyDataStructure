package com.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Link {
	public int data1;
	public double data2;
	public Link nextLink;

	// Link constructor
	public Link(int d1, double d2) {
		data1 = d1;
		data2 = d2;
	}

	// Print Link data
	public void printLink() {
		System.out.print("{" + data1 + ", " + data2 + "} ");
	}
}

class LinkList {
	private Link first;

	// LinkList constructor
	public LinkList() {
		first = null;
	}

	// Returns true if list is empty
	public boolean isEmpty() {
		return first == null;
	}

	// Inserts a new Link at the first of the list
	public void insert(int d1, double d2) {
		Link link = new Link(d1, d2);
		link.nextLink = first;
		first = link;
	}

	// Deletes the link at the first of the list
	public Link delete() {
		Link temp = first;
		if (first == null) {
			return null;
			// throw new NoSuchElementException(); // this is the better way.
		}
		first = first.nextLink;
		return temp;
	}

	// Prints list data
	public void printList() {
		Link currentLink = first;
		System.out.print("List: ");
		while (currentLink != null) {
			currentLink.printLink();
			currentLink = currentLink.nextLink;
		}
		System.out.println("");
	}

	public void reverese() {
		Link current = first;
		Link prev = null;
		Link next = current.nextLink;
		while (next != null) {
			current.nextLink = prev;
			prev = current;
			current = next;
			next = current.nextLink;
		}
		current.nextLink = prev;
		first = current;
	}

}

class LinkListTest {
	public static void main(String[] args) {
		LinkList list = new LinkList();

		list.insert(1, 1.01);
		list.insert(2, 2.02);
		list.insert(3, 3.03);
		list.insert(4, 4.04);
		list.insert(5, 5.05);

		list.printList();

		/*
		 * while(!list.isEmpty()) { Link deletedLink = list.delete();
		 * System.out.print("deleted: "); deletedLink.printLink();
		 * System.out.println(""); }
		 */
		// list.printList();

		list.reverese();
		list.printList();
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(3, "D");
		
		refer(map, "B");
		System.out.println(map);
		add(map, "E");
		System.out.println(map);
		refer(map, "A");
		System.out.println(map);
		add(map, "F");
		System.out.println(map);
	}
	
	private static void refer(Map<Integer, String> map, String str) {
		int loc=0;
		for(Entry<Integer, String> entry:map.entrySet()) {
			if(str.equals(entry.getValue())){
				loc = entry.getKey();
				break;
			}
		}
		
		for(int i = loc; i>= 2; i--) {
			map.put(i, map.get(i-1));
		}
		map.put(1, str);
	}

	static void add(Map<Integer, String> map, String val) {
		int last = 0;
		if(map.size() >= 4) {
			last = 4;
		}else {
			last = map.size() + 1;
		}

			for(int i = last; i>= 2; i--) {
				map.put(i, map.get(i-1));
			}
			map.put(1, val);
		
	}
}
