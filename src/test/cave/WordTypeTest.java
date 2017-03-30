package test.cave;

import com.cave.word.WordType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordTypeTest {
    @Test
    public void testWordTypeCounts() {
        assertEquals(5, WordType.values().length);
    }

}