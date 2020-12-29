package lesson5.homework;

import java.util.Random;

public class Dog extends Animal{

    private static final String TYPE = "Собака";
    private static final int DEFAULT_RUNNING = 500;
    private static final double DEFAULT_JUMPING = 0.5;
    private static final int DEFAULT_SWIMMING = 10;

    public Dog(String name) {
        super(name, DEFAULT_RUNNING, DEFAULT_JUMPING, DEFAULT_SWIMMING);
        type = TYPE;
    }
}
