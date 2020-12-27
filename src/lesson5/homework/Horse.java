package lesson5.homework;

//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
// прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
// плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).

public class Horse extends Animal{

    private static final String TYPE = "Лошадь";
    private static final int DEFAULT_RUNNING = 1500;
    private static final double DEFAULT_JUMPING = 3;
    private static final int DEFAULT_SWIMMING = 100;

    public Horse(String name, boolean isStandardAnimal) {
        super(name, isStandardAnimal, DEFAULT_RUNNING, DEFAULT_JUMPING, DEFAULT_SWIMMING);
        type = TYPE;
    }
}
