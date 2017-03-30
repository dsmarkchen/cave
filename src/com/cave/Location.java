package com.cave;

public enum Location {
    ROAD("Road", "", 1, new Instruction()),
    HILL("You have walked up a hill still the forest.  The road slopes back\n" +
            "down the other side of the hill.  There is a building in the distance.",
            "You're at hill in road.", 2, new Instruction());

    Location(String longDescription, String shortDescription, Integer flag, Instruction instruction) {
        _longDescription = longDescription;
        _shortDesciption = shortDescription;
        _flag = flag;
        _instruction = instruction;
    }

    public String get_longDescription() {
        return _longDescription;
    }

    public String get_shortDesciption() {
        return _shortDesciption;
    }

    public Integer get_flag() {
        return _flag;
    }

    public Instruction get_instruction() {
        return _instruction;
    }

    private String _longDescription;
    private String _shortDesciption;
    private Integer _flag;
    private Instruction _instruction;
}
