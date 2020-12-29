package lesson5.homework;

//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
// прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
// плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).

public class Bird extends Animal{

    private static final String TYPE = "Птица";
    private static final int DEFAULT_RUNNING = 5;
    private static final double DEFAULT_JUMPING = 0.2;
    private static final int DEFAULT_SWIMMING = 0;

    public Bird(String name) {
        super(name, DEFAULT_RUNNING, DEFAULT_JUMPING, DEFAULT_SWIMMING);
        type = TYPE;
    }

    @Override
    public int swim(int meters) {
        return SWIM_IMPOSSIBLE;
    }
}
