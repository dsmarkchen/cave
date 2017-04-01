package test.cave.generic;

import com.cave.Location;
import com.cave.Motion;

public class Scenario {
    private String _description;
    private Motion _givenMotion;
    private Location _givenLocation;
    private Location _expectedLocation;

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

    @Override
    public String toString() {
        return _description;
    }

    public static class Builder {
        private String _description;
        private Motion _givenMotion;
        private Location _givenLocation;
        private Location _expectedLocation;

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
    }
}
