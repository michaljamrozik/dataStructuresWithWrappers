package stack;

public class CustomStack<T> {
    private int size;
    private Node <T> last;

    public void add(T item) {
        Node node = new Node(item);
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

    public boolean contains(T item) {
        if (size == 0) {
            return false;
        } else {
            Node temp = last;
            while (temp != null) {
                if (temp.getItem() == item) {
                    return true;
                }
                temp = temp.getPrevious();
            }
        }
        return false;
    }

    public T getPeek() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return  last.getItem();
        } else {
            Node<T> temp = last;
            while (temp.getPrevious() != null) {
                temp = temp.getPrevious();
            }
            return temp.getItem();
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

    public void remove(T item) {
        if (size == 1 && item == last.getItem()) {
            last = null;
            size--;
        } else if (last.getItem() == item) {
            last = last.getPrevious();
            size--;
        } else {
            Node temp = last;
            Node tempIndex = last.previous;
            while (tempIndex != null) {
                if (tempIndex.getItem() == item) {
                    temp.setPrevious(tempIndex.getPrevious());
                }
                temp = temp.getPrevious();
                tempIndex = tempIndex.getPrevious();
                size--;
            }
        }

    }

    public T getLast() {
        return last == null ? null :  last.getItem();
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
    }
}

