package buisness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatorImplTest {

    private DuplicatorImpl duplicator = new DuplicatorImpl();

    @Test
    void testDuplicateSingleBase() {
        String input = "AGTACTCGA";
        String expected = "AGTAACTCGA";
        String actual = duplicator.duplicateBase(3, input);
        assertEquals(expected, actual);
    }

    @Test
    void testDuplicateSequence() {
          String input = "GGCAATCGATTAGCCAATCGAATGCTAGCCGTACGCCGATTAGCCAATCGAACT";
          String expected = "GGCAATCGATTAGCCAATCGAATGTTAGCCAATCGAATGCTAGCCGTACGCCGATTAGCCAATCGAACT";
          String actual = duplicator.duplicateSequence(9, 24, input);
          assertEquals(expected, actual);
    }

}