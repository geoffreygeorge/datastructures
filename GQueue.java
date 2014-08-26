package com.example.helloworld;

public class GQueue {

	private GLinkedList list;
	
	public GQueue() {
		list = new GLinkedList();
	}
	
	public boolean isEmpty(){
		return (list.size() == 0);
	}
	
	public void enqueue(Object item){
		list.add(item);
	}
	
	public Object dequeue(){
		if (!isEmpty()){
			Object item = list.get(1);
			list.remove(1);
			return item;
		}
		return null;
	}
	
	public Object peek(){
		return list.get(1);
	}
	
	private static void log(Object string) {
		System.out.println(string);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GQueue q = new GQueue();
		Person alice = new Person("Alice");
		Person george = new Person("George");
		
		q.enqueue(alice);
		
		log(((Person)q.peek()).getName());
		q.enqueue(george);
		
		log(((Person)q.peek()).getName());
		
		q.dequeue();
		log(((Person)q.peek()).getName());
		
	}

}
