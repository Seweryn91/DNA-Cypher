package buisness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutatorImplTest {

    private MutatorImpl mutator = new MutatorImpl();

    @Test
    void testMutate_emptyString() {
        String input = "";
        String mutationKey = "";
        String expected = "";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_emptyKey() {
        String input = "INPUT";
        String mutationKey = "";
        String expected = "INPUT";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_deletion() {
        String input = "IMPONDERABILIA";
        String mutationKey = "2delP";
        String expected = "IMONDERABILIA";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);

    }

    @Test
    void testMutate_duplication() {
        String input = "IMPONDERABILIA";
        String mutationKey = "2dupP";
        String expected = "IMPPONDERABILIA";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_insertion() {
        String input = "IMPONDERABILIA";
        String mutationKey = "4insU";
        String expected = "IMPOUNDERABILIA";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_invertion() {
        String input = "IMPONDERABILIA";
        String mutationKey = "1_13inv";
        String expected = "IILIBAREDNOPMA";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_substitution() {
        String input = "IMPONDERABILIA";
        String mutationKey = "7R>Z";
        String expected = "IMPONDEZABILIA";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_deletionAndDuplication() {
        String input = "IMPONDERABILIA";
        String mutationKey = "7delR.1dupM";
        String expected = "IMMPONDEABILIA";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_deletionAndInsertion() {
        String input = "GGTCAACCAGTAATAGTAATACAAACAGCGCAATACACAATAATACGAGTTACATCTTCCTTGCTGACGCTCGTCCCGCCTCCCACT";
        String mutationKey = "0delG.62insA";
        String expected = "GTCAACCAGTAATAGTAATACAAACAGCGCAATACACAATAATACGAGTTACATCTTCCTTGACTGACGCTCGTCCCGCCTCCCACT";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }

    @Test
    void testMutate_deletionInsertionAndSubstitution() {
        String input = "GGCCAACCAGTAATAGTAATACAAACAGCGCAATACACAATAATACGAGTTACATCTTCCTTGCTGACGCTCGTCCCGCCTCCCATT";
        String mutationKey = "75delC.39insT.11A>C";
        String expected = "GGCCAACCAGTCATAGTAATACAAACAGCGCAATACACATATAATACGAGTTACATCTTCCTTGCTGACGCTCGTCCGCCTCCCATT";
        String actual = mutator.mutate(mutationKey, input);
        assertEquals(expected, actual);
    }




}