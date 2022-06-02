package stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

	ArrayList<E> array = new ArrayList<>();

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public E top() throws Underflow {
		E temp = array.get(array.size()-1);
		if (temp == null) {
			throw new Underflow();
		} else {
			return temp;
		}
	}

	@Override
	public void push(E element) {
		array.add(element);
	}

	@Override
	public E pop() throws Underflow {
		E temp = array.get(array.size()-1);
		if (temp == null) {
			throw new Underflow();
		} else {
			array.remove(temp);
			return temp;
		}
	}

	public String toString () {
		return array.toString();
	}

	public int size() {
		return array.size();
	}

}
