package lesson5.homework;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Horse horse = new Horse();
        Bird bird = new Bird();

        bird.run(50);
        bird.jump(0.1);
        bird.swim(10);
        horse.swim(10);
    }
}
