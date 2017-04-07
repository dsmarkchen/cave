package test.cave;

import com.cave.Action;
import com.cave.WordTable;
import com.cave.word.WordType;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static test.cave.WordTableScenario.Builder;

@RunWith(JUnitParamsRunner.class)
public class ActionWordTableTest {
    @Test
    @Parameters(method = "getActionScenarios")
    @TestCaseName("{params}")
    public void actionLookup(WordTableScenario wordTableScenario) {
        WordTable wordTable = new WordTable();
        String word = wordTableScenario.word();
        int res = wordTable.lookup(word);

        // convert word index to actual meaning
        WordType type = wordTable.wordType(res);

        assertEquals(WordType.action_type, type);
        int meaning = wordTable.meaning(res);
        Action action = Action.values()[meaning];

        int expected = wordTableScenario.action().getIndex();


        assertEquals(expected, action.getIndex());
    }

    private WordTableScenario[] getActionScenarios() {
        WordTableScenario[] wordTableScenarios = new WordTableScenario[]{
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
                (new Builder("lock"))
                        .withGivenWord("lock")
                        .thenExpectedAction(Action.CLOSE)
                        .build(),

                (new Builder("on"))
                        .withGivenWord("on")
                        .thenExpectedAction(Action.ON)
                        .build(),
                (new Builder("off"))
                        .withGivenWord("off")
                        .thenExpectedAction(Action.OFF)
                        .build(),

                (new Builder("wave"))
                        .withGivenWord("wave")
                        .thenExpectedAction(Action.WAVE)
                        .build(),
                (new Builder("shake"))
                        .withGivenWord("shake")
                        .thenExpectedAction(Action.WAVE)
                        .build(),
                (new Builder("swing"))
                        .withGivenWord("swing")
                        .thenExpectedAction(Action.WAVE)
                        .build(),

                (new Builder("calm"))
                        .withGivenWord("calm")
                        .thenExpectedAction(Action.CALM)
                        .build(),
                (new Builder("placa??"))
                        .withGivenWord("placa")
                        .thenExpectedAction(Action.CALM)
                        .build(),
                (new Builder("tame"))
                        .withGivenWord("tame")
                        .thenExpectedAction(Action.CALM)
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
                (new Builder("proceed"))
                        .withGivenWord("proce")
                        .thenExpectedAction(Action.GO)
                        .build(),
                (new Builder("explore"))
                        .withGivenWord("explo")
                        .thenExpectedAction(Action.GO)
                        .build(),
                (new Builder("goto"))
                        .withGivenWord("goto")
                        .thenExpectedAction(Action.GO)
                        .build(),
                (new Builder("follow"))
                        .withGivenWord("follo")
                        .thenExpectedAction(Action.GO)
                        .build(),

                (new Builder("nothing"))
                        .withGivenWord("nothi")
                        .thenExpectedAction(Action.RELAX)
                        .build(),

                (new Builder("pour"))
                        .withGivenWord("pour")
                        .thenExpectedAction(Action.POUR)
                        .build(),

                (new Builder("quit"))
                        .withGivenWord("quit")
                        .thenExpectedAction(Action.QUIT)
                        .build(),
        };
        return wordTableScenarios;
    }

}
