package com.cave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectEntity {
    public enum ObjectState {
        STATE_DROPPED,
        STATE_TAKEN,

        STATE_OPEN,
        STATE_CLOSE;
    }
    private final Object _object;
    private final List<String> _notes;
    private ObjectState _state;


    public ObjectEntity(Object obj) {
        _object = obj;
        _notes = new ArrayList<String>();

        _state = ObjectState.STATE_DROPPED;
    }

    public ObjectState getObjectState() {
        return _state;
    }

    public ObjectEntity setObjectState(ObjectState state) {
        this._state = state;
        return this;
    }

    public Object object() {
        return _object;
    }

    public ObjectEntity addNote(String note) {
        _notes.add(note);
        return this;
    }

    public String getNote(int offset) {
        Iterator<String> iter = _notes.iterator();
        String result;
        for (int i = 0; i < offset; i++) {
            iter.next();
        }
        result = iter.next();
        return result;
    }

    @Override
    public String toString() {
        return "ObjectEntity{" +
                "_object=" + _object +
                ", _notes=" + _notes +
                ", _state=" + _state +
                '}';
    }
}
