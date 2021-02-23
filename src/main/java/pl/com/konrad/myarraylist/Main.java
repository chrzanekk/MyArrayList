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
    }

}
