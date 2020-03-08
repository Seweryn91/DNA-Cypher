package buisness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutorImplTest {

    private SubstitutorImpl substitutor = new SubstitutorImpl();

    @Test
    void testSubstitute() {
        String input = "MERRY";
        String expected = "MARRY";
        String actual = substitutor.substitute(1, "A", input);
        assertEquals(expected, actual);
    }

    @Test
    void testSubstitute_longWord() {
        String input = "THISISVERYLONGWORDIDONOTEVENKNOWWHYIWROTETHATTHISWAY";
        String expected = "THISISVERYLONGWORDIDONOTEVENKNOWWHYUWROTETHATTHISWAY";
        String actual= substitutor.substitute(35, "U", input);
        assertEquals(expected, actual);
    }

}