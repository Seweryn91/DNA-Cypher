package buisness;

import buisness.interfaces.Decoder;
import buisness.model.CodonMaps;

import java.util.Map;

public class DecoderImpl implements Decoder {

    private String[] splitToTripletArray(String text) {
        return text.split("(?<=\\G.{3})");
    }

    private int findFirstStartCodon(String[] tripletArray) {
        String[] startCodons = {"ATC", "GGT", "GGC"};

        for (int i = 0; i < tripletArray.length; i++) {
            String starter = tripletArray[i];
            if (starter.equals(startCodons[0]) || starter.equals(startCodons[1]) || starter.equals(startCodons[2]))
                return i+1;
        }
        return 0;
    }


    @Override
    public String decode(String text) {
        CodonMaps codonMaps = new CodonMaps();
        Map<String, String> decypheringMap = codonMaps.getDecypheringMap();
        StringBuilder outputBuilder = new StringBuilder();
        String[] tripletArray = splitToTripletArray(text);
        Character endchar = '`';

        int startIndex = findFirstStartCodon(tripletArray);
        for (int i = startIndex; i < tripletArray.length; i++) {
            String letter = decypheringMap.get(tripletArray[i]);
            if (letter == null || letter.equals("`")) break;
            outputBuilder.append(letter);
        }

        if (outputBuilder.length() > 0) {
            Character lastChar = outputBuilder.charAt(outputBuilder.length() - 1);
            if (lastChar.equals(endchar)) outputBuilder.deleteCharAt(outputBuilder.length() - 1);
        }
        return outputBuilder.toString();
    }

}
