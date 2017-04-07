package test.cave.generic;

import com.cave.Location;
import com.cave.Motion;

public class Scenario {
    private String _description;
    private Motion _givenMotion;
    private Location _givenLocation;
    private Location _expectedLocation;
    private String _shortDescription;
    private String _longDescription;
    private boolean _conditionIsTrue;

    public String description() {
        return _description;
    }

    public Motion givenMotion() {
        return _givenMotion;
    }

    public Location givenLocation() {
        return _givenLocation;
    }

    public Location expectedLocation() {
        return _expectedLocation;
    }

    public String longDescription() {
        return _longDescription;
    }
    public String shortDescription() {
        return _shortDescription;
    }

    @Override
    public String toString() {
        return _description;
    }

    public static class Builder {
        private String _description;
        private boolean _conditionIsTrue;
        private Motion _givenMotion;
        private Location _givenLocation;
        private Location _expectedLocation;

        private String _shortDescription;
        private String _longDescription;

        public Builder(String desc) {
            _description = desc;
        }

        public Builder withMotion(Motion motion) {
            _givenMotion = motion;
            return this;
        }

        public Builder withLocation(Location location) {
            _givenLocation = location;
            return this;
        }
        public Builder withCondition(boolean conditionIsTrue){
            _conditionIsTrue = conditionIsTrue;
            return this;
        }

        public Builder expectDescription(String longDesc, String shortDesc) {
            _longDescription = longDesc;
            _shortDescription = shortDesc;
            return this;
        }

        public Builder expectLocation(Location location) {
            _expectedLocation = location;
            return this;
        }

        public Scenario build() {
            return new Scenario(this);
        }
    }

    private Scenario(Builder builder) {
        _description = builder._description;

        _givenMotion = builder._givenMotion;
        _givenLocation = builder._givenLocation;
        _expectedLocation = builder._expectedLocation;
        _longDescription = builder._longDescription;
        _shortDescription = builder._shortDescription;
        _conditionIsTrue = builder._conditionIsTrue;
    }
}
