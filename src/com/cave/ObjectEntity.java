package com.cave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectEntity {

    private final Object _object;
    private final List<String> _notes;

    public ObjectEntity(Object obj) {
        _object = obj;
        _notes = new ArrayList<String>();
    }

    public ObjectEntity addNote(String note) {
        _notes.add(note);
        return this;
    }
    public Object object() {
        return _object;
    }


    public String getNote(int offset){
        Iterator<String> iter = _notes.iterator();
        String result;
        for(int i=0; i < offset; i++){
            iter.next();
        }
        result = iter.next();
        return result;
    }
}
