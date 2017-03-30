package test.cave;

import com.cave.Object;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectTest {
    @Test
    public void testObject() {
        assertEquals(17, Object.values().length);
    }

}