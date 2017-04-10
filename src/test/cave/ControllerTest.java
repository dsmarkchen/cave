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
    @Parameters(method = "getLocationDescScenario")
    @TestCaseName("{params}")
    public void desc(Scenario scenario) {
        Location location = scenario.givenLocation();
        String expectedLongDesc = scenario.longDescription();
        String expectedShortDesc = scenario.shortDescription();
        assertEquals(expectedLongDesc, _controller.longDesc(location));
        assertEquals(expectedShortDesc, _controller.shortDesc(location));
    }

    private Scenario[] getLocationDescScenario() {
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

                new Scenario.Builder("slit")
                        .withLocation(Location.slit)
                        .expectDescription(WordConsts.LONG_SLIT, WordConsts.SHORT_SLIT)
                        .build(),

                new Scenario.Builder("outside")
                        .withLocation(Location.outside)
                        .expectDescription(WordConsts.LONG_OUTSIDE, WordConsts.SHORT_OUTSIDE)
                        .build(),

                new Scenario.Builder("inside")
                        .withLocation(Location.inside)
                        .expectDescription(WordConsts.LONG_INSIDE, WordConsts.SHORT_INSIDE)
                        .build(),


                new Scenario.Builder("cobbles")
                        .withLocation(Location.cobbles)
                        .expectDescription(WordConsts.LONG_COBBLES, WordConsts.SHORT_COBBLES)
                        .build(),

                new Scenario.Builder("debris")
                        .withLocation(Location.debris)
                        .expectDescription(WordConsts.LONG_DEBRIS, WordConsts.SHORT_DEBRIS)
                        .build(),


                new Scenario.Builder("awk")
                        .withLocation(Location.awk)
                        .expectDescription(WordConsts.LONG_AWKWARD, "")
                        .build(),

                new Scenario.Builder("bird chamber")
                        .withLocation(Location.bird)
                        .expectDescription(WordConsts.LONG_BIRD, WordConsts.SHORT_BIRD)
                        .build(),


                new Scenario.Builder("sewer")
                        .withLocation(Location.sewer)
                        .expectDescription(WordConsts.LONG_SEWER, "")
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
                        .build(),

                new Scenario.Builder("move from valley to south, get to slit")
                        .withMotion(Motion.S)
                        .withLocation(Location.valley)
                        .expectLocation(Location.slit)
                        .build(),

                new Scenario.Builder("move from slit to north, get to valley")
                        .withMotion(Motion.N)
                        .withLocation(Location.slit)
                        .expectLocation(Location.valley)
                        .build(),
                new Scenario.Builder("move from slit to house, get to road")
                        .withMotion(Motion.HOUSE)
                        .withLocation(Location.slit)
                        .expectLocation(Location.road)
                        .build(),
                new Scenario.Builder("move from slit to WOODS(E, W), get to forest")
                        .withMotion(Motion.WOODS)
                        .withLocation(Location.slit)
                        .expectLocation(Location.forest)
                        .build(),


                new Scenario.Builder("move from house to downstream, get to sewer")
                        .withMotion(Motion.DOWNSTREAM)
                        .withLocation(Location.house)
                        .expectLocation(Location.sewer)
                        .build(),

        };
        return scenarios;
    }

    @Test
    @Parameters(method = "getOutsideScenario")
    @TestCaseName("{params}")
    public void outside(Scenario scenario) {
        System.out.println(scenario.description());
        Motion motion = scenario.givenMotion();
        Location location = scenario.givenLocation();
        Location expected = scenario.expectedLocation();
        assertEquals(expected, _controller.move(motion, location));
    }

    @Test
    public void outsideEnterWithoutKeys() {
        Scenario scenario = new Scenario.Builder("move from outside to IN without Keys, stay outside")
                .withMotion(Motion.IN)
                .withLocation(Location.outside)
                .withCondition(false)
                .expectLocation(Location.outside)
                .build();

        System.out.println(scenario.description());
        Motion motion = scenario.givenMotion();
        Location location = scenario.givenLocation();
        Location expected = scenario.expectedLocation();
        assertEquals(expected, _controller.move(motion, location));
    }

    @Test
    public void outsideEnterWithKeys() {
        Scenario scenario = new Scenario.Builder("move from outside to IN without Keys, stay outside")
                .withMotion(Motion.IN)
                .withLocation(Location.outside)
                .withCondition(true)
                .expectLocation(Location.inside)
                .build();

        System.out.println(scenario.description());
        Motion motion = scenario.givenMotion();
        Location location = scenario.givenLocation();
        Location expected = scenario.expectedLocation();
        assertEquals(expected, _controller.move(motion, location));
    }

    private Scenario[] getOutsideScenario() {
        return new Scenario[]{
                new Scenario.Builder("upstream from outside, get to slit")
                        .withMotion(Motion.UPSTREAM)
                        .withLocation(Location.outside)
                        .expectLocation(Location.slit)
                        .build(),
                new Scenario.Builder("move from outside to north, get to slit")
                        .withMotion(Motion.N)
                        .withLocation(Location.outside)
                        .expectLocation(Location.slit)
                        .build(),
                new Scenario.Builder("move from outside to south, get to forest")
                        .withMotion(Motion.S)
                        .withLocation(Location.outside)
                        .expectLocation(Location.forest)
                        .build(),
                new Scenario.Builder("move from outside to IN with Keys, get to inside")
                        .withMotion(Motion.IN)
                        .withLocation(Location.outside)
                        .withCondition(true)
                        .expectLocation(Location.inside)
                        .build(),
                new Scenario.Builder("move from outside to IN without Keys, stay outside")
                        .withMotion(Motion.IN)
                        .withLocation(Location.outside)
                        .withCondition(false)
                        .expectLocation(Location.outside)
                        .build(),
        };
    }


    @Test
    @Parameters(method = "getInsideScenario")
    @TestCaseName("{params}")
    public void inside(Scenario scenario) {
        System.out.println(scenario.description());
        Motion motion = scenario.givenMotion();
        Location location = scenario.givenLocation();
        Location expected = scenario.expectedLocation();
        assertEquals(expected, _controller.move(motion, location));
    }

    private Scenario[] getInsideScenario() {
        return new Scenario[]{
                new Scenario.Builder("crawl from inside to west (cobbles), get to cobbles")
                        .withMotion(Motion.W)
                        .withLocation(Location.inside)
                        .expectLocation(Location.cobbles)
                        .build(),
                new Scenario.Builder("crawl from inside to cobbles, get to cobbles")
                        .withMotion(Motion.CRAWL)
                        .withLocation(Location.inside)
                        .expectLocation(Location.cobbles)
                        .build(),
                new Scenario.Builder("cobbles from inside, get to cobbles")
                        .withMotion(Motion.COBBLES)
                        .withLocation(Location.inside)
                        .expectLocation(Location.cobbles)
                        .build(),
                new Scenario.Builder("move in from inside, get to cobbles")
                        .withMotion(Motion.IN)
                        .withLocation(Location.inside)
                        .expectLocation(Location.cobbles)
                        .build(),
        };
    }

    @Test
    @Parameters(method = "getCobblesScenario")
    @TestCaseName("{params}")
    public void cobbles(Scenario scenario) {
        System.out.println(scenario.description());
        Motion motion = scenario.givenMotion();
        Location location = scenario.givenLocation();
        Location expected = scenario.expectedLocation();
        assertEquals(expected, _controller.move(motion, location));
    }
    private Scenario[] getCobblesScenario() {
        return new Scenario[]{
                new Scenario.Builder("move out from cobbles to inside of grate.")
                        .withMotion(Motion.OUT)
                        .withLocation(Location.cobbles)
                        .expectLocation(Location.inside)
                        .build(),
                new Scenario.Builder("move east from cobbles to inside of grate.")
                        .withMotion(Motion.E)
                        .withLocation(Location.cobbles)
                        .expectLocation(Location.inside)
                        .build(),
                new Scenario.Builder("pit from cobbles to spit.")
                        .withMotion(Motion.PIT)
                        .withLocation(Location.cobbles)
                        .expectLocation(Location.spit)
                        .build(),
                 new Scenario.Builder("move in from cobbles to debris.")
                        .withMotion(Motion.IN)
                        .withLocation(Location.cobbles)
                        .expectLocation(Location.debris)
                        .build(),
          };
    }

}