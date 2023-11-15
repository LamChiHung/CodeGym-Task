public class Main {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal1 = animalFactory.getAnimal("dog");
        Animal animal2 = animalFactory.getAnimal("cat");
        System.out.println("animal1 makeSound: " + animal1.makeSound());
        System.out.println("animal2 makeSound: " + animal2.makeSound());
    }
}