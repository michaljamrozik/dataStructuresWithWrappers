package list;


import dataStructuresWithWrapper.Person;

public class MainCustomList {
    public static void main(String[] args) {

        CustomList list = new CustomList();

        Person p1 = new Person("name1", "surname1");
        Person p2 = new Person("name2", "surname2");
        Person p3 = new Person("name3", "surname3");
        Person p4 = new Person("name4", "surname4");
        Person p5 = new Person("NEW", "NEW");
        Person p6 = new Person("REPLACE", "REPLACE");
        Person p7 = new Person("REPLACE2", "REPLACE2");

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

    }
}
