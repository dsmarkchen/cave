package com.cave.hash;

import com.cave.word.WordType;

public class HashMap {
    private final static int HASH_PRIME = 1009;
    private final static int TABLE_SIZE = HASH_PRIME;

    private HashEntry[] _table;

    public HashMap() {
        _table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            _table[i] = new HashEntry();
        }
    }

    public int meaning(int index) {
        return _table[index].get_meaning();
    }

    public WordType wordType(int index) {
        return _table[index].get_wordType();
    }

    public String text(int index) {
        return _table[index].get_text();
    }


    public void put(String text, WordType wordType, int meaning) {
        char[] w;
        int len = text.length();
        w = new char[len];
        for (int i = 0; i < len; i++) {
            w[i] = text.toCharArray()[i];
        }
        int h;
        int p;
        for (h = 0, p = 0; p < len; p++) {
            h = w[p] + h + h;
        }
        h = h % HASH_PRIME;
        while (_table[h].get_wordType().ordinal() != 0) {
            h++;
            if (h == HASH_PRIME) h = 0;
        }
        String newText = w.toString();
        _table[h] = new HashEntry(new String(w), wordType, meaning);
    }

    public int get(String text) {
        char[] w = new char[5];
        int len = text.length();
        if (len > 5) len = 5;
        for (int i = 0; i < len; i++)
            w[i] = text.toCharArray()[i];
        int h, p;
        for (h = 0, p = 0; p < len; p++) {
            h = w[p] + h + h;
        }
        h = h % HASH_PRIME;
        if (h < 0) return -1;
        String hText;
        while (_table[h].get_wordType().ordinal() != 0) {
            hText = _table[h].get_text();
            if (hText.equals(text)) return h;
            h++;
            if (h == HASH_PRIME) h = 0;
        }
        return -1;
    }
}
