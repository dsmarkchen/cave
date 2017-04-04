package test.cave;

import com.cave.Controller;
import com.cave.Location;
import com.cave.Motion;
import com.cave.word.WordConsts;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.cave.generic.Scenario;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ControllerTest {
    private Controller _controller;

    @Before
    public void setUp() throws Exception {
        _controller = new Controller();
        _controller.build();
    }


    @Test
    public void roadLongDescAndShortDesc() throws Exception {
        //System.out.println(_controller.toString());
        String longDesc = _controller.longDesc(Location.road);
        assertEquals(WordConsts.LONG_ROAD, longDesc);

        String shortDesc = _controller.shortDesc(Location.road);
        assertEquals(WordConsts.SHORT_ROAD, shortDesc);
    }

    @Test
    public void hillLongDescAndShortDesc() throws Exception {
        //System.out.println(_controller.toString());
        String longDesc = _controller.longDesc(Location.hill);
        assertEquals(WordConsts.LONG_HILL, longDesc);

        String shortDesc = _controller.shortDesc(Location.hill);
        assertEquals(WordConsts.SHORT_HILL, shortDesc);
    }


    @Test
    @Parameters(method = "getDescScenario")
    @TestCaseName("{params}")
    public void desc(Scenario scenario) {
        Location location = scenario.givenLocation();
        String expectedLongDesc = scenario.longDescription();
        String expectedShortDesc = scenario.shortDescription();
        assertEquals(expectedLongDesc, _controller.longDesc(location));
        assertEquals(expectedShortDesc, _controller.shortDesc(location));
    }

    private Scenario[] getDescScenario() {
        Scenario[] scenarios = new Scenario[]{
                new Scenario.Builder("road")
                        .withLocation(Location.road)
                        .expectDescription(WordConsts.LONG_ROAD, WordConsts.SHORT_ROAD)
                        .build(),
                new Scenario.Builder("hill")
                        .withLocation(Location.hill)
                        .expectDescription(WordConsts.LONG_HILL, WordConsts.SHORT_HILL)
                        .build(),
                new Scenario.Builder("house")
                        .withLocation(Location.house)
                        .expectDescription(WordConsts.LONG_HOUSE, WordConsts.SHORT_HOUSE)
                        .build(),
                new Scenario.Builder("valley")
                        .withLocation(Location.valley)
                        .expectDescription(WordConsts.LONG_VALLEY, WordConsts.SHORT_VALLEY)
                        .build(),
                new Scenario.Builder("forest")
                        .withLocation(Location.forest)
                        .expectDescription(WordConsts.LONG_FOREST, WordConsts.SHORT_FOREST)
                        .build(),
                new Scenario.Builder("woods")
                        .withLocation(Location.woods)
                        .expectDescription(WordConsts.LONG_WOODS, WordConsts.SHORT_FOREST)
                        .build(),
           };
        return scenarios;
    }

    @Test
    @Parameters(method = "getMoveScenario")
    @TestCaseName("{params}")
    public void move(Scenario scenario) {
        System.out.println(scenario.description());
        Motion motion = scenario.givenMotion();
        Location location = scenario.givenLocation();
        Location expected = scenario.expectedLocation();
        assertEquals(expected, _controller.move(motion, location));
    }


    private Scenario[] getMoveScenario() {
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