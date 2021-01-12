package facultative1;

import java.util.Random;

public class HiddenNumber {

    private int number;

    public HiddenNumber(int maxValue) {
        Random rnd = new Random();
        number = rnd.nextInt(maxValue + 1);
    }

    public int getNumber() {
        return number;
    }
}
