import java.util.EmptyStackException;/** * A class of stacks whose entries are stored in a chain of nodes. *  * @author Frank M. Carrano * @author Timothy M. Henry * @version 5.0 */public final class LinkedStack<T> implements StackInterface<T> {	private Node topNode; // References the first node in the chain	public LinkedStack() {		topNode = null;	} 	public void push(T newEntry) {		Node newNode = new Node(newEntry, topNode);		topNode = newNode;		//    topNode = new Node(newEntry, topNode); // Alternate code	} 	public T peek() {		if (isEmpty())			throw new EmptyStackException();		else			return topNode.getData();	} // end peek	public T pop() {		T top = peek(); // Might throw EmptyStackException		topNode = topNode.getNextNode();		return top;	} 	public boolean isEmpty() {		return topNode == null;	} 	public void clear() {		topNode = null; 	} 	@Override	public String toString() {		String s = "";		Node current = topNode;		while (current != null) {			s = current.data + " " + s;			current = current.next;		}		return s;	}	public boolean priorityPush(T element) {		// YOUR CODE HERE		Node current = topNode;		// empty stack		if (current == null) {			push(element);			return false;		}		// singleton stack		if (current.next == null){			if (current.data.equals(element)){				return true;			} else {				push(element);				return false;			}		}		// already on the top of the list		if (current.data.equals(element)){			return true;		}		// first element is not equal		while (current.next != null) {			if (current.next.data.equals(element)) {				push(element);				if (current.next.next != null) {					current.next = current.next.next;				} else {					current.next = null;				}				return true;			} else {				current = current.next;			}		}		push(element);		return false;	}	// linkedStack	public T peekNext() {		// YOUR CODE HERE FOR EXTRA CREDIT		Node current = topNode;		if (isEmpty() || current.next == null)			return null;		else {			T top = pop();			T next = peek();			push(top);			return next;		}	}		private class Node {		private T data; 		private Node next; 		private Node(T dataPortion) {			this(dataPortion, null);		} 		private Node(T dataPortion, Node linkPortion) {			data = dataPortion;			next = linkPortion;		}		private T getData() {			return data;		}		private void setData(T newData) {			data = newData;		}		private Node getNextNode() {			return next;		} 		private void setNextNode(Node nextNode) {			next = nextNode;		} 	} } 