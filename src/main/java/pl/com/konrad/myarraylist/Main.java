package pl.com.konrad.myarraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Map<Object,Object> map = new HashMap<>();
        AnimalHouse<Dog> dogAnimalHouse = new AnimalHouse<>(new Dog());
        AnimalHouse<Cat> catAnimalHouse = new AnimalHouse<>(new Cat());
        AnimalHouse<Goose> gooseAnimalHouse = new AnimalHouse<>(new Goose());

        dogAnimalHouse.makeSound();
        System.out.println("-------------");
        catAnimalHouse.makeSound();
        System.out.println("-------------");
        gooseAnimalHouse.makeSound();
        System.out.println("-------------");

        MyArrayList myArrayList = new MyArrayList();
        System.out.println("Initial size: " + myArrayList.size());
        Object test1 = new Object();
        myArrayList.add(test1);
        Object test2 = new Object();
        myArrayList.add(test2);
        Object test3 = new Object();
        myArrayList.add(test3);
        Object test4 = new Object();
        myArrayList.add(test4);
        Object test5 = new Object();
        myArrayList.add(test5);
        Object test6 = new Object();
        myArrayList.add(test6);
        System.out.println("New size: " + myArrayList.size());
        System.out.println("Object of index 9: " + myArrayList.get(9));
        System.out.println("Index of null object: " + myArrayList.indexOf(null));
        System.out.println("Index of test1 object: " + myArrayList.indexOf(test1));
        System.out.println("Index of test2 object: " + myArrayList.indexOf(test2));
        System.out.println("Index of test3 object: " + myArrayList.indexOf(test3));
        System.out.println("Index of test4 object: " + myArrayList.indexOf(test4));

        System.out.print("[");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + ", ");
        }
        System.out.println("]");

        myArrayList.remove(0);

        System.out.print("[");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + ", ");
        }
        System.out.println("]");
        System.out.println("New size after remove: " + myArrayList.size());

        System.out.println("------sublist test------");
        MyArrayList myNewSublist;
        myNewSublist = (MyArrayList) myArrayList.subList(1,6);
        System.out.print("[");
        for (int i = 0; i < myNewSublist.size(); i++) {
            System.out.print(myNewSublist.get(i) + ", ");
        }
        System.out.println("]");
        System.out.println(myNewSublist.size());

    }

}
