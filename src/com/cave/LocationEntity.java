package com.cave;


public class LocationEntity {
    private final Location _location;
    private final String _longDesc;
    private final String _shortDesc;
    private final int _flag;
    private int _start;

    public LocationEntity(Location loc, String longDesc, String shortDesc, int flag, int start) {
        _location = loc;
       _longDesc = longDesc;
       _shortDesc = shortDesc;
       _flag = flag;
       _start = start;

    }
    public Location location() {
        return _location;
    }

    public String longDesc() {
        return _longDesc;
    }

    public String shortDesc() {
        return _shortDesc;
    }

    public int flag() {
        return _flag;
    }

    public int start() {
        return _start;
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "_location=" + _location +
                ", _longDesc='" + _longDesc + '\'' +
                ", _shortDesc='" + _shortDesc + '\'' +
                ", _flag=" + _flag +
                ", _start=" + _start +
                '}';
    }
}
