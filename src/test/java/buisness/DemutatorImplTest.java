package buisness;

import buisness.interfaces.Demutator;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DemutatorImplTest {

    private Demutator demutator = new DemutatorImpl();


    @Test
    void demutateTest_testDeletion() {
        String input = "IMPONDERAILIA";
        String mutationKey = "9delB";
        String expected = "IMPONDERABILIA";
        String actual = demutator.demutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void demutateTest_testDuplication() {
        String input = "IMPPONDERABILIA";
        String mutationKey = "2dupP";
        String expected = "IMPONDERABILIA";
        String actual = demutator.demutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void demutateTest_testInsertion() {
        String input = "IMPONDERAHBILIA";
        String mutationKey = "9insH";
        String expected = "IMPONDERABILIA";
        String actual = demutator.demutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void demutateTest_testInversion() {
        String input = "AKJIHGFEDCBL";
        String mutationKey = "1_11inv";
        String expected = "ABCDEFGHIJKL";
        String actual = demutator.demutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void demutateTest_testSubstitution() {
        String input = "IMPINDERABILIA";
        String mutationKey = "4O>I";
        String expected = "IMPONDERABILIA";
        String actual = demutator.demutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void demutateTest_testInsertionWithTransition() {
        MutatorImpl mutator = new MutatorImpl();
        String input = "AaBbCcDdEeFf";
        String mutationKey = "4insZ.3_5t10";
        String mutated = mutator.mutate(mutationKey, input);
        String expected = "AaBbCcDdEeFf";
        String actual = demutator.demutate(mutationKey, mutated);
        assertEquals(expected, actual);
    }

}