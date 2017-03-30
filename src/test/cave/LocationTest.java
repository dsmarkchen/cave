package test.cave;

import com.cave.Location;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class LocationTest {

    @Test
    public void hill() {
        assertTrue(Location.HILL.get_longDescription() != "");
        assertTrue(Location.HILL.get_shortDesciption() != "");
    }
}