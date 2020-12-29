package lesson5.homework;

public class Animal {

    private static final int SWIM_OK = 1;
    private static final int SWIM_FAIL = 0;
    protected static final int SWIM_IMPOSSIBLE = -1;

    private static final int RUNNING_PERCENT_OF_DIFFERENCE = 20;
    private static final double JUMPING_PERCENT_OF_DIFFERENCE = 30;
    private static final int SWIMMING_PERCENT_OF_DIFFERENCE = 50;

    protected String type;
    protected String name;
    protected int running;
    protected double jumping;
    protected int swimming;

    protected Animal(String name, int running, double jumping, int swimming) {
        this.name = name;
        this.running = (int) Math.round(getRandomValue(running, RUNNING_PERCENT_OF_DIFFERENCE));
        this.jumping = getRandomValue(jumping, JUMPING_PERCENT_OF_DIFFERENCE);
        this.swimming = (int) Math.round(getRandomValue(swimming, SWIMMING_PERCENT_OF_DIFFERENCE));
    }

    public boolean run(int meters) {
        return meters <= running;
    }

    public boolean jump(double meters) {
        return meters <= jumping;
    }

    public int swim(int meters) {
        return (meters <= swimming) ? SWIM_OK: SWIM_FAIL;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected static double getRandomValue(double value, double percentOfDifference) {
        double max = value * (1 + percentOfDifference / 100);
        double min = value * (1 - percentOfDifference / 100);
        return Math.random() * (max - min) + min;
    }

    public String getName() {
        return name;
    }

    public int getRunning() {
        return running;
    }

    public double getJumping() {
        return jumping;
    }

    public int getSwimming() {
        return swimming;
    }

    public String getAnimalInfo() {
        return type + " " + name + " может пробежать " + getRunning() + " метров, перепрыгнуть препятствие высотой " +
                String.format("%.2f", getJumping()) + " метров и проплыть " + getSwimming() + " метров.";
    }
}
