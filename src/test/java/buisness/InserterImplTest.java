package buisness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InserterImplTest {

    private InserterImpl inserter = new InserterImpl();

    @Test
    void testInsert() {
        String input = "LONDON BRIDGE";
        String actual = inserter.insert(6," LONG", input);
        String expected = "LONDON LONG BRIDGE";
        assertEquals(expected, actual);

    }

}