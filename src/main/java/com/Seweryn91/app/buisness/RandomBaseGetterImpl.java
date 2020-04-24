package com.Seweryn91.app.buisness;

import com.Seweryn91.app.buisness.interfaces.RandomBaseGetter;

import java.util.Random;

public class RandomBaseGetterImpl implements RandomBaseGetter {

    @Override
    public String getRandomBase() {
        Random r = new Random();
        return BASES[r.nextInt(BASES.length)];
    }
}
