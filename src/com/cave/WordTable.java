package com.cave;


import com.cave.hash.HashMap;
import com.cave.word.WordType;

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
        _hashMap.put("north", wordType, Motion.N.hashCode());
        _hashMap.put("n", wordType, Motion.N.hashCode());
        _hashMap.put("south", wordType, Motion.S.hashCode());
        _hashMap.put("s", wordType, Motion.S.hashCode());
    }

    private void buildObjects() {
        WordType wordType = WordType.object_type;
        _hashMap.put("key", wordType, Object.KEYS.hashCode());
        _hashMap.put("keys", wordType, Object.KEYS.hashCode());
        _hashMap.put("lamp", wordType, Object.LAMP.hashCode());
        _hashMap.put("lante", wordType, Object.LAMP.hashCode());
        _hashMap.put("head1", wordType, Object.LAMP.hashCode());

    }

    private void buildActions() {
        WordType wordType = WordType.action_type;
        _hashMap.put("take", wordType, Action.TAKE.ordinal());
        _hashMap.put("carry", wordType, Action.TAKE.ordinal());
        _hashMap.put("keep", wordType, Action.TAKE.ordinal());

    }

    public int find(String s) {
        int result = _hashMap.get(s);
        if (result < 0) throw new NullPointerException();

        return result;
    }
}
