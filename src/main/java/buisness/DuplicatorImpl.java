package buisness;

import buisness.interfaces.Duplicator;

public class DuplicatorImpl implements Duplicator {

    @Override
    public String duplicateBase(int index, String sequence) {
        char duplicateBase = sequence.charAt(index);
        StringBuilder sequenceBuilder = new StringBuilder(sequence);
        sequenceBuilder.insert(index, duplicateBase);
        return sequenceBuilder.toString();
    }

    @Override
    public String duplicateSequence(int startIndex, int endIndex, String sequence) {
        String duplicateSequence = sequence.substring(startIndex, endIndex);
        StringBuilder sequenceBuilder = new StringBuilder(sequence);
        sequenceBuilder.insert(endIndex, duplicateSequence);
        return sequenceBuilder.toString();
    }
}
