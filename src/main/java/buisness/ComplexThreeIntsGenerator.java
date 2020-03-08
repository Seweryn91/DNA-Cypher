package buisness;

import buisness.interfaces.RandomThreeIntsGenerator;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ComplexThreeIntsGenerator implements RandomThreeIntsGenerator {

    public int[] getThreeRandomInts(int max) {
        int firstInt = ThreadLocalRandom.current().nextInt(0, max);
        int secondInt = ThreadLocalRandom.current().nextInt(0, max);
        int thirdInt = ThreadLocalRandom.current().nextInt(0, max);

        if (firstInt == secondInt || firstInt == thirdInt) {
            firstInt = ThreadLocalRandom.current().nextInt(0, max);
        }

        int[] array = new int[3];
        array[0] = firstInt;
        array[1] = secondInt;
        array[2] = thirdInt;

        Arrays.sort(array);
        return array;
    }
}
