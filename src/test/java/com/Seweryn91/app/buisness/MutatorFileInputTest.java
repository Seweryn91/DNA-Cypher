package com.Seweryn91.app.buisness;

import com.Seweryn91.app.GUI.PropertiesManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class MutatorFileInputTest {

    private TextFilePreparatorImpl textFilePreparator = new TextFilePreparatorImpl();
    private EncoderImpl encoder = new EncoderImpl();
    private DecoderImpl decoder = new DecoderImpl();
    private PropertiesManager propertiesManager;
    private MutationKeyGeneratorImpl mutationKeyGenerator;
    private MutatorImpl mutator = new MutatorImpl();
    private DemutatorImpl demutator = new DemutatorImpl();

    @BeforeEach
    void setup() {
        propertiesManager = new PropertiesManager();
        propertiesManager.init();
        propertiesManager.enableDeletions();
        propertiesManager.enableDuplications();
        propertiesManager.enableInsertions();
        propertiesManager.enableInversions();
        //TODO: FIX SUBS propertiesManager.enableSubstitutions();
        propertiesManager.enableTranslocations();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
    }

    @Test
    void testEncoderDecoder_sampleTestFile() {
        File file = new File("src/test/resources/test.txt");
        String prepared = textFilePreparator.prepareTextFile(file);
        String expected = prepared.toUpperCase();
        String encoded = encoder.encode(expected);
        String key = mutationKeyGenerator.generateKey(encoded);
        String mutated = mutator.mutate(key, encoded);
        String demutated = demutator.demutate(key, mutated);
        String actual = decoder.decode(demutated);
        assertEquals(expected, actual);
    }
}
