package com.Seweryn91.app.buisness;

import com.Seweryn91.app.GUI.PropertiesManager;
import com.Seweryn91.app.buisness.interfaces.Encoder;
import com.Seweryn91.app.buisness.interfaces.MutationKeyGenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MutationKeyGenTest {

    private MutationKeyGenerator mutationKeyGenerator;
    private PropertiesManager propertiesManager;
    private Encoder encoder = new EncoderImpl();
    private String sequence = "NEVER GONNA GIVE YOU UP, NEVER GONNA LET YOU DOWN";
    private String encoded = encoder.encode(sequence);


    @BeforeEach
    void setup() {
        propertiesManager = new PropertiesManager();
        propertiesManager.init();
    }

    @Test
    void testKeyGeneration_emptyProperties() {
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String key = mutationKeyGenerator.generateKey(encoded);
        String[] keyFragmented = key.split(".");
        Arrays.asList(keyFragmented).forEach(s -> assertEquals("", s));
    }

    @Test
    void testKeyGeneration_deletionsEnabled() {
        propertiesManager.enableDeletions();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String key = mutationKeyGenerator.generateKey(encoded);
        String[] keySplitted = key.split("del");
        Character deletedBase = keySplitted[1].charAt(0);
        int index = Integer.parseInt(keySplitted[0]);
        assertTrue(index < encoded.length());
        assertEquals(encoded.charAt(index), deletedBase);
    }


    @Test
    void testKeyGeneration_duplicationsEnabled() {
        propertiesManager.enableDuplications();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String key = mutationKeyGenerator.generateKey(encoded);
        String[] keySplitted = key.split("dup");
        Character duplicatedBase = keySplitted[1].charAt(0);
        int index = Integer.parseInt(keySplitted[0]);
        assertEquals(encoded.charAt(index), duplicatedBase);
    }

    @Test
    void testKeyGeneration_inversionsEnabled() {
        propertiesManager.enableInversions();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String key = mutationKeyGenerator.generateKey(encoded);
        String[] keySplitted = key.split("_");
        String keyStart = keySplitted[0];
        String keyEnd = keySplitted[1].replaceAll("\\D", "");
        int beginIndex = Integer.parseInt(keyStart);
        int endIndex = Integer.parseInt(keyEnd);
        assertTrue(beginIndex < endIndex);
        assertTrue(beginIndex < encoded.length());
        assertTrue(endIndex < encoded.length());
    }

    @Test
    void testKeyGeneration_substitutionsEnabled() {
        propertiesManager.enableSubstitutions();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String key = mutationKeyGenerator.generateKey(encoded);
        String[] keySplitted = key.split(">");
        String keyStart = keySplitted[0].replaceAll("\\D", "");
        int substitutionIndex = Integer.parseInt(keyStart);
        Character baseSubstituted = keySplitted[0].replaceAll("[^A-Z]", "").charAt(0);
        Character expected = encoded.charAt(substitutionIndex);
        assertEquals(expected, baseSubstituted);
    }

    @Test
    void testKeyGeneration_translocationsEnabled() {
        propertiesManager.enableTranslocations();
        mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String key = mutationKeyGenerator.generateKey(encoded);
        System.out.println(key);
        String[] keySplitted = key.split("t");
        String[] indexes = keySplitted[0].split("_");
        int startIndex = Integer.parseInt(indexes[0]);
        int endIndex = Integer.parseInt(indexes[1]);
        int destIndex = Integer.parseInt(keySplitted[1].replaceAll("\\D", ""));
        String translocated = encoded.substring(startIndex, endIndex);
    }
}
