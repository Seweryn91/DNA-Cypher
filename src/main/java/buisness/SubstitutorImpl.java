package buisness;

import buisness.interfaces.Substitutor;


public class SubstitutorImpl implements Substitutor {

    @Override
    public String substitute(int index, String replacement, String sequence) {
        String beginning = sequence.substring(0, index-1);
        String ending = sequence.substring(index);
        sequence = beginning + replacement + ending;
        return sequence;
    }
}
