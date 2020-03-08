package buisness;

import buisness.interfaces.RandomBaseGetter;

import java.util.Random;

public class RandomBaseGetterImpl implements RandomBaseGetter {

    @Override
    public String getRandomBase() {
        Random r = new Random();
        return BASES[r.nextInt(BASES.length)];
    }
}
