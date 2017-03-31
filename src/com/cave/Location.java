package com.cave;

public enum Location {
    inhand(-1),
    limbo(0),

    road(1),
    hill(2),
    house(3),
    valley(4),
    forest(5),
    woods(6),
    slit(7),
    outside(8),

    inside(9),
    cobbles(10),
    debris(11),
    awk(12),
    bird(13),
    spit(14);

//    emist, nugget, efiss, wfiss, wmist,
//    like1, like2, like3, like4, like5, like6, like7, like8, like9, like10, like11, like12, like13, like14,
//    brink, elong, wlong,
//    diff0, diff1, diff2, diff3, diff4, diff5, diff6, diff7, diff8, diff9, diff10,
//    pony, cross, hmk, west, south, ns, y2, jumble, windoe,

//    crack,neck,lose,cant,climb,check,snaked,thru,duck,sewer,upnout,didit,
//    ppass,pdrop,troll;
    private int _index;
    private Location(int index) {
        _index = index;
    }
    public int getIndex() {
        return _index;
    }

}
