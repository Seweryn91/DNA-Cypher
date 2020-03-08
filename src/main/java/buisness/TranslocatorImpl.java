package buisness;

import buisness.interfaces.Translocator;

public class TranslocatorImpl implements Translocator {

    @Override
    public String translocate(int startIndex, int endIndex, int destIndex, String sequence) {
        String transgene = sequence.substring(startIndex, endIndex);
        StringBuilder sequenceBuilder = new StringBuilder(sequence);
        sequenceBuilder.insert(destIndex, transgene);
        sequenceBuilder.delete(startIndex, endIndex);
        return sequenceBuilder.toString();
    }
}
