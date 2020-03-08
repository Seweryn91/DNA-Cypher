package buisness;

import buisness.interfaces.*;

import org.apache.commons.lang3.ArrayUtils;

public class DemutatorImpl implements Demutator {

    public DemutatorImpl() {    }

    @Override
    public String demutate(String mutationKey, String sequence) {
        if (sequence == null || sequence.equals("")) return "";
        if (mutationKey == null || mutationKey.equals("")) return sequence;

        String[] mutationsArray = mutationKey.split("\\.");
        ArrayUtils.reverse(mutationsArray);
        for (String mutation : mutationsArray) {

            if (mutation.contains(">")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Substitutor substitutor = new SubstitutorImpl();
                int symbolIndex = mutation.indexOf('>');
                int index = Integer.parseInt(mutation.substring(0, symbolIndex - 1));
                String replacement = mutation.substring(mutation.indexOf('>') - 1, symbolIndex);
                mutatorBuilder = new StringBuilder(substitutor.substitute(index, replacement, sequence));
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

            if (mutation.contains("ins")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Deleter deleter = new DeleterImpl();
                int index = Integer.parseInt(mutation.substring(0, mutation.indexOf("ins")));
                mutatorBuilder = new StringBuilder(deleter.delete(index, sequence));
                sequence = mutatorBuilder.toString();
            }

            if (mutation.contains("dup")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Deleter deleter = new DeleterImpl();
                int index = Integer.parseInt(mutation.substring(0, mutation.indexOf("dup")));
                mutatorBuilder = new StringBuilder(deleter.delete(index, sequence));
                sequence = mutatorBuilder.toString();
            }

            if (mutation.contains("del")) {
                StringBuilder mutatorBuilder = new StringBuilder(sequence);
                Inserter inserter = new InserterImpl();
                int index = Integer.parseInt(mutation.substring(0, mutation.indexOf("del")));
                String baseRemoved = mutation.substring(mutation.indexOf("del") + 3);
                mutatorBuilder = new StringBuilder(inserter.insert(index, baseRemoved, sequence));
                sequence = mutatorBuilder.toString();
            }
        }
        return sequence;
    }
}
