package queue;

public class CustomQueue<T> {

    private int size;
    private Node<T> last;

    public void add(T item) {
        Node node = new Node(item);
        node.setPrevious(last);
        last = node;
        size++;
    }

    public void delete() {
        if (size == 0) {
            System.out.println("Operation is impossible, queue is empty");
        } else if (size == 1) {
            last = null;
            size--;
        } else {
            Node<T> temp = last;
            while (temp.getPrevious().getPrevious() != null) {
                temp = temp.getPrevious();
            }
            temp.setPrevious(null);
            size--;
        }
    }

    public boolean contains(T item) {
        Node <T> temp = last;
        while (temp != null) {
            if (temp.getItem() == item) {
                return true;
            }
            temp = temp.getPrevious();
        }
        return false;
    }

    public T getLast() {
        return last == null ? null : last.getItem();
    }

    public int getSize() {
        System.out.println("Queue's lenght:  " + size);
        return size;
    }

    @Override
    public String toString() {
        String result = "Queue[";
        Node <T> temp = last;
        if (size == 0) {
            return "Queue is empty";
        } else {
            while (temp.getPrevious() != null) {
                result += temp.getItem() + " --> ";
                temp = temp.getPrevious();
            }
            result += temp.getItem();
        }
        return result + "]";


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
    }
}

