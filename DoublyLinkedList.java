package com.example.helloworld;

public class DoublyLinkedList
{
	// reference to the head node.
	private Node head;
	private Node tail;
	private int listCount;
	
	public static void main(String[] args){
		System.out.println("Hello World");
		DoublyLinkedList list = new DoublyLinkedList();
		list.add("first");
		list.add("second");
		list.add("third");

		log(list.toString());
		log(list.size());
		
//		list.remove(list.size());
//		log(list.toString());
//		log(list.size());
		
		list.add("fourth", 5);
		log(list.toString());
		log(list.size());
		DoublyLinkedList reverseList = reverseLinkList(list);
		log(reverseList.toString());
		log(reverseList.size());

		reverseLinkListSwap(list);
		log(list.toString());
		log(list.size());
		
		reverseLinkListSwapFast(list);
		log(list.toString());
		log(list.size());
		
		
		
		System.exit(0);
	}
	private static void reverseLinkListSwapFast(DoublyLinkedList list) {
		Node start = list.getHead().getNext();
		Node temp = null;
		
		while(start != null) {
			temp = start.getNext();
			start.setNext(start.getPrev());
			start.setPrev(temp);
			if(start.getPrev() == null){
				list.setHead(start);
			}
			
			start = start.getPrev();
		}
		
	}
	private static void reverseLinkListSwap(DoublyLinkedList list) {
		Node firstNode;
		Node secondNode;
		
		firstNode = list.getHead().getNext();
		secondNode = list.getTail();
		int counter = list.size() / 2;
		
		Object temp;
		for (int i=0; i < counter;i++){
			temp = firstNode.getData();
			firstNode.setData(secondNode.getData());
			secondNode.setData(temp);
			
			firstNode = firstNode.getNext();
			secondNode = secondNode.getPrev();
		}
	}
	private static DoublyLinkedList reverseLinkList(DoublyLinkedList list) {
		// TODO Auto-generated method stub
		DoublyLinkedList copyList = new DoublyLinkedList();
		Node start = list.getTail();
		
		while (start.getPrev() != null){
			copyList.add(start.getData());
			start = start.getPrev();
		}
		return copyList;
	}
	private static void log(Object string) {
		System.out.println(string);
		
	}
	// LinkedList constructor
	public DoublyLinkedList()
	{
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = new Node(null);
		tail = new Node(null);
		listCount = 0;
	}
	
	public void setHead(Node node){
		head = node;
	}
	public void add(Object data)
	// post: appends the specified element to the end of this list.
	{
		Node temp = new Node(data);
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		temp.setPrev(current);
		tail = temp;
		listCount++;// increment the number of elements variable
	}
	
	public void add(Object data, int index)
	// post: inserts the specified element at the specified position in this list.
	{
		Node temp = new Node(data);
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for(int i = 1; i < index && current.getNext() != null; i++)
		{
			current = current.getNext();
			if (i == size()){
				tail = temp;
			}
		}
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		temp.setPrev(current);
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
	
	public Node getHead(){
		return head;
	}
	public Node getTail(){
		return tail;
	}

	public Object get(int index)
	// post: returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if(index <= 0)
			return null;
		
		Node current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getData();
	}
	
	public boolean remove(int index)
	// post: removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
		
		Node current = head;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		Node temp = current.getNext().getNext();
		current.setNext(temp);
		if (temp != null){
			temp.setPrev(current);
		}
		else {
			tail = current;
		}
		listCount--; // decrement the number of elements variable
		return true;
	}
	
	public int size()
	// post: returns the number of elements in this list.
	{
		return listCount;
	}
	
	public String toString()
	{
		Node current = head.getNext();
		String output = "";
		while(current != null && current.getData() != null)
		{
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
	
	private class Node
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		Node prev;
		// data carried by this node.
		// could be of any type you need.
		Object data;
		

		// Node constructor
		public Node(Object _data)
		{
			next = null;
			prev = null;
			data = _data;
		}
		
		// another Node constructor if we want to
		// specify the node to point to.
//		public Node(Object _data, Node _next)
//		{
//			next = _next;
//			data = _data;
//		}

		public Node(Node _prev, Object _data, Node _next)
		{
			next = _next;
			data = _data;
			prev = _prev;
		}

		// these methods should be self-explanatory
		public Object getData()
		{
			return data;
		}
		
		public void setData(Object _data)
		{
			data = _data;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node _next)
		{
			next = _next;
		}

		public Node getPrev()
		{
			return prev;
		}
		
		public void setPrev(Node _prev)
		{
			prev = _prev;
		}

	}
}
