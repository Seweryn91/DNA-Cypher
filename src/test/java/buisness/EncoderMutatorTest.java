package buisness;

import GUI.PropertiesManager;
import buisness.interfaces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncoderMutatorTest {

    private Encoder encoder = new EncoderImpl();
    private Decoder decoder = new DecoderImpl();
    private Mutator mutator = new MutatorImpl();
    private Demutator demutator = new DemutatorImpl();
    private MutationKeyGenerator mutationKeyGenerator;
    private PropertiesManager propertiesManager;
    private String input = "THISISINPUTSTRING0123456789";

    @BeforeEach
    void setup() {
        propertiesManager = new PropertiesManager();
        propertiesManager.init();
    }

    @Test
    void testEncodeDecode_deletion() {
        propertiesManager.enableDeletions();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String encoded = encoder.encode(input);
        String key = mutationKeyGenerator.generateKey(encoded);
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncodeDecode_deletionAndDuplication() {
        propertiesManager.enableDeletions();
        propertiesManager.enableDuplications();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String encoded = encoder.encode(input);
        String key = mutationKeyGenerator.generateKey(encoded);
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncodeDecode_deletionDuplicationAndInsertion() {
        propertiesManager.enableDeletions();
        propertiesManager.enableDuplications();
        propertiesManager.enableInsertions();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String encoded = encoder.encode(input);
        String key = mutationKeyGenerator.generateKey(encoded);
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncodeDecode_deletionDuplicationInsertionAndInversion() {
        propertiesManager.enableDeletions();
        propertiesManager.enableDuplications();
        propertiesManager.enableInsertions();
        propertiesManager.enableInversions();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String encoded = encoder.encode(input);
        String key = mutationKeyGenerator.generateKey(encoded);
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncodeDecode_substitutions() {
        propertiesManager.enableSubstitutions();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String encoded = encoder.encode(input);
        String key = mutationKeyGenerator.generateKey(encoded);
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

    @Test
    void testEncodeDecode_deletionDuplicationInsertionInversionAndTranslocation() {
        String encoded = encoder.encode(input);
        String key = "24delA.18dupA.23insG.18_35inv.13_20t30";
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String actual = decoder.decode(demutated);
        assertEquals(input, actual);
    }

    @Test
    void testEncodeDecode_allMutations() {
        propertiesManager.enableDeletions();
        propertiesManager.enableDuplications();
        propertiesManager.enableInsertions();
        propertiesManager.enableInversions();
        propertiesManager.enableTranslocations();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String encoded = encoder.encode(input);
        String key = mutationKeyGenerator.generateKey(encoded);
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String decoded = decoder.decode(demutated);
        assertEquals(input, decoded);
    }

}
