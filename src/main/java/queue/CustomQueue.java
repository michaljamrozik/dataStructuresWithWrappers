package queue;


import dataStructuresWithWrapper.Person;

public class CustomQueue {

    private int size;
    private Node last;

    //złożoność O(1)
    public void add(Person person) {
        Node node = new Node(person);
        node.setPrevious(last);
        last = node;
        size++;
    }

    //złożoność O(n)
    public void delete() {
        if (size == 0) {
            System.out.println("Operation is impossible, queue is empty");
        } else if (size == 1) {
            last = null;
            size--;
        } else {
            Node temp = last;
            while (temp.getPrevious().getPrevious() != null) {
                temp = temp.getPrevious();
            }
            temp.setPrevious(null);
            size--;
        }
    }

    public boolean contains(Person person) {
        Node temp = last;
        while (temp != null) {
            if (temp.person == person) {
                return true;
            }
            temp = temp.getPrevious();
        }
        return false;
    }

    public Person getLast() {
        return last == null ? null : last.person;
    }

    public int getSize() {
        System.out.println("Queue's lenght:  " + size);
        return size;
    }

    @Override
    public String toString() {
        String result = "Queue[";
        Node temp = last;
        if (size == 0) {
            return "Queue is empty";
        } else {
            while (temp.getPrevious() != null) {
                result += temp.getPerson() + " --> ";
                temp = temp.getPrevious();
            }
            result += temp.getPerson();
        }
        return result + "]";


    }

    //klasa węwnętrzna
    private class Node {
        private Node previous;
        private Person person;


        public Node(Person person) {
            this.person = person;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
    }
}
