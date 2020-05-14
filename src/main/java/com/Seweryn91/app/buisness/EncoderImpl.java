package com.Seweryn91.app.buisness;

import com.Seweryn91.app.buisness.interfaces.Encoder;
import com.Seweryn91.app.buisness.model.CodonMaps;

import java.util.Map;
import java.util.Random;

public class EncoderImpl implements Encoder {

    private StringBuilder addLeadingAndTrailingChar(StringBuilder sequence) {
        sequence.insert(sequence.length(), "`");
        sequence.insert(0, "~");
        return sequence;
    }

    private String prepareSequence(String inputSequence) {
        StringBuilder inputSequenceBuilder = new StringBuilder(inputSequence);
        addLeadingAndTrailingChar(inputSequenceBuilder);
        return inputSequenceBuilder.toString();
    }

    @Override
    public String encode(String text) {
        CodonMaps codons = new CodonMaps();
        Map<String, String[]> encodingMap = codons.getEncypheringMap();
        String inputUppercase = text.toUpperCase();
        String preparedSequence = prepareSequence(inputUppercase);
        StringBuilder outputSequenceBuilder = new StringBuilder();
        String[] inputArray = preparedSequence.split("");

        for (String s : inputArray) {
            String[] array = encodingMap.get(s);
            Random random = new Random();

            if (encodingMap.get(s).length > 1) {
                String triplet = array[random.nextInt(array.length)];
                outputSequenceBuilder.append(triplet);
            } else {
                String triplet = array[0];
                outputSequenceBuilder.append(triplet);
            }
        }
        return outputSequenceBuilder.toString();
    }

}