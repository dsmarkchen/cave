package test.cave;

import com.cave.Controller;
import com.cave.Location;
import com.cave.Motion;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.cave.generic.Scenario;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnitParamsRunner.class)
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
    @Parameters(method = "getScenario")
    @TestCaseName("{params}")
    public void move(Scenario scenario) {
        System.out.println(scenario.description());
        Motion motion = scenario.givenMotion();
        Location location = scenario.givenLocation();
        Location expected = scenario.expectedLocation();
        assertEquals(expected, _controller.move(motion, location));
    }


    private Scenario[] getScenario() {
        Scenario[] scenarios = new Scenario[]{
                new Scenario.Builder("move from road to north, get to forest")
                        .withMotion(Motion.N)
                        .withLocation(Location.road)
                        .expectLocation(Location.forest)
                        .build(),
                new Scenario.Builder("move from road to west, get to hill")
                        .withMotion(Motion.W)
                        .withLocation(Location.road)
                        .expectLocation(Location.hill)
                        .build(),
                new Scenario.Builder("move from road to east, get to house")
                        .withMotion(Motion.E)
                        .withLocation(Location.road)
                        .expectLocation(Location.house)
                        .build(),
                new Scenario.Builder("move from road to south, get to valley")
                        .withMotion(Motion.S)
                        .withLocation(Location.road)
                        .expectLocation(Location.valley)
                        .build(),

                new Scenario.Builder("move from hill to east, get to road")
                        .withMotion(Motion.E)
                        .withLocation(Location.hill)
                        .expectLocation(Location.road)
                        .build(),
                new Scenario.Builder("move from house to west, get to road")
                        .withMotion(Motion.W)
                        .withLocation(Location.house)
                        .expectLocation(Location.road)
                        .build(),
                new Scenario.Builder("move from valley to north, get to road")
                        .withMotion(Motion.N)
                        .withLocation(Location.valley)
                        .expectLocation(Location.road)
                        .build(),
                new Scenario.Builder("move from forest to south, get to road")
                        .withMotion(Motion.S)
                        .withLocation(Location.forest)
                        .expectLocation(Location.road)
                        .build()
        };
        return scenarios;
    }



}