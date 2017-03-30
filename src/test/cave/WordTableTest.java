package test.cave;

import com.cave.Motion;
import com.cave.WordTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordTableTest {

    @Test(expected = NullPointerException.class)
    public void findTick_returnsNull() throws Exception {
        WordTable wordTable = new WordTable();
        wordTable.find("tickle");
    }

    @Test
    public void findSouth() throws Exception {
        WordTable wordTable = new WordTable();
        int result = wordTable.find("south");
        int result2 = wordTable.find("s");
        assertEquals(result, result2);

    }

    @Test
    public void findObject() throws Exception {
        WordTable wordTable = new WordTable();
        int result = wordTable.find("key");
        int result2 = wordTable.find("keys");
        assertEquals(result, result2);
    }

}