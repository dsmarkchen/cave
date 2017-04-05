package com.cave;


import com.cave.hash.HashMap;
import com.cave.word.WordConsts;
import com.cave.word.WordType;

import static com.cave.Motion.*;

public class WordTable {
    private HashMap _hashMap;
    private String[] _messages;

    public WordTable() {
        _hashMap = new HashMap();
        _messages = new String[]{
                WordConsts.HELP, //0
                WordConsts.INFO, //1
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                WordConsts.SWIM,
        };

        build();
    }

    private void build() {
        buildMotions();

        buildObjects();

        buildActions();

        buildMessages();
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


        _hashMap.put("downs", wordType, Motion.DOWNSTREAM.getIndex());
        _hashMap.put("enter", wordType, Motion.ENTER.getIndex());
        _hashMap.put("crawl", wordType, Motion.CRAWL.getIndex());
        _hashMap.put("jump", wordType, Motion.JUMP.getIndex());
        _hashMap.put("climb", wordType, Motion.CLIMB.getIndex());
        _hashMap.put("look", wordType, Motion.LOOK.getIndex());
        _hashMap.put("descr", wordType, Motion.LOOK.getIndex());

        _hashMap.put("cross", wordType, Motion.CROSS.getIndex());
        _hashMap.put("road", wordType, Motion.ROAD.getIndex());
        _hashMap.put("hill", wordType, Motion.ROAD.getIndex());

        _hashMap.put("fores", wordType, Motion.WOODS.getIndex());
        _hashMap.put("valle", wordType, Motion.VALLEY.getIndex());

        _hashMap.put("build", wordType, Motion.HOUSE.getIndex());
        _hashMap.put("house", wordType, Motion.HOUSE.getIndex());

        _hashMap.put("gully", wordType, Motion.GULLY.getIndex());
        _hashMap.put("strea", wordType, Motion.STREAM.getIndex());
        _hashMap.put("depre", wordType, Motion.DEPRESSION.getIndex());
        _hashMap.put("entra", wordType, Motion.ENTRANCE.getIndex());
        _hashMap.put("cave", wordType, Motion.CAVE.getIndex());
        _hashMap.put("rock", wordType, Motion.ROCK.getIndex());
        _hashMap.put("slab", wordType, Motion.SLAB.getIndex());
        _hashMap.put("bed", wordType, Motion.BED.getIndex());
        _hashMap.put("passa", wordType, Motion.PASSAGE.getIndex());
        _hashMap.put("caver", wordType, Motion.CAVERN.getIndex());
        _hashMap.put("canyo", wordType, Motion.CANYON.getIndex());
        _hashMap.put("awkwa", wordType, Motion.AWKWARD.getIndex());
        _hashMap.put("secre", wordType, Motion.SECRET.getIndex());

        _hashMap.put("bedqu", wordType, Motion.BEDQUILT.getIndex());
        _hashMap.put("reser", wordType, Motion.RESERVOIR.getIndex());
        _hashMap.put("giant", wordType, Motion.GIANT.getIndex());
        _hashMap.put("orien", wordType, Motion.ORIENTAL.getIndex());
        _hashMap.put("shell", wordType, Motion.SHELL.getIndex());
        _hashMap.put("barre", wordType, Motion.BARREN.getIndex());
        _hashMap.put("broke", wordType, Motion.BROKEN.getIndex());
        _hashMap.put("debri", wordType, Motion.DEBRIS.getIndex());

        _hashMap.put("view", wordType, Motion.VIEW.getIndex());
        _hashMap.put("fork", wordType, Motion.FORK.getIndex());
        _hashMap.put("pit", wordType, Motion.PIT.getIndex());


        _hashMap.put("slit", wordType, Motion.SLIT.getIndex());
        _hashMap.put("crack", wordType, Motion.CRACK.getIndex());
        _hashMap.put("dome", wordType, Motion.DOME.getIndex());

        _hashMap.put("hole", wordType, Motion.HOLE.getIndex());
        _hashMap.put("wall", wordType, Motion.WALL.getIndex());
        _hashMap.put("hall", wordType, Motion.HALL.getIndex());

        _hashMap.put("y2", wordType, Motion.Y2.getIndex());
        _hashMap.put("xyzzy", wordType, Motion.XYZZY.getIndex());
        _hashMap.put("plugh", wordType, Motion.PLUGH.getIndex());

        _hashMap.put("main", wordType, Motion.OFFICE.getIndex());
        _hashMap.put("nowhe", wordType, Motion.NOWHERE.getIndex());

    }

    private void buildObjects() {
        WordType wordType = WordType.object_type;
        _hashMap.put("key", wordType, Object.KEYS.getIndex());
        _hashMap.put("keys", wordType, Object.KEYS.getIndex());
        _hashMap.put("lamp", wordType, Object.LAMP.getIndex());
        _hashMap.put("lante", wordType, Object.LAMP.getIndex());
        _hashMap.put("head1", wordType, Object.LAMP.getIndex());

        _hashMap.put("grate", wordType, Object.GRATE.getIndex());
        _hashMap.put("cage", wordType, Object.CAGE.getIndex());
        _hashMap.put("rod", wordType, Object.ROD.getIndex());
        _hashMap.put("bird", wordType, Object.BIRD.getIndex());

    }

    private void buildActions() {
        WordType wordType = WordType.action_type;
        _hashMap.put("take", wordType, Action.TAKE.getIndex());
        _hashMap.put("carry", wordType, Action.TAKE.getIndex());
        _hashMap.put("keep", wordType, Action.TAKE.getIndex());
        _hashMap.put("catch", wordType, Action.TAKE.getIndex());
        _hashMap.put("captu", wordType, Action.TAKE.getIndex());
        _hashMap.put("steal", wordType, Action.TAKE.getIndex());
        _hashMap.put("get", wordType, Action.TAKE.getIndex());

        _hashMap.put("open", wordType, Action.OPEN.getIndex());
        _hashMap.put("close", wordType, Action.CLOSE.getIndex());

        _hashMap.put("walk", wordType, Action.GO.getIndex());
        _hashMap.put("run", wordType, Action.GO.getIndex());
        _hashMap.put("trave", wordType, Action.GO.getIndex());
        _hashMap.put("go", wordType, Action.GO.getIndex());


        _hashMap.put("quit", wordType, Action.QUIT.getIndex());
    }

    private void buildMessages() {
        WordType wordType = WordType.message_type;
        _hashMap.put("help", wordType, 0);
        _hashMap.put("info", wordType, 1);
        _hashMap.put("swim", wordType, 9);
    }

    public int lookup(String s) {
        int result = _hashMap.get(s);
        return result;
    }

    public int meaning(int h) {
        return _hashMap.meaning(h);
    }

    public WordType wordType(int h) {
        return _hashMap.wordType(h);
    }

    public String message(int index) {
        return _messages[index];
    }

    public String text(int h) {
        return _hashMap.text(h);
    }
}
