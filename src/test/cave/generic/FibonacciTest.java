package test.cave.generic;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FibonacciTest {
    private Scenario[] getScenario() {
        Scenario[] scenarios = new Scenario[]{
                new Scenario.Builder("F(0) => 0")
                        .withInput(0)
                        .thenExpected(0)
                        .build(),
                new Scenario.Builder("F(1) => 1")
                        .withInput(1)
                        .thenExpected(1)
                        .build(),
                new Scenario.Builder("F(2) => 1")
                        .withInput(2)
                        .thenExpected(1)
                        .build(),
                new Scenario.Builder("F(3) => 2")
                        .withInput(3)
                        .thenExpected(2)
                        .build(),
                new Scenario.Builder("F(4) => 3")
                        .withInput(4)
                        .thenExpected(3)
                        .build(),
                new Scenario.Builder("F(5) => 5")
                        .withInput(5)
                        .thenExpected(5)
                        .build(),
                new Scenario.Builder("F(6) => 8")
                        .withInput(6)
                        .thenExpected(8)
                        .build(),
                new Scenario.Builder("F(7) => 13")
                        .withInput(7)
                        .thenExpected(13)
                        .build(),
                new Scenario.Builder("F(8) => 21")
                        .withInput(8)
                        .thenExpected(21)
                        .build(),
                new Scenario.Builder("F(9) => 34")
                        .withInput(9)
                        .thenExpected(34)
                        .build(),
                new Scenario.Builder("F(10) => 55")
                        .withInput(10)
                        .thenExpected(55)
                        .build()
        };
        return scenarios;
    }

    @Test
    @Parameters(method = "getScenario")
    @TestCaseName("{params}")
    public void testWithScenario(Scenario scenario) {
        System.out.println(scenario.desc());
        int input = scenario.input();
        int expected = scenario.expected();
        assertEquals(expected, Fibonacci.compute(input));
    }

    static class Fibonacci {
        public static int compute(int n) {
            int result = 0;

            if (n <= 1) {
                result = n;
            } else {
                result = compute(n - 1) + compute(n - 2);
            }

            return result;
        }
    }

    static class Scenario {
        private final String _description;
        private final int _input;
        private final int _expected;

        private Scenario(Builder builder) {
            _description = builder._desc;
            _input = builder._input;
            _expected = builder._expected;
        }

        @Override
        public String toString() {
            return _description;
        }

        public String desc() {
            return _description;
        }

        public int input() {
            return _input;
        }

        public int expected() {
            return _expected;
        }

        public static class Builder {
            private final String _desc;
            private int _input;
            private int _expected;

            public Builder(String desc) {
                _desc = desc;
            }

            public Builder withInput(int input) {
                _input = input;
                return this;
            }

            public Builder thenExpected(int expected) {
                _expected = expected;
                return this;
            }

            public Scenario build() {
                return new Scenario(this);
            }
        }
    }
}
