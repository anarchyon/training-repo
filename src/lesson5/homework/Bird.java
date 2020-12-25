package lesson5.homework;

//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
// прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
// плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).

public class Bird extends Animal{
    public Bird() {
        name = "птичка";
        running = 5;
        jumping = 0.2;
    }

    @Override
    public void swim(int meters) {
        System.out.println(name + " не умеет плавать");
    }
}
