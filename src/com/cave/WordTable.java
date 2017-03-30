package com.cave;


import com.cave.word.WordType;

import java.util.Hashtable;

public class WordTable {
    private Hashtable<String, Integer> _hashTable;
    private WordType _wordType;

    public WordTable() {
        _hashTable = new Hashtable<String, Integer>();
        build();
    }

    private void build() {
        buildMotions();

        buildObjects();
    }

    private void buildMotions() {
        _hashTable.put("north", Motion.N.hashCode());
        _hashTable.put("n", Motion.N.hashCode());
        _hashTable.put("south", Motion.S.hashCode());
        _hashTable.put("s", Motion.S.hashCode());
    }

    private void buildObjects() {
        _hashTable.put("key", Object.KEYS.hashCode());
        _hashTable.put("keys", Object.KEYS.hashCode());
        _hashTable.put("lamp", Object.LAMP.hashCode());
        _hashTable.put("lante", Object.LAMP.hashCode());
        _hashTable.put("head1", Object.LAMP.hashCode());

    }

    public int find(String s) {
        return _hashTable.get(s);
    }
}
