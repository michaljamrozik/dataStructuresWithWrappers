package list;


import items.Person;

public class CustomList<T> {

    private int size;
    private Node<T> last;

    public void setLast(T last) {
        this.last.setItem(last);
    }

    public int getSize() {
        System.out.println("List's size: " + size);
        return size;
    }

    public T getLast() {
        return  last.getItem();
    }

    public void add(T item) {
        Node node = new Node(item);
        node.setPrevious(last);
        last = node;
        size++;
    }

    public void add(T item, int index) {
        Node node = new Node(item);
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

    public void set(int indexToReplace, T item) {
        if (indexToReplace <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (indexToReplace > size) {
            System.out.println("Index cannot be higher than list's size");
        } else if (indexToReplace == size) {
            last.setItem(item);
        } else {
            Node temp = last;
            int tempIndex = size - 1;
            while (tempIndex != indexToReplace) {
                temp = temp.getPrevious();
                tempIndex--;
            }
            temp.getPrevious().setItem(item);
        }

    }

    public void set(T itemToReplace, T newItem) {

        if (itemToReplace == last.item) {
            last.setItem(newItem);
        }else {
            Node temp = last;
            while (temp.getPrevious().getItem() != itemToReplace) {
                temp = temp.getPrevious();
            }
           temp.getPrevious().setItem(newItem);
        }
    }

    public boolean contains(Person person) {
        Node temp = last;
        while (temp != null) {
            if (temp.getItem() == person) {
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
                result += temp.getItem() + " --> ";
                temp = temp.getPrevious();
            }
            result += temp.getItem() + "]";
        }
        return result;
    }

    //klasa węwnętrzna
    private class Node<T> {
        private Node previous;
        private T item;


        private Node(T item) {
            this.item = item;
        }

        private Node getPrevious() {
            return previous;
        }

        private void setPrevious(Node previous) {
            this.previous = previous;
        }

        private T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
}
