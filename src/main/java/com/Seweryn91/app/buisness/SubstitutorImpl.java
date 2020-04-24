package com.Seweryn91.app.buisness;

import com.Seweryn91.app.buisness.interfaces.Substitutor;


public class SubstitutorImpl implements Substitutor {

    @Override
    public String substitute(int index, String replacement, String sequence) {
        String beginning = sequence.substring(0, index);
        String ending = sequence.substring(index+1);
        sequence = beginning + replacement + ending;
        return sequence;
    }
}
