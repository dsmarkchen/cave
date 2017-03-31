package test.cave;

import com.cave.Controller;
import com.cave.Location;
import com.cave.Motion;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ControllerTest {
    private Controller _controller;

    @Before
    public void setUp() throws Exception {
        _controller = new Controller();
    }

    @Test
    public void makeRoad() throws Exception {
        _controller.build();
        assertTrue(_controller.q > 15);
    }
}