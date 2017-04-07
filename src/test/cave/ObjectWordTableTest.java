package test.cave;

import com.cave.Object;
import com.cave.WordTable;
import com.cave.word.WordType;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static test.cave.WordTableScenario.Builder;

@RunWith(JUnitParamsRunner.class)
public class ObjectWordTableTest {
    @Test
    @Parameters(method = "getObjectScenarios")
    @TestCaseName("{params}")
    public void objectLookup(WordTableScenario wordTableScenario) {
        WordTable wordTable = new WordTable();
        String word = wordTableScenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);
        assertEquals(WordType.object_type,  type);
        int meaning = wordTable.meaning(res);
        Object object = Object.values()[meaning];

        int expected;
        expected = wordTableScenario.object().getIndex();

        assertEquals(expected, object.getIndex());
    }

    @Test
    public void countObjectScenario() {
        WordTableScenario[] wordTableScenarios = getObjectScenarios();
        assertTrue(wordTableScenarios.length > 40);
    }


    private WordTableScenario[] getObjectScenarios() {
        return new WordTableScenario[]{
                (new Builder("key"))
                        .withGivenWord("key")
                        .thenExpectedObject(Object.KEYS)
                        .build(),
                (new Builder("keys"))
                        .withGivenWord("keys")
                        .thenExpectedObject(Object.KEYS)
                        .build(),
                (new Builder("lamp"))
                        .withGivenWord("lamp")
                        .thenExpectedObject(Object.LAMP)
                        .build(),
                (new Builder("headlight? lamp"))
                        .withGivenWord("headl")
                        .thenExpectedObject(Object.LAMP)
                        .build(),
                (new Builder("grate"))
                        .withGivenWord("grate")
                        .thenExpectedObject(Object.GRATE)
                        .build(),
                (new Builder("cage"))
                        .withGivenWord("cage")
                        .thenExpectedObject(Object.CAGE)
                        .build(),
                (new Builder("rod"))
                        .withGivenWord("rod")
                        .thenExpectedObject(Object.ROD)
                        .build(),
                (new Builder("bird"))
                        .withGivenWord("bird")
                        .thenExpectedObject(Object.BIRD)
                        .build(),

                (new Builder("door"))
                        .withGivenWord("door")
                        .thenExpectedObject(Object.DOOR)
                        .build(),
                (new Builder("pillow"))
                        .withGivenWord("pillo")
                        .thenExpectedObject(Object.PILLOW)
                        .build(),
                (new Builder("snake"))
                        .withGivenWord("snake")
                        .thenExpectedObject(Object.SNAKE)
                        .build(),
                (new Builder("crystal"))
                        .withGivenWord("fissu")
                        .thenExpectedObject(Object.CRYSTAL)
                        .build(),
                (new Builder("table"))
                        .withGivenWord("table")
                        .thenExpectedObject(Object.TABLET)
                        .build(),
                (new Builder("clam"))
                        .withGivenWord("clam")
                        .thenExpectedObject(Object.CLAM)
                        .build(),
                (new Builder("oyster"))
                        .withGivenWord("oyste")
                        .thenExpectedObject(Object.OYSTER)
                        .build(),

                (new Builder("mag"))
                        .withGivenWord("magaz")
                        .thenExpectedObject(Object.MAG)
                        .build(),
                (new Builder("issue mag"))
                        .withGivenWord("issue")
                        .thenExpectedObject(Object.MAG)
                        .build(),
                (new Builder("splu mag"))
                        .withGivenWord("splu")
                        .thenExpectedObject(Object.MAG)
                        .build(),
                (new Builder("\"spel mag"))
                        .withGivenWord("\"spel")
                        .thenExpectedObject(Object.MAG)
                        .build(),

                (new Builder("dwarf"))
                        .withGivenWord("dwarf")
                        .thenExpectedObject(Object.DWARF)
                        .build(),
                (new Builder("dwarv"))
                        .withGivenWord("dwarv")
                        .thenExpectedObject(Object.DWARF)
                        .build(),

                (new Builder("knife"))
                        .withGivenWord("knife")
                        .thenExpectedObject(Object.KNIFE)
                        .build(),
                (new Builder("knive"))
                        .withGivenWord("knive")
                        .thenExpectedObject(Object.KNIFE)
                        .build(),

                (new Builder("food"))
                        .withGivenWord("food")
                        .thenExpectedObject(Object.FOOD)
                        .build(),
                (new Builder("ratio"))
                        .withGivenWord("ratio")
                        .thenExpectedObject(Object.FOOD)
                        .build(),
                (new Builder("bottle"))
                        .withGivenWord("bottl")
                        .thenExpectedObject(Object.BOTTLE)
                        .build(),
                (new Builder("jar"))
                        .withGivenWord("jar")
                        .thenExpectedObject(Object.BOTTLE)
                        .build(),
                (new Builder("water"))
                        .withGivenWord("water")
                        .thenExpectedObject(Object.WATER)
                        .build(),
                (new Builder("h2o water"))
                        .withGivenWord("h2o")
                        .thenExpectedObject(Object.WATER)
                        .build(),

                (new Builder("oil"))
                        .withGivenWord("oil")
                        .thenExpectedObject(Object.OIL)
                        .build(),
                (new Builder("mirror"))
                        .withGivenWord("mirro")
                        .thenExpectedObject(Object.MIRROR)
                        .build(),
                (new Builder("plant"))
                        .withGivenWord("plant")
                        .thenExpectedObject(Object.PLANT)
                        .build(),
                (new Builder("beans"))
                        .withGivenWord("beans")
                        .thenExpectedObject(Object.PLANT)
                        .build(),
                (new Builder("stala"))
                        .withGivenWord("stala")
                        .thenExpectedObject(Object.STALACTITE)
                        .build(),
                (new Builder("axe"))
                        .withGivenWord("axe")
                        .thenExpectedObject(Object.AXE)
                        .build(),

                (new Builder("art"))
                        .withGivenWord("drawi")
                        .thenExpectedObject(Object.ART)
                        .build(),
                (new Builder("pirate"))
                        .withGivenWord("pirat")
                        .thenExpectedObject(Object.PIRATE)
                        .build(),
                (new Builder("dragon"))
                        .withGivenWord("drago")
                        .thenExpectedObject(Object.DRAGON)
                        .build(),
                (new Builder("chasm"))
                        .withGivenWord("chasm")
                        .thenExpectedObject(Object.BRIDGE)
                        .build(),


                (new Builder("troll"))
                        .withGivenWord("troll")
                        .thenExpectedObject(Object.TROLL)
                        .build(),
                (new Builder("bear"))
                        .withGivenWord("bear")
                        .thenExpectedObject(Object.BEAR)
                        .build(),
        };
    }
}