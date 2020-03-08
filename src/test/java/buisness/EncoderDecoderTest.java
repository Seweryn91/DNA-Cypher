package buisness;

import buisness.interfaces.Decoder;
import buisness.interfaces.Demutator;
import buisness.interfaces.Encoder;
import buisness.interfaces.Mutator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EncoderDecoderTest {

    private Encoder encoder = new EncoderImpl();
    private Decoder decoder = new DecoderImpl();
    private Mutator mutator = new MutatorImpl();
    private Demutator demutator = new DemutatorImpl();

    @Test
    void testEncoderDecoder_simpleString() {
        String input = "STRING";
        String encoded = encoder.encode(input);
        String decoded = decoder.decode(encoded);
        assertEquals(input, decoded);
    }

    @Test
    void testEncoderDecoder_stringWithSpaces() {
        String input = "THIS IS SPARTA";
        String encoded = encoder.encode(input);
        String decoded = decoder.decode(encoded);
        assertEquals(input, decoded);
    }

    @Test
    void testEncoderDecoder_stringWithDuplication() {
        String input = "RANDOM TEXT";
        String encoded = encoder.encode(input);
        String mutationKey = "11dupA";
        String mutated = mutator.mutate(mutationKey, encoded);
        String demutated = demutator.demutate(mutationKey, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncoderDecoder_stringWithDeletion() {
        String input = "RANDOM TEXT";
        String encoded = encoder.encode(input);
        String mutationKey = "11delA";
        String mutated = mutator.mutate(mutationKey, encoded);
        String demutated = demutator.demutate(mutationKey, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncoderDecoder_stringWithInsertion() {
        String input = "LATE NIGHT CODING";
        String encoded = encoder.encode(input);
        String mutationKey = "11insC";
        String mutated = mutator.mutate(mutationKey, encoded);
        String demutated = demutator.demutate(mutationKey, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncoderDecoder_stringWithSubstitution() {
        String input = "BULLET THE DOG";
        String encoded = encoder.encode(input);
        String mutationKey = "14T>G";
        String mutated = mutator.mutate(mutationKey, encoded);
        String demutated = demutator.demutate(mutationKey, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncoderDecoder_stringWithSubstitutionAndInversion() {
        String input = "PETYR \"LITTLEFINGER\" BAELISH";
        String encoded = encoder.encode(input);
        String mutationKey = "27T>A.37_76inv";
        String mutated = mutator.mutate(mutationKey, encoded);
        String demutated = demutator.demutate(mutationKey, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }
}
