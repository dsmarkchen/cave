package com.cave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectsInLocation {
    private List<Object> _objects;
    private List<Integer> _offsets;
    private final Location _place;

    public ObjectsInLocation(Location place) {
        _objects = new ArrayList();
        _place = place;
        _offsets = new ArrayList<>();
    }
    public Location place() {
        return _place;
    }

    @Override
    public String toString() {
        return "ObjectsInLocation{" +
                "_objects=" + _objects +
                ", _offsets=" + _offsets +
                ", _place=" + _place +
                '}';
    }

    public Object first() {
        return _objects.get(0);
    }

    public ObjectsInLocation drop(Object obj, int offset) {
        _objects.add(obj);
        _offsets.add(offset);
        return this;
    }
    public void take(Object obj) {
        Iterator<Object> iterObject = _objects.iterator();
        Iterator<Integer> iterInt = _offsets.iterator();
        while(iterObject.hasNext()) {
            if(iterInt.hasNext())
                iterInt.next();
            if(obj == iterObject.next()) {
                iterObject.remove();
                iterInt.remove();
            }
        }
    }

    public int getOffsets(Object obj){
        int result = -1;
        Iterator<Object> iterObject = _objects.iterator();
        Iterator<Integer> iterInt = _offsets.iterator();

        while(iterObject.hasNext()) {
            if(iterInt.hasNext())
                result = iterInt.next();
            if(obj == iterObject.next()) {
               break;
            }
        }
        return result;

    }
    public boolean at(Object obj) {
        return _objects.contains(obj);
    }
}
