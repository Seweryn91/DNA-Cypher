package com.Seweryn91.app.buisness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncoderImplTest {

    private EncoderImpl encoder = new EncoderImpl();

    @Test
    void testEncode_withoutSpaces() {
        String input = "IMPONDERABILIA";
        String encoded = encoder.encode(input);
        String core = encoded.substring(3, encoded.length()-3);
        String expectedCore = "GTATACAGAGGAAAACTAACAACCCGAGCAGTATTTGTACGA";
        assertEquals(expectedCore, core);
    }

    @Test
    void testEncode_onlyWhitespace() {
        String input = " ";
        String expected0 = "ATG";
        String expected1 = "TGT";
        String expected2 ="GAG";
        String actual = encoder.encode(input);
        String core = actual.substring(3, actual.length()-3);
        assertTrue(expected0.equals(core) || expected1.equals(core) || expected2.equals(core));
    }

    @Test
    void testEncode_withSpaces() {
        String input = "TOMMY SHELBY";
        String expected0 = "CAAGGATACTACGCTTGTATACCAACATTTGCAGCT";
        String expected1 = "CAAGGATACTACGCTGAGATACCAACATTTGCAGCT";
        String expected2 = "CAAGGATACTACGCTATGATACCAACATTTGCAGCT";
        String actual = encoder.encode(input);
        String core = actual.substring(3, actual.length()-3);
        assertTrue(expected0.equals(core) || expected1.equals(core) || expected2.equals(core));
    }
}