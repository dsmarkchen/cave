package com.cave;


public class LocationEntity {
    private Location _location;
    private String _longDesc;
    private String _shortDesc;
    private int _flag;
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
}
