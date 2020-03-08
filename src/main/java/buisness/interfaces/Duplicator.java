package buisness.interfaces;

public interface Duplicator {

    String duplicateBase(int index, String sequence);

    String duplicateSequence(int startIndex, int endIndex, String sequence);
}
