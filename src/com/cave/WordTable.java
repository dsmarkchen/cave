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

        _hashMap.put("build", wordType, Motion.HOUSE.getIndex());
        _hashMap.put("house", wordType, Motion.HOUSE.getIndex());
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
