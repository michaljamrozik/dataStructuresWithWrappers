package list;


import items.Car;
import items.Person;

public class MainCustomList {
    public static void main(String[] args) {



        Person p1 = new Person("name1", "surname1");
        Person p2 = new Person("name2", "surname2");
        Person p3 = new Person("name3", "surname3");
        Person p4 = new Person("name4", "surname4");
        Person p5 = new Person("NEW", "NEW");
        Person p6 = new Person("REPLACE", "REPLACE");
        Person p7 = new Person("REPLACE2", "REPLACE2");

        Car c1 = new Car("brand1", "model1");
        Car c2 = new Car("brand2", "model2");

        CustomList<Person> list = new CustomList<>();
        CustomList<Car> list1 = new CustomList<>();

        list.getSize();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.getSize();
        System.out.println(list);

        list.set(p2,p6);
        list.getSize();
        System.out.println(list);
        list.set(1,p7);
        list.getSize();
        System.out.println(list);

        System.out.println("-----------");

        list1.add(c1);
        list1.add(c2);
        System.out.println(list1);
    }
}
