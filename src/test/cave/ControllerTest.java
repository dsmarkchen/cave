package test.cave;

import com.cave.Controller;
import com.cave.Location;
import com.cave.Motion;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ControllerTest {
    private Controller _controller;

    @Before
    public void setUp() throws Exception {
        _controller = new Controller();
        _controller.build();
    }

    @Test
    public void makeRoad() throws Exception {
        System.out.println(_controller.toString());
        String longDesc = _controller.longDesc(Location.road);
        assertTrue(longDesc.length() > 0);
        String shortDesc = _controller.shortDesc(Location.road);
        assertTrue(shortDesc.length() > 0);
    }

    @Test
    public void walkFromRoadToWest_returnsHill() throws Exception {
        Location newLocation = _controller.move(Motion.W, Location.road);
        assertEquals(Location.hill, newLocation);

    }

    @Test
    public void walkFromHillToEast_returnsRoad() throws Exception {
        Location newLocation = _controller.move(Motion.E, Location.hill);
        assertEquals(Location.road, newLocation);
    }

   @Test
    public void walkFromRoadToSouth_returnsValley() throws Exception {
        Location newLocation = _controller.move(Motion.S, Location.road);
        assertEquals(Location.valley, newLocation);
    }

    @Test
    public void walkFromForestToSouth_returnsRoad() throws Exception {

        Location newLocation = _controller.move(Motion.S, Location.forest);
        assertEquals(Location.road, newLocation);
    }
 }