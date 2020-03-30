package buisness;

import buisness.interfaces.TextFilePreparator;

import java.io.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class TextFilePreparatorImpl implements TextFilePreparator {

    private String readText(File file) {
        BufferedReader reader;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private boolean isCharAllowed(Character c) {
        Character[] allowedChars = {'.', ',', '\n', ':', ';', '\'', '\"', '+', '-', '=', '*', '?', '!', '%', '(', ')',
                '/', ' ', '^', '@'};
        if (Character.isLetterOrDigit(c)) return true;
        else {
            for (Character allowedChar : allowedChars) {
                if (c.equals(allowedChar)) return true;
            }
        }
        return false;
    }

    @Override
    public String prepareTextFile(File text) {
        String input = readText(text);
        String stringReplacedChars = input.replace("`", "'").replace("~", "-");
        Stream<Character> characterStream = new String(stringReplacedChars).chars().mapToObj(i -> (char) i);
        return characterStream.filter(c -> isCharAllowed(c)).collect(Collector.of(StringBuilder::new,
                StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }
}
