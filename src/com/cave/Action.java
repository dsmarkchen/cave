package com.cave;

public enum Action {
    ABSTAIN(0), TAKE(1), DROP(2), OPEN(3), CLOSE(4), ON(5), OFF(6), WAVE(7), CALM(8), GO(9), RELAX(10),
    POUR(11), EAT(12), DRINK(13), RUB(14), TOSS(15), WAKE(16), FEED(17), FILL(18), BREAK(19), BLAST(20), KILL(21),
    SAY(22), READ(23), FEEFIE(24), BRIEF(25), FIND(26), INVENTORY(27), SCORE(28), QUIT(29);

    private int _index;

    private Action(int index) {
        _index = index;
    }

    public int getIndex() {
        return _index;
    }

}
