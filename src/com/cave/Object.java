package com.cave;

public enum Object {
    NOTHING(0), KEYS(1), LAMP(2), GRATE(3), GRATE_(4), CAGE(5), ROD(6), ROD2(7), TREADS(8), TREADS_(9),
    BIRD(10), DOOR(11), PILLOW(12), SNAKE(13), CRYSTAL(14), CRYSTAL_(15), TABLET(16), CLAM(17), OYSTER(18),

    MAG(19), DWARF(20), KNIFE(21), FOOD(22), BOTTLE(23), WATER(24), OIL(25),

    MIRROR(26), MIRROR_(27), PLANT(28), PLANT2(29), PLANT2_(30),

    STALACTITE(31), SHADOW(32),SHADOW_(33),

    AXE(34), ART(35), PIRATE(36), DRAGON(37), DRAGON_(38),
    BRIDGE(39), BRIDGE_(40), TROLL(41), TROLL_(42), TROLL2(43), TROLL2_(44),
    BEAR(45), MESSAGE(46);

    private int _index;

    private Object(int index) {
        _index = index;
    }

    public int getIndex() {
        return _index;
    }

    public boolean compare(int i){return _index == i;}

    public static Object getValue(int _id)
    {
        Object[] values = Object.values();
        for(int i = 0; i < values.length; i++)
        {
            if(values[i].compare(_id))
                return values[i];
        }
        return Object.NOTHING;
    }
};
