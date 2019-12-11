package stack;

import dataStructuresWithWrapper.Person;

public class MainCustomStack {

    public static void main(String[] args) {

        Person p1 = new Person("name1", "surname1");
        Person p2 = new Person("name2", "surname2");
        Person p3 = new Person("name3", "surname3");
        Person p4 = new Person("name4", "surname4");

        CustomStack stack = new CustomStack();

        stack.add(p1);
        stack.add(p2);
        stack.add(p3);
        stack.getSize();
        System.out.println(stack);
        stack.getSize();
        System.out.println(stack);
stack.remove(2);
        stack.getSize();
        System.out.println(stack);

    }
}
