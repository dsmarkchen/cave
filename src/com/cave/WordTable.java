package com.cave;


import com.cave.hash.HashMap;
import com.cave.word.WordType;

import static com.cave.Motion.*;

public class WordTable {
    private HashMap _hashMap;

    public WordTable() {
        _hashMap = new HashMap();
        build();
    }

    private void build() {
        buildMotions();

        buildObjects();

        buildActions();
    }

    private void buildMotions() {
        WordType wordType = WordType.motion_type;
        _hashMap.put("north", wordType, Motion.N.getIndex());
        _hashMap.put("n", wordType, Motion.N.getIndex());
        _hashMap.put("south", wordType, Motion.S.getIndex());
        _hashMap.put("s", wordType, Motion.S.getIndex());
        _hashMap.put("east", wordType, Motion.E.getIndex());
        _hashMap.put("e", wordType, Motion.E.getIndex());
        _hashMap.put("west", wordType, Motion.W.getIndex());
        _hashMap.put("w", wordType, Motion.W.getIndex());

        _hashMap.put("ne", wordType, NE.getIndex());
        _hashMap.put("se", wordType, SE.getIndex());
        _hashMap.put("nw", wordType, NW.getIndex());
        _hashMap.put("sw", wordType, SW.getIndex());
     }

    private void buildObjects() {
        WordType wordType = WordType.object_type;
        _hashMap.put("key", wordType, Object.KEYS.getIndex());
        _hashMap.put("keys", wordType, Object.KEYS.getIndex());
        _hashMap.put("lamp", wordType, Object.LAMP.getIndex());
        _hashMap.put("lante", wordType, Object.LAMP.getIndex());
        _hashMap.put("head1", wordType, Object.LAMP.getIndex());

    }

    private void buildActions() {
        WordType wordType = WordType.action_type;
        _hashMap.put("take", wordType, Action.TAKE.ordinal());
        _hashMap.put("carry", wordType, Action.TAKE.ordinal());
        _hashMap.put("keep", wordType, Action.TAKE.ordinal());
    }

    public int lookup(String s)  {
        int result = _hashMap.get(s);
        return result;
    }
    public int meaning(int h) {
        return _hashMap.meaning(h);
    }
    public WordType wordType(int h) {
        return _hashMap.wordType(h);
    }
    public String text(int h) {
        return _hashMap.text(h);
    }
}
