package test.cave;

import com.cave.Action;
import com.cave.Motion;
import com.cave.Object;

public class WordTableScenario {
    private String _description;
    private String _word;
    private Motion _found;
    private Object _object;
    private Action _action;
    private String _message;

    public static class Builder {
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

        public WordTableScenario build() {
            return new WordTableScenario(Builder.this);
        }
    }

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

    public WordTableScenario(Builder builder) {
        _description = builder._description;
        _word = builder._word;
        _found = builder._motion;
        _object = builder._object;
        _action = builder._action;
        _message = builder._message;
    }
}
