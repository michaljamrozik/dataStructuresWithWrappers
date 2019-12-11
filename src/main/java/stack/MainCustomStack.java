package stack;

import items.Car;
import items.Person;

public class MainCustomStack {

    public static void main(String[] args) {

        Person p1 = new Person("name1", "surname1");
        Person p2 = new Person("name2", "surname2");
        Person p3 = new Person("name3", "surname3");
        Person p4 = new Person("name4", "surname4");


        Car c1 = new Car("brand1", "model1");
        Car c2 = new Car("brand2", "model2");

        CustomStack<Person> stack = new CustomStack<>();
        CustomStack<Car> stack1 = new CustomStack<>();

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

        System.out.println("-----------");

        stack1.add(c1);
        stack1.add(c1);

        System.out.println(stack1);

    }
}
