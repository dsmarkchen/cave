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
    public void motionLookup(Scenario scenario) {
        WordTable wordTable = new WordTable();
        String word = scenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);
        int meaning = wordTable.meaning(res);
        Motion motion = Motion.values()[meaning];

        int expected = scenario.found().getIndex();

        assertEquals(expected, motion.getIndex());
    }

    @Test
    @Parameters(method = "getObjectScenarios")
    @TestCaseName("{params}")
    public void objectLookup(Scenario scenario) {
        WordTable wordTable = new WordTable();
        String word = scenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);
        int meaning = wordTable.meaning(res);
        Object object = Object.values()[meaning];

        int expected = scenario.object().getIndex();

        assertEquals(expected, object.getIndex());
    }

    @Test
    @Parameters(method = "getActionScenarios")
    @TestCaseName("{params}")
    public void actionLookup(Scenario scenario) {
        WordTable wordTable = new WordTable();
        String word = scenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);
        int meaning = wordTable.meaning(res);
        Action action = Action.values()[meaning];

        int expected = scenario.action().getIndex();

        assertEquals(expected, action.getIndex());
    }

    @Test
    @Parameters(method = "getMessageScenarios")
    @TestCaseName("{params}")
    public void messageLookup(Scenario scenario) {
        WordTable wordTable = new WordTable();
        String word = scenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);
        int meaning = wordTable.meaning(res);

        String message = wordTable.message(meaning);
        String expected = scenario.message();

        assertEquals(expected, message);
    }

    private Scenario[] getMessageScenarios() {
        Scenario[] scenarios = new Scenario[]{
                (new Builder("help"))
                        .withGivenWord("help")
                        .thenExpectedMessage(WordConsts.HELP)
                        .build(),
                (new Builder("info"))
                        .withGivenWord("info")
                        .thenExpectedMessage(WordConsts.INFO)
                        .build(),
                (new Builder("swim"))
                        .withGivenWord("swim")
                        .thenExpectedMessage("I don't know how.")
                        .build(),
        };
        return scenarios;
    }

    private Scenario[] getActionScenarios() {
        Scenario[] scenarios = new Scenario[]{
                (new Builder("take"))
                        .withGivenWord("take")
                        .thenExpectedAction(Action.TAKE)
                        .build(),
                (new Builder("carry"))
                        .withGivenWord("carry")
                        .thenExpectedAction(Action.TAKE)
                        .build(),
                (new Builder("keep"))
                        .withGivenWord("keep")
                        .thenExpectedAction(Action.TAKE)
                        .build(),
                (new Builder("catch"))
                        .withGivenWord("catch")
                        .thenExpectedAction(Action.TAKE)
                        .build(),
                (new Builder("captu"))
                        .withGivenWord("captu")
                        .thenExpectedAction(Action.TAKE)
                        .build(),
                (new Builder("steal"))
                        .withGivenWord("steal")
                        .thenExpectedAction(Action.TAKE)
                        .build(),
                (new Builder("get"))
                        .withGivenWord("get")
                        .thenExpectedAction(Action.TAKE)
                        .build(),

                (new Builder("open"))
                        .withGivenWord("open")
                        .thenExpectedAction(Action.OPEN)
                        .build(),
                (new Builder("close"))
                        .withGivenWord("close")
                        .thenExpectedAction(Action.CLOSE)
                        .build(),

                (new Builder("walk"))
                        .withGivenWord("walk")
                        .thenExpectedAction(Action.GO)
                        .build(),
                (new Builder("run"))
                        .withGivenWord("run")
                        .thenExpectedAction(Action.GO)
                        .build(),
                (new Builder("trave"))
                        .withGivenWord("trave")
                        .thenExpectedAction(Action.GO)
                        .build(),
                (new Builder("go"))
                        .withGivenWord("go")
                        .thenExpectedAction(Action.GO)
                        .build(),
                (new Builder("quit"))
                        .withGivenWord("quit")
                        .thenExpectedAction(Action.QUIT)
                        .build(),
        };
        return scenarios;
    }

    private Scenario[] getObjectScenarios() {
        Scenario[] scenarios = new Scenario[]{
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
        };
        return scenarios;
    }

    private Scenario[] getMotionScenarios() {
        Scenario[] scenarios = new Scenario[]{
                (new Builder("north"))
                        .withGivenWord("north")
                        .thenExpectedFound(Motion.N)
                        .build(),
                (new Builder("n"))
                        .withGivenWord("n")
                        .thenExpectedFound(Motion.N)
                        .build(),
                (new Builder("south"))
                        .withGivenWord("south")
                        .thenExpectedFound(Motion.S)
                        .build(),
                (new Builder("s"))
                        .withGivenWord("s")
                        .thenExpectedFound(Motion.S)
                        .build(),
                (new Builder("downs "))
                        .withGivenWord("downs")
                        .thenExpectedFound(Motion.DOWNSTREAM)
                        .build(),
                (new Builder("enter "))
                        .withGivenWord("enter")
                        .thenExpectedFound(Motion.ENTER)
                        .build(),
                (new Builder("crawl "))
                        .withGivenWord("crawl")
                        .thenExpectedFound(Motion.CRAWL)
                        .build(),
                (new Builder("jump "))
                        .withGivenWord("jump")
                        .thenExpectedFound(Motion.JUMP)
                        .build(),
                (new Builder("climb "))
                        .withGivenWord("climb")
                        .thenExpectedFound(Motion.CLIMB)
                        .build(),
                (new Builder("look "))
                        .withGivenWord("look")
                        .thenExpectedFound(Motion.LOOK)
                        .build(),
                (new Builder("descr (same as look)"))
                        .withGivenWord("descr")
                        .thenExpectedFound(Motion.LOOK)
                        .build(),
                (new Builder("cross"))
                        .withGivenWord("cross")
                        .thenExpectedFound(Motion.CROSS)
                        .build(),
                (new Builder("road"))
                        .withGivenWord("road")
                        .thenExpectedFound(Motion.ROAD)
                        .build(),
                (new Builder("hill (road?)"))
                        .withGivenWord("hill")
                        .thenExpectedFound(Motion.ROAD)
                        .build(),

                (new Builder("build"))
                        .withGivenWord("build")
                        .thenExpectedFound(Motion.HOUSE)
                        .build(),
                (new Builder("house "))
                        .withGivenWord("house")
                        .thenExpectedFound(Motion.HOUSE)
                        .build(),

                (new Builder("cave"))
                        .withGivenWord("cave")
                        .thenExpectedFound(Motion.CAVE)
                        .build(),
                (new Builder("slab"))
                        .withGivenWord("slab")
                        .thenExpectedFound(Motion.SLAB)
                        .build(),
                (new Builder("awkwa"))
                        .withGivenWord("awkwa")
                        .thenExpectedFound(Motion.AWKWARD)
                        .build(),
                (new Builder("secre"))
                        .withGivenWord("secre")
                        .thenExpectedFound(Motion.SECRET)
                        .build(),
                (new Builder("xyzzy"))
                        .withGivenWord("xyzzy")
                        .thenExpectedFound(Motion.XYZZY)
                        .build(),
                (new Builder("plugh"))
                        .withGivenWord("plugh")
                        .thenExpectedFound(Motion.PLUGH)
                        .build(),
                (new Builder("main"))
                        .withGivenWord("main")
                        .thenExpectedFound(Motion.OFFICE)
                        .build(),
                (new Builder("null"))
                        .withGivenWord("nowhe")
                        .thenExpectedFound(Motion.NOWHERE)
                        .build(),
                (new Builder("nowhe"))
                        .withGivenWord("nowhe")
                        .thenExpectedFound(Motion.NOWHERE)
                        .build(),
         };
        return scenarios;
    }

    public class Builder {
        private String _description;
        private String _word;
        private Motion _motion;
        private Object _object;
        private Action _action;
        private String _message;

        public Builder(String desc) {
            _description = desc;
        }

        public Builder withGivenWord(String word) {
            _word = word;
            return this;
        }

        public Builder thenExpectedFound(Motion found) {
            _motion = found;
            return this;
        }

        public Builder thenExpectedObject(Object object) {
            _object = object;
            return this;
        }

        public Builder thenExpectedAction(Action action) {
            _action = action;
            return this;
        }

        public Builder thenExpectedMessage(String msg) {
            _message = msg;
            return this;
        }

        public Scenario build() {
            return new Scenario(this);
        }
    }

    public class Scenario {
        private String _description;
        private String _word;
        private Motion _found;
        private Object _object;
        private Action _action;
        private String _message;

        public String description() {
            return _description;
        }

        public String word() {
            return _word;
        }

        public Motion found() {
            return _found;
        }

        public Object object() {
            return _object;
        }

        public Action action() {
            return _action;
        }

        public String message() {
            return _message;
        }

        @Override
        public String toString() {
            return _description;
        }

        public Scenario(Builder builder) {
            _description = builder._description;
            _word = builder._word;
            _found = builder._motion;
            _object = builder._object;
            _action = builder._action;
            _message = builder._message;
        }

    }


}