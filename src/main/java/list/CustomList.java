package list;


import dataStructuresWithWrapper.Person;

public class CustomList {

    private int size;
    private Node last;

    public void setLast(Person last) {
        this.last.setPerson(last);
    }

    public int getSize() {
        System.out.println("List's size: " + size);
        return size;
    }

    public Person getLast() {
        return last.getPerson();
    }

    public void add(Person person) {
        Node node = new Node(person);
        node.setPrevious(last);
        last = node;
        size++;
    }

    public void add(Person person, int index) {
        Node node = new Node(person);
        if (index <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (index > size + 1) {
            System.out.println("Index cannot be higher than list's size");
        } else if (index == size + 1) {
            node.setPrevious(last);
            last = node;
            size++;
        } else {
            int tempIndex = size;
            Node temp = last;
            while (tempIndex != index) {
                temp = temp.getPrevious();
                tempIndex--;
            }
            node.setPrevious(temp.getPrevious());
            temp.setPrevious(node);
            size++;
        }
    }

    public void remove(int index) {
        if (index <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (index > size) {
            System.out.println("Index cannot be higher than list's size");
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

    public void set(int indexToReplace, Person newPerson) {
        if (indexToReplace <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (indexToReplace > size) {
            System.out.println("Index cannot be higher than list's size");
        } else if (indexToReplace == size) {
            last.setPerson(newPerson);
        } else {
            Node temp = last;
            int tempIndex = size - 1;
            while (tempIndex != indexToReplace) {
                temp = temp.getPrevious();
                tempIndex--;
            }
            temp.getPrevious().setPerson(newPerson);
        }

    }

    public void set(Person personToReplace, Person newPerson) {

        if (personToReplace == last.person) {
            last.setPerson(newPerson);
        }else {
            Node temp = last;
            while (temp.getPrevious().getPerson() != personToReplace) {
                temp = temp.getPrevious();
            }
           temp.getPrevious().setPerson(newPerson);
        }
    }

    public boolean contains(Person person) {
        Node temp = last;
        while (temp != null) {
            if (temp.getPerson() == person) {
                return true;
            }
            temp = temp.getPrevious();
        }
        return false;
    }


    @Override
    public String toString() {
        String result = "List[";
        Node temp = last;
        if (size == 0) {
            return "List is empty";
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
