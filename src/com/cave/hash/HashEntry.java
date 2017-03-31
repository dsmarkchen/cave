package com.cave.hash;

import com.cave.word.WordType;

public class HashEntry {
    private final String _text;


    private final WordType _wordType;
    private final int _meaning;


    public HashEntry() {
        _text = "";
        _wordType = WordType.no_type;
        _meaning = 0;
    }
    public HashEntry(String text, WordType wordType, int meaning) {
        _meaning = meaning;
        _wordType = wordType;
        _text = text;
    }

    public String get_text() {
        return _text;
    }

    public WordType get_wordType() {
        return _wordType;
    }

    public int get_meaning() {
        return _meaning;
    }
}
