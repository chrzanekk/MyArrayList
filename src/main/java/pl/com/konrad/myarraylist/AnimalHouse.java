package pl.com.konrad.myarraylist;

public class AnimalHouse<T extends Animal> {
    private T animal;

    public AnimalHouse(T animal) {
        this.animal = animal;
    }

    public void makeSound() {
        System.out.println(animal.toString());
    }
}
