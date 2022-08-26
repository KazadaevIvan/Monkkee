package utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int getRandomNumber() {
        return new Random().nextInt();
    }
}
