import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        Iterator<String> iter = deque.iterator();


        System.out.println("Test of addFirst method:");

        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addFirst("4");
        iter = deque.iterator();
        System.out.println("Deque after test of addFirst method : (also test of my custom iterator class methods  ");
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of addLast method:");
        deque.addLast("10");
        deque.addLast("11");
        deque.addLast("12");
        deque.addLast("13");
        deque.addLast("14");
        iter = deque.iterator();
        System.out.println("Deque after test of addLast method : (also test of my custom iterator class methods  ");
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of removeFirst method");
        deque.removeFirst();
        deque.removeFirst();
        iter = deque.iterator();
        System.out.println("Deque after test of removeFirst method : (also test of my custom iterator class methods  ");
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of removeLast method");
        deque.removeLast();
        iter = deque.iterator();
        System.out.println("Deque after test of removeLast method : (also test of my custom iterator class methods  ");
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Removed list has 3 removed node and i will 4 node.First 3 node will add to deque using removed node. 4th node will add to deque using new node");

        deque.addLast("35");
        deque.addFirst("41");
        deque.addLast("36");
        deque.addLast("37");
        System.out.println("Deque : ");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of offerFirst method");
        deque.offerFirst("40");
        System.out.println("Deque after test of offerFirst method : ");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of offerLast method");
        deque.offerLast("38");
        System.out.println("Deque after test of offerLast method : ");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of pollFirst method");
        deque.pollFirst();
        System.out.println("Deque after test of pollFirst method : ");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of pollLast method");
        deque.pollLast();
        System.out.println("Deque after test of pollLast method : ");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of getFirst method:");
        System.out.println("The first element of deque is : " +deque.getFirst());

        System.out.println("Test of getLast method:");
        System.out.println("The last element of deque is : " +deque.getLast());

        System.out.println("Test of offer method :");
        deque.offer("80");
        System.out.println("Deque after test of offer method:");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of remove method :");
        deque.remove();
        System.out.println("Deque after test of remove method:");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of poll method :");
        deque.poll();
        System.out.println("Deque after test of poll method:");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of element method:");
        System.out.println("element method returns the head of deque. Head's value : " +deque.element() );

        System.out.println("Test of push method :(data push front of deque)");
        deque.push("90");
        System.out.println("Deque after test of push method:");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("Test of pop method :(data pops front of deque)");
        deque.pop();
        System.out.println("Deque after test of pop method:");
        iter = deque.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() +  " ");
        }
        System.out.println();

        System.out.println("End of the test");



    }
}
