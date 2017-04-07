package test.cave;

import com.cave.Action;
import com.cave.Motion;
import com.cave.Object;
import com.cave.WordTable;
import com.cave.word.WordConsts;
import com.cave.word.WordType;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.cave.WordTableScenario;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class WordTableTest {
    @Test
    public void findTick_returnsNull() throws Exception {
        WordTable wordTable = new WordTable();
        assertTrue(wordTable.lookup("tickle") < 0);
    }

    @Test
    @Parameters(method = "getMotionScenarios")
    @TestCaseName("{params}")
    public void motionLookup(WordTableScenario wordTableScenario) {
        WordTable wordTable = new WordTable();
        String word = wordTableScenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);
        int meaning = wordTable.meaning(res);
        Motion motion = Motion.values()[meaning];

        int expected = wordTableScenario.found().getIndex();

        assertEquals(expected, motion.getIndex());
    }



    @Test
    @Parameters(method = "getMessageScenarios")
    @TestCaseName("{params}")
    public void messageLookup(WordTableScenario wordTableScenario) {
        WordTable wordTable = new WordTable();
        String word = wordTableScenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);
        int meaning = wordTable.meaning(res);

        String message = wordTable.message(meaning);
        String expected = wordTableScenario.message();

        assertEquals(expected, message);
    }

    private WordTableScenario[] getMessageScenarios() {
        WordTableScenario[] wordTableScenarios = new WordTableScenario[]{
                new WordTableScenario.Builder("help")
                        .withGivenWord("help")
                        .thenExpectedMessage(WordConsts.HELP)
                        .build(),
                new WordTableScenario.Builder("info")
                        .withGivenWord("info")
                        .thenExpectedMessage(WordConsts.INFO)
                        .build(),
                new WordTableScenario.Builder("trees")
                        .withGivenWord("trees")
                        .thenExpectedMessage(WordConsts.TREES)
                        .build(),
                new WordTableScenario.Builder("swim")
                        .withGivenWord("swim")
                        .thenExpectedMessage("I don't know how.")
                        .build(),
        };
        return wordTableScenarios;
    }


    private WordTableScenario[] getObjectScenarios() {
        return new WordTableScenario[]{
                (new WordTableScenario.Builder("key"))
                        .withGivenWord("key")
                        .thenExpectedObject(Object.KEYS)
                        .build(),
                (new WordTableScenario.Builder("keys"))
                        .withGivenWord("keys")
                        .thenExpectedObject(Object.KEYS)
                        .build(),
                (new WordTableScenario.Builder("lamp"))
                        .withGivenWord("lamp")
                        .thenExpectedObject(Object.LAMP)
                        .build(),
                (new WordTableScenario.Builder("grate"))
                        .withGivenWord("grate")
                        .thenExpectedObject(Object.GRATE)
                        .build(),
                (new WordTableScenario.Builder("cage"))
                        .withGivenWord("cage")
                        .thenExpectedObject(Object.CAGE)
                        .build(),
                (new WordTableScenario.Builder("rod"))
                        .withGivenWord("rod")
                        .thenExpectedObject(Object.ROD)
                        .build(),
                (new WordTableScenario.Builder("bird"))
                        .withGivenWord("bird")
                        .thenExpectedObject(Object.BIRD)
                        .build(),

                (new WordTableScenario.Builder("door"))
                        .withGivenWord("door")
                        .thenExpectedObject(Object.DOOR)
                        .build(),
                (new WordTableScenario.Builder("pillow"))
                        .withGivenWord("pillo")
                        .thenExpectedObject(Object.PILLOW)
                        .build(),
                (new WordTableScenario.Builder("snake"))
                        .withGivenWord("snake")
                        .thenExpectedObject(Object.SNAKE)
                        .build(),
                (new WordTableScenario.Builder("crystal"))
                        .withGivenWord("fissu")
                        .thenExpectedObject(Object.CRYSTAL)
                        .build(),
                (new WordTableScenario.Builder("table"))
                        .withGivenWord("table")
                        .thenExpectedObject(Object.TABLET)
                        .build(),
                (new WordTableScenario.Builder("clam"))
                        .withGivenWord("clam")
                        .thenExpectedObject(Object.CLAM)
                        .build(),
                (new WordTableScenario.Builder("oyster"))
                        .withGivenWord("oyste")
                        .thenExpectedObject(Object.OYSTER)
                        .build(),

                (new WordTableScenario.Builder("mag"))
                        .withGivenWord("magaz")
                        .thenExpectedObject(Object.MAG)
                        .build(),
                (new WordTableScenario.Builder("dwarf"))
                        .withGivenWord("dwarf")
                        .thenExpectedObject(Object.DWARF)
                        .build(),
                (new WordTableScenario.Builder("knife"))
                        .withGivenWord("knife")
                        .thenExpectedObject(Object.KNIFE)
                        .build(),

                (new WordTableScenario.Builder("food"))
                        .withGivenWord("food")
                        .thenExpectedObject(Object.FOOD)
                        .build(),
                (new WordTableScenario.Builder("bottle"))
                        .withGivenWord("bottl")
                        .thenExpectedObject(Object.BOTTLE)
                        .build(),
                (new WordTableScenario.Builder("water"))
                        .withGivenWord("water")
                        .thenExpectedObject(Object.WATER)
                        .build(),

                (new WordTableScenario.Builder("oil"))
                        .withGivenWord("oil")
                        .thenExpectedObject(Object.OIL)
                        .build(),
                (new WordTableScenario.Builder("mirror"))
                        .withGivenWord("mirro")
                        .thenExpectedObject(Object.MIRROR)
                        .build(),
                (new WordTableScenario.Builder("plant"))
                        .withGivenWord("plant")
                        .thenExpectedObject(Object.PLANT)
                        .build(),
                (new WordTableScenario.Builder("troll"))
                        .withGivenWord("troll")
                        .thenExpectedObject(Object.TROLL)
                        .build(),
                (new WordTableScenario.Builder("bear"))
                        .withGivenWord("bear")
                        .thenExpectedObject(Object.BEAR)
                        .build(),
        };
    }

    private WordTableScenario[] getMotionScenarios() {
        WordTableScenario[] wordTableScenarios = new WordTableScenario[]{
                (new WordTableScenario.Builder("north"))
                        .withGivenWord("north")
                        .thenExpectedFound(Motion.N)
                        .build(),
                (new WordTableScenario.Builder("n"))
                        .withGivenWord("n")
                        .thenExpectedFound(Motion.N)
                        .build(),
                (new WordTableScenario.Builder("south"))
                        .withGivenWord("south")
                        .thenExpectedFound(Motion.S)
                        .build(),
                (new WordTableScenario.Builder("s"))
                        .withGivenWord("s")
                        .thenExpectedFound(Motion.S)
                        .build(),
                (new WordTableScenario.Builder("downs "))
                        .withGivenWord("downs")
                        .thenExpectedFound(Motion.DOWNSTREAM)
                        .build(),
                (new WordTableScenario.Builder("enter "))
                        .withGivenWord("enter")
                        .thenExpectedFound(Motion.ENTER)
                        .build(),
                (new WordTableScenario.Builder("crawl "))
                        .withGivenWord("crawl")
                        .thenExpectedFound(Motion.CRAWL)
                        .build(),
                (new WordTableScenario.Builder("jump "))
                        .withGivenWord("jump")
                        .thenExpectedFound(Motion.JUMP)
                        .build(),
                (new WordTableScenario.Builder("climb "))
                        .withGivenWord("climb")
                        .thenExpectedFound(Motion.CLIMB)
                        .build(),
                (new WordTableScenario.Builder("look "))
                        .withGivenWord("look")
                        .thenExpectedFound(Motion.LOOK)
                        .build(),
                (new WordTableScenario.Builder("descr (same as look)"))
                        .withGivenWord("descr")
                        .thenExpectedFound(Motion.LOOK)
                        .build(),
                (new WordTableScenario.Builder("cross"))
                        .withGivenWord("cross")
                        .thenExpectedFound(Motion.CROSS)
                        .build(),
                (new WordTableScenario.Builder("road"))
                        .withGivenWord("road")
                        .thenExpectedFound(Motion.ROAD)
                        .build(),
                (new WordTableScenario.Builder("hill (road?)"))
                        .withGivenWord("hill")
                        .thenExpectedFound(Motion.ROAD)
                        .build(),

                (new WordTableScenario.Builder("build"))
                        .withGivenWord("build")
                        .thenExpectedFound(Motion.HOUSE)
                        .build(),
                (new WordTableScenario.Builder("house "))
                        .withGivenWord("house")
                        .thenExpectedFound(Motion.HOUSE)
                        .build(),


                (new WordTableScenario.Builder("cobbles"))
                        .withGivenWord("cobbl")
                        .thenExpectedFound(Motion.COBBLES)
                        .build(),


                (new WordTableScenario.Builder("cave"))
                        .withGivenWord("cave")
                        .thenExpectedFound(Motion.CAVE)
                        .build(),
                (new WordTableScenario.Builder("slab"))
                        .withGivenWord("slab")
                        .thenExpectedFound(Motion.SLAB)
                        .build(),
                (new WordTableScenario.Builder("awkwa"))
                        .withGivenWord("awkwa")
                        .thenExpectedFound(Motion.AWKWARD)
                        .build(),
                (new WordTableScenario.Builder("secre"))
                        .withGivenWord("secre")
                        .thenExpectedFound(Motion.SECRET)
                        .build(),
                (new WordTableScenario.Builder("xyzzy"))
                        .withGivenWord("xyzzy")
                        .thenExpectedFound(Motion.XYZZY)
                        .build(),
                (new WordTableScenario.Builder("plugh"))
                        .withGivenWord("plugh")
                        .thenExpectedFound(Motion.PLUGH)
                        .build(),
                (new WordTableScenario.Builder("main"))
                        .withGivenWord("main")
                        .thenExpectedFound(Motion.OFFICE)
                        .build(),
                (new WordTableScenario.Builder("null"))
                        .withGivenWord("nowhe")
                        .thenExpectedFound(Motion.NOWHERE)
                        .build(),
                (new WordTableScenario.Builder("nowhe"))
                        .withGivenWord("nowhe")
                        .thenExpectedFound(Motion.NOWHERE)
                        .build(),
        };
        return wordTableScenarios;
    }




}