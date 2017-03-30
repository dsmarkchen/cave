package test.cave;

import com.cave.Motion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MotionTest {

    @Test
    public void motion_checkNumberOfElements() {
        assertEquals(75, Motion.values().length);
    }
}