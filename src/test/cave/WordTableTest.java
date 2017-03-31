package test.cave;

import com.cave.Motion;
import com.cave.WordTable;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
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
        assertTrue(result >0);
    }

    @Test
    public void findObject() throws Exception {
        WordTable wordTable = new WordTable();
        int result = wordTable.find("key");
        assertTrue(result>0);
    }


    @Test
    public void findAction() throws Exception {
        WordTable wordTable = new WordTable();
        int take = wordTable.find("take");
        assertTrue(take >0);
        int carry = wordTable.find("carry");
        assertTrue(carry>0);
    }

}