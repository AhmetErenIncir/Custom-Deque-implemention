import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<E> extends AbstractCollection<E> implements java.util.Deque<E> {

    private Node<E> front;
    private Node<E> rear;
    private Node<E> frontRemoved;
    private Node<E> rearRemoved;
    private int dequeSize;



    private static class Node<T> extends Deque<T>{

        private T data;
        private Node<T> next;


        Node(T data){
            this.data = data;
            next = null;

        }

        private Node(T newData , Node<T> newNext){
            if(newData == null){
                throw new NullPointerException();
            }
            next = newNext;
            data = newData;

        }



        public Node<T> getNext() {
            return next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }

    /**
     * My custom iterator class.
     */
    class DequeIterator implements Iterator<E>{

        private Node<E> current;

        /**
         * My custom iterator constructor
         */
        public DequeIterator(){
            current = front;
        }

        /**
         * My custom iterator's hasNext method.
         * @return true if current node has next node.
         */
        @Override
        public boolean hasNext() {
            return current !=null;
        }

        /**
         * My custom iterator class' next method.
         * Throw NoSuchElementException if current node is null.
         * @return current node's data.
         */
        @Override
        public E next() {
            if(current == null){
                throw new NoSuchElementException();
            }
            E temp = current.getData();
            current = current.getNext();
            return temp;
        }

        @Override
        public void remove() {
            try {
                throw new Exception("That should not be done by Deque ADT ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**

     * @return It returns the true if removed list is empty.
     */
    public boolean isRemovedEmpty(){
        return frontRemoved == null;
    }

    /**
     *
     * @return the front of the removed list.
     */
    public Node<E> getFrontRemoved() {
        return frontRemoved;
    }

    /**
     * @return the rear (tail) of removed list.
     */
    public Node<E> getRearRemoved() {
        return rearRemoved;
    }


    /**
     * @return size of deque.
     */
    public int getDequeSize() {
        return dequeSize;
    }

    /**
     *
     * @return the front (head) of deque
     */
    public Node<E> getFront() {
        return front;
    }

    /**
     * @return the rear (tail) of the deque.
     */
    public Node<E> getRear() {
        return rear;
    }

    /**
     * Add new element front of the deque. This method use removed nodes ,if removed list has node. It creates new node if removed list is empty.
     * @param e inserted element
     */
    @Override
    public void addFirst(E e) {

        if(!isRemovedEmpty()){
            System.out.println("Removed list has node. Adding new node to deque using removed node. " + e + " added to first");
            Node<E> temp = frontRemoved;
            frontRemoved = frontRemoved.next;
            temp.setNext(front);
            temp.setData(e);
            front = temp;

        }
        else{
            System.out.println("Removed list has not any removed node. Adding new node to deque creating new node " + e + " added to first");
            front = new Node<E>(e,front);
        }
        if(dequeSize == 0){
            rear = front;
        }
        dequeSize++;

    }

    /**
     * Add new element end of the deque. This method use removed nodes ,if removed list have node. It creates new node if removed list is empty.
     * @param e inserted element
     */
    @Override
    public void addLast(E e) {
        if(!isRemovedEmpty()){
            System.out.println("Removed list has node. Adding new node to deque using removed node. " + e + " added to last");
            Node<E> temp = frontRemoved;
            frontRemoved = frontRemoved.next;
            rear.setNext(temp);
            temp.setData(e);
            rear = temp;
            rear.setNext(null);
            dequeSize++;
        }
        else{
            System.out.println("Removed list has not any removed node. Adding new node to deque creating new node " + e + " added to last");
            if(getDequeSize() == 0){
                addFirst(e);
                return;
            }
            rear.next = new Node<E>(e,null);
            rear = rear.next;
            dequeSize++;
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            throw new Exception("That should not be done by Deque ADT ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        try {
            throw new Exception("That should not be done by Deque ADT ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method add element into front of deque
     * @param e element
     * @return true
     */
    @Override
    public boolean offerFirst(E e) {

        if(e == null){
            throw new NullPointerException();
        }
        dequeSize++;
        addFirst(e);

        return true;
    }

    @Override
    public boolean offerLast(E e) {

        if(e==null){
            throw new NullPointerException();
        }
        dequeSize++;
        addLast(e);

        return true;
    }

    /**
     * This method removes the first element the deque and insert the deleted element into removed list.
     * @return removed node's data
     */
    @Override
    public E removeFirst() {

        Node<E> temp = front;
        front = front.next;

        if(frontRemoved == null){
            frontRemoved = new Node<>(temp.getData(),null);
            rearRemoved = frontRemoved;
        }
        else{
            rearRemoved.next = new Node<>(temp.getData());
            rearRemoved = rearRemoved.next;
            rearRemoved.setNext(null);
        }

        System.out.println(temp.getData() + " Removed from head of list");
        dequeSize--;

        return temp.getData();
    }

    /**
     * This method remove the last element in the deque and add to removed list.
     * @return removed node's data
     */
    @Override
    public E removeLast() {
        Node<E> iter =  front;
        while(iter.getNext() != rear ){
            iter = iter.next;
        }
        Node<E> temp = iter.getNext();
        iter.setNext(null);
        rear = iter;
        if(frontRemoved == null){
            frontRemoved = new Node<>(temp.getData(),null);
            rearRemoved = frontRemoved;

        }
        else
            rearRemoved.next = new Node<>(temp.getData(),null);

        dequeSize--;
        System.out.println(temp.getData() +  " Removed from end of list");

        return temp.getData();
    }

    /**
     * Retrieves and removes the first element of this deque
     * @return removed element's data
     */
    @Override
    public E pollFirst() {
        if(isEmpty())
            return null;
        dequeSize--;
        return removeFirst();
    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     * @return removed element's data
     */
    @Override
    public E pollLast() {
        if(isEmpty())
            return null;
        dequeSize--;
        return removeLast();
    }

    /**
     * @return the first data of deque
     */
    @Override
    public E getFirst() {

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return front.getData();
    }

    /**
     * @return the last element of deque.
     */
    @Override
    public E getLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return rear.getData();
    }

    /**
     *
     * @return the first element of deque.
     */
    @Override
    public E peekFirst() {
        if(isEmpty())
            return null;
        return getFirst();
    }

    /**
     *
     * @return the last element of deque
     */
    @Override
    public E peekLast() {
        if(isEmpty())
            return null;
        return getLast();
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {

        try {
            throw new Exception("That should not be done by Deque ADT ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        try {
            throw new Exception("That should not be done by Deque ADT ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method insert the element rear(tail) of deque.
     * @param e inserted element
     * @return true.(Deque implemented as Linked List. We have no capacity problems.
     */
    @Override
    public boolean offer(E e) {

        if(e == null){
            throw new NullPointerException();
        }
        dequeSize++;
        offerLast(e);

        return true;
    }

    /**
     * This method removes front (head) of deque.Throw an exception if deque is empty.
     * @return first element of deque.
     */
    @Override
    public E remove() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        dequeSize--;
        return removeFirst();
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     * @return first element of deque.
     */
    @Override
    public E poll() {
        if(isEmpty())
            return null;
        dequeSize--;
        return pollFirst();
    }

    /**
     * This method returns head (front) of deque but not removes
     * @return front's data.
     */
    @Override
    public E element() {
        if(isEmpty())
            throw new NoSuchElementException();
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     * @return the head of the queue represented by this deque, or null if this deque is empty
     */
    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return peekFirst();
    }

    /**
     * Pushes an element onto the stack represented by this deque (in other words, at the head of this deque).
     * Throw NullPointerException - if the specified element is null and this deque does not permit null elements
     * @param e inserted element
     */
    @Override
    public void push(E e) {
        if(e == null){
            throw new NoSuchElementException();
        }
        dequeSize++;
        addFirst(e);
    }

    /**
     * Pops an element from the stack represented by this deque. In other words, removes and returns the first element of this deque.
     * Throw NoSuchElementException - if this deque is empty
     * @return the element at the front of this deque (which is the top of the stack represented by this deque)
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return removeFirst();
    }

    /**
     * This method returns size of deque
     * @return size of deque
     */
    @Override
    public int size() {
        return dequeSize;
    }

    /**
     *This method returns true if deque is empty. I override the this method from AbstractCollection
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return getDequeSize()==0;
    }

    /**
     * Returns an iterator over the elements in this deque in proper sequence. The elements will be returned in order from first (head) to last (tail).
     * @return my custom iterator class.
     */
    @Override
    public Iterator<E> iterator() {
        return new DequeIterator() ;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DequeIterator();
    }






}
