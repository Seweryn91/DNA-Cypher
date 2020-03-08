package buisness;

import buisness.interfaces.Inserter;

public class InserterImpl implements Inserter {

    @Override
    public String insert(int offset, String toInsert, String sequence) {
        StringBuilder insertionBuilder = new StringBuilder(sequence);
        insertionBuilder.insert(offset, toInsert);
        return insertionBuilder.toString();
    }

}
