package queue;


import items.Car;
import items.Person;

public class MainCustomQueue {

    public static void main(String[] args) {

        Person p1 = new Person("name1", "surname1");
        Person p2 = new Person("name2", "surname2");
        Person p3 = new Person("name3", "surname3");
        Person p4 = new Person("name4", "surname4");
        Person p5 = new Person("name4", "surname4");

        Car c1 = new Car("brand1", "model1");
        Car c2 = new Car("brand2", "model2");

        CustomQueue<Person> queue = new CustomQueue<>();
        CustomQueue<Car> queue1 = new CustomQueue<>();

        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);
        queue.getSize();
        System.out.println(queue);
        queue.delete();
        queue.getSize();
        System.out.println(queue);
        System.out.println(queue.contains(p1));

        System.out.println("-----------");
        queue1.add(c1);
        queue1.add(c2);
        System.out.println(queue1);
        queue1.delete();
        queue1.getSize();
        System.out.println(queue1);



            }
}
