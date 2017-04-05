package com.cave;

public enum Motion {
    FORCE(0), // ?

    N(1),
    S(2),
    E(3),
    W(4),
    NE(5),
    SE(6),
    NW(7),
    SW(8),
    U(9),
    D(10),
    L(11),
    R(12),

    IN(13),
    OUT(14),
    FORWARD(15),
    BACK(16),

    OVER(17),
    ACROSS(18),
    UPSTREAM(19),
    DOWNSTREAM(20),

    ENTER(21),
    CRAWL(22),
    JUMP(23),
    CLIMB(24),
    LOOK(25),
    CROSS(26),

    ROAD(27),
    WOODS(28),
    VALLEY(29),
    HOUSE(30),
    GULLY(31),
    STREAM(32),
    DEPRESSION(33),
    ENTRANCE(34),
    CAVE(35),

    ROCK(36),
    SLAB(37),
    BED(38),
    PASSAGE(39),
    CAVERN(40),
    CANYON(41),
    AWKWARD(42),
    SECRET(43),
    BEDQUILT(44),
    RESERVOIR(45),

    GIANT(46),
    ORIENTAL(47),
    SHELL(48),
    BARREN(49),
    BROKEN(50),
    DEBRIS(51),
    VIEW(52),
    FORK(53),

    PIT(54),
    SLIT(55),
    CRACK(56),
    DOME(57),
    HOLE(58),
    WALL(59),
    HALL(60),
    ROOM(61),
    FLOOR(62),

    STAIRS(63),
    STEPS(64),
    COBBLES(65),
    SURFACE(66),
    DARK(67),
    LOW(68),
    OUTDOORS(69),

    Y2(70),
    XYZZY(71),
    PLUGH(72),
    PLOVER(73),
    OFFICE(74),
    NOWHERE(75);

    private int _index;
    private Motion(int index) {
        _index = index;
    }
    public int getIndex() {
        return _index;
    }
}
