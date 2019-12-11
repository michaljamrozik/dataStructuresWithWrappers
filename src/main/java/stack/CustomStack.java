package stack;

import dataStructuresWithWrapper.Person;

public class CustomStack {
    private int size;
    private Node last;

    public void add(Person person) {
        Node node = new Node();
        node.setPerson(person);
        if (size == 0) {
            last = node;
            node.setPrevious(null);
            size++;
        } else {
            Node temp = last;
            while (temp.getPrevious() != null) {
                temp = temp.getPrevious();
            }
            temp.setPrevious(node);
            node.setPrevious(null);
            size++;
        }
    }

    public void remove() {
        if (size == 0) {
            System.out.println("Operation is impossible, stack is empty");
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
        if (size == 0) {
            return false;
        } else {
            Node temp = last;
            while (temp != null) {
                if (temp.getPerson() == person) {
                    return true;
                }
                temp = temp.getPrevious();
            }
        }
        return false;
    }

    public Person getPeek() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return last.getPerson();
        } else {
            Node temp = last;
            while (temp.getPrevious() != null) {
                temp = temp.getPrevious();
            }
            return temp.getPerson();
        }
    }

    //ostatnia osoba na stosie czyli ta z największym numerem
    public void remove(int index) {
        if (index <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (index > size) {
            System.out.println("Index cannot be higher than stack's size");
        } else if (index == size) {
            last = last.getPrevious();
            size--;
        } else {
            int tempIndex = size - 1;
            Node temp = last;
            while (tempIndex != index) {
                temp = temp.getPrevious();
                tempIndex--;
            }
            temp.setPrevious(temp.getPrevious().getPrevious());
            size--;
        }
    }

    public void remove(Person person) {
        if (size == 1 && person == last.getPerson()) {
            last = null;
            size--;
        } else if (last.getPerson() == person) {
            last = last.getPrevious();
            size--;
        } else {
            Node temp = last;
            Node tempIndex = last.previous;
            while (tempIndex != null) {
                if (tempIndex.getPerson() == person) {
                    temp.setPrevious(tempIndex.getPrevious());
                }
                temp = temp.getPrevious();
                tempIndex = tempIndex.getPrevious();
                size--;
            }
        }

    }

    public Person getLast() {
        return last == null ? null : last.person;
    }

    public int getSize() {
        System.out.println("Stack's size: " + size);
        return size;
    }

    @Override
    public String toString() {
        String result = "Stack[";
        Node temp = last;
        if (size == 0) {
            return "Stack is empty";
        } else {
            while (temp.getPrevious() != null) {
                result += temp.getPerson() + " --> ";
                temp = temp.getPrevious();
            }
            result += temp.getPerson() + "]";
        }
        return result;
    }

    //klasa węwnętrzna
    private class Node {
        private Node previous;
        private Person person;


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

