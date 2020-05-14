package com.Seweryn91.app.buisness;

import com.Seweryn91.app.buisness.interfaces.Deleter;

public class DeleterImpl implements Deleter {

    @Override
    public String delete(int offset, String sequence) {
        StringBuilder sequenceBuilder = new StringBuilder(sequence);
        sequenceBuilder.deleteCharAt(offset);
        return sequenceBuilder.toString();
    }
}
