package com.cave;

public class Instruction {
    private final Motion _motion;

    public Motion motion() {
        return _motion;
    }

    public int condition() {
        return _condition;
    }

    public Location dest() {
        return _dest;
    }

    private final int _condition;
    private final Location _dest;

    public Instruction(Motion motion, int cond, Location location) {
        _motion = motion;
        _condition = cond;
        _dest = location;
    }

}
