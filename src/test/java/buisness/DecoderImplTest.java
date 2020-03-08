package buisness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderImplTest {

    private DecoderImpl decoder = new DecoderImpl();

    @Test
    void testDecode_singleTriplet() {
        String input = "ATCAAAATT";
        String expected = "N";
        String actual = decoder.decode(input);
        assertEquals(expected, actual);
    }

    @Test
    void testDecode_multipleTriplets() {
        String input = "ATACAAGGAAGAACT";
        String expected = "STOP";
        String actual = decoder.decode(input);
        assertEquals(expected, actual);
    }

    @Test
    void testDecode_multipleTripletsWithAdditionalBases() {
        String input = "GGCTAAGTATACATTAAGTCC";
        String expected = "JIM";
        String actual = decoder.decode(input);
        assertEquals(expected, actual);
    }

    @Test
    void testDecode_textWithPrematureTermination() {
        String input = "GTATACAGAGGAAAACTAACAACCCGAGCAGTATTTACTGTACGA";
        String expected = "IMPONDERABIL";
        String actual = decoder.decode(input);
        assertEquals(expected, actual);
    }

    @Test
    void testDecode_testWithLateStarter() {
        String input = "TTAACGCCCATCGTATACAGAGGAAAACTAACAACCCGAGCAGTATTTGTACGAATT";
        String expected = "IMPONDERABILIA";
        String actual = decoder.decode(input);
        assertEquals(expected, actual);
    }
}