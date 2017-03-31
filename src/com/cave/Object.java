package com.cave;

public enum Object {
    NOTHING(0), KEYS(1), LAMP(2), GRATE(3), GRATE_(4), CAGE(5), ROD(6), ROD2(7), TREADS(8), TREADS_(9),
    BIRD(10), DOOR(11), PILLOW(12), SNAKE(13), CRYSTAL(14), CRYSTAL_(15), TABLET(16);

    private int _index;

    private Object(int index) {
        _index = index;
    }

    public int getIndex() {
        return _index;
    }

};
