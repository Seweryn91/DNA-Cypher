package buisness;

import GUI.PropertiesManager;
import buisness.interfaces.*;

import java.util.*;

public class MutationKeyGeneratorImpl implements MutationKeyGenerator {

    private PropertiesManager propertiesManager;
    private Map<String, Boolean> mutationsAllowed;


    public MutationKeyGeneratorImpl(PropertiesManager propertiesManager) {
        this.propertiesManager = propertiesManager;
        this.mutationsAllowed = propertiesManager.getProperties();
    }


    @Override
    public String generateKey(String sequence) {
        StringBuilder keyBuilder = new StringBuilder();
        StringBuilder sequencePrototype = new StringBuilder(sequence);
        int length = sequencePrototype.length();
        Random r0 = new Random();
        Random r1 = new Random();

        if (mutationsAllowed.get("del")) {
            int randomDeletionIndex = r0.nextInt(length);
            keyBuilder.append(randomDeletionIndex).append("del")
                    .append(sequence.charAt(randomDeletionIndex)).append(".");
            length = sequencePrototype.length();
        }
        if (mutationsAllowed.get("dup")) {
            int randomDuplicationIndex = r0.nextInt(length);
            keyBuilder.append(randomDuplicationIndex).append("dup")
                    .append(sequence.charAt(randomDuplicationIndex)).append(".");
            length = sequencePrototype.length();
        }
        if (mutationsAllowed.get("ins")) {
            RandomBaseGetterImpl randomBaseGetter = new RandomBaseGetterImpl();
            String randomBase = randomBaseGetter.getRandomBase();
            int randomInsertionIndex = r0.nextInt(length);
            keyBuilder.append(randomInsertionIndex).append("ins").append(randomBase).append(".");
            length = sequencePrototype.length();
        }
        if (mutationsAllowed.get("inv")) {
            Integer random1 = r0.nextInt(length);
            Integer random2 = r1.nextInt(length);

            if (random1.equals(random2)) {
                random2 = r1.nextInt(sequence.length());
            }

            int beginIndex = Math.min(random1, random2);
            int endIndex = Math.max(random1, random2);
            keyBuilder.append(beginIndex).append("_").append(endIndex).append("inv").append(".");
        }
        if (mutationsAllowed.get(">")) {
            RandomBaseGetterImpl randomBaseGetter = new RandomBaseGetterImpl();
            String randomBase = randomBaseGetter.getRandomBase();
            int randomSubstitutionIndex = r0.nextInt(length);
            while (sequence.substring(randomSubstitutionIndex, randomSubstitutionIndex+1).equals(randomBase)) {
                randomBase = randomBaseGetter.getRandomBase();
            }

            keyBuilder.append(randomSubstitutionIndex).append(sequencePrototype.charAt(randomSubstitutionIndex))
                    .append(">").append(randomBase).append(".");
        }
        if (mutationsAllowed.get("t")) {
            ComplexThreeIntsGenerator ctig = new ComplexThreeIntsGenerator();
            int[] randomInts = ctig.getThreeRandomInts(length);
            keyBuilder.append(randomInts[0]).append("_").append(randomInts[1]).append("t").append(randomInts[2])
                    .append(".");
        }

        return keyBuilder.toString();
    }
}