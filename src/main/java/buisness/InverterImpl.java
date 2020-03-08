package buisness;

import buisness.interfaces.Inverter;

public class InverterImpl implements Inverter {

    @Override
    public String invert(int startIndex, int endIndex, String sequence) {
        String toInvert = sequence.substring(startIndex, endIndex);
        StringBuilder sequenceBuilder = new StringBuilder(sequence);
        StringBuilder sequenceInverter = new StringBuilder(toInvert);
        String inverted = sequenceInverter.reverse().toString();
        sequenceBuilder.delete(startIndex, endIndex);
        sequenceBuilder.insert(startIndex,inverted);
        return sequenceBuilder.toString();
    }
}
