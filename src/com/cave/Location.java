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
    spit(14),

    emist(15), nugget(16), efiss(17), wfiss(18), wmist(19),
    like1(20), like2(21), like3(22), like4(23),
    like5(24), like6(25), like7(26), like8(27),
    like9(28), like10(29), like11(30), like12(31), like13(32), like14(33),

    brink(34), elong(35), wlong(36),

    diff0(37), diff1(38), diff2(39), diff3(40),
    diff4(41), diff5(42), diff6(43), diff7(44),
    diff8(45), diff9(46), diff10(47),

    pony(48), cross(49), hmk(50), west(51),
    south(52), ns(53), y2(54), jumble(55), windoe(56),

    crack(57),neck(58),lose(59),cant(60),climb(61),
    check(62),snaked(63),thru(64),duck(65),
    sewer(66),upnout(67),didit(68),

    ppass(69),pdrop(70),troll(71);

    private int _index;
    private Location(int index) {
        _index = index;
    }
    public int getIndex() {
        return _index;
    }

}
