package lesson5.homework;

public class Animal {

    protected String name;
    protected int running;
    protected double jumping;
    protected int swimming;

    public void run(int meters) {
        System.out.println(name + ((meters <= running)?" пробежал ":" не смог пробежать ") + meters + " метров");
    }

    public void jump(double meters) {
        System.out.println(name + ((meters <= jumping)?" перепрыгнул ":" не смог перепрыгнуть ") + meters + " метров");
    }

    public void swim(int meters) {
        System.out.println(name + ((meters <= swimming)?" проплыл ":" не смог проплыть ") + meters + " метров");
    }

    public void setName(String name) {
        this.name = name;
    }
}
