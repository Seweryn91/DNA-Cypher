package com.Seweryn91.app.buisness;

import com.Seweryn91.app.buisness.interfaces.*;

public class MutatorImpl implements Mutator {

    public String mutate(String mutationKey, String sequence) {
        if (sequence == null || sequence.equals("")) return "";
        if (mutationKey == null || mutationKey.equals("")) return sequence;
        String[] mutationsArray = mutationKey.split("\\.");
        for (String mutation : mutationsArray) {
            if (mutation.contains("del")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Deleter deleter = new DeleterImpl();
                int index = Integer.parseInt(mutation.substring(0, mutation.indexOf("del")));
                mutatorBuilder = new StringBuilder(deleter.delete(index, sequence));
                sequence = mutatorBuilder.toString();
            }
            if (mutation.contains("dup")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Duplicator duplicator = new DuplicatorImpl();
                int index = Integer.parseInt(mutation.substring(0, mutation.indexOf("dup")));
                mutatorBuilder = new StringBuilder(duplicator.duplicateBase(index, sequence));
                sequence = mutatorBuilder.toString();
            }
            if (mutation.contains("ins")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Inserter inserter = new InserterImpl();
                int index = Integer.parseInt(mutation.substring(0, mutation.indexOf("ins")));
                String base = mutation.substring(mutation.length() - 1);
                mutatorBuilder = new StringBuilder(inserter.insert(index, base, sequence));
                sequence = mutatorBuilder.toString();
            }
            if (mutation.contains("inv")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Inverter inverter = new InverterImpl();
                int startIndex = Integer.parseInt(mutation.substring(0, mutation.indexOf('_')));
                int endIndex = Integer.parseInt(mutation.substring(mutation.indexOf('_') + 1, mutation.indexOf("inv")));
                mutatorBuilder = new StringBuilder(inverter.invert(startIndex, endIndex, sequence));
                sequence = mutatorBuilder.toString();
            }
            if (mutation.contains(">")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Substitutor substitutor = new SubstitutorImpl();
                int index = Integer.parseInt(mutation.substring(0, mutation.indexOf('>') - 1));
                String replacement = String.valueOf(mutation.charAt(mutation.length() - 1));
                mutatorBuilder = new StringBuilder(substitutor.substitute(index, replacement, sequence));
                sequence = mutatorBuilder.toString();
            }

        }
        return sequence;
    }

}
