package com.cave;

import com.cave.word.WordType;

public class Main {


    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.build();
        Location loc = Location.road;
        System.out.println(controller.longDesc(loc));
        WordTable wordTable = new WordTable();
        int h = wordTable.lookup("w");
        WordType type = wordTable.wordType(h);
        int meaning = wordTable.meaning(h);


        Motion motion = Motion.values()[meaning - 1];
        if (type == WordType.motion_type) {
            loc = controller.move(motion, loc);
            System.out.println(loc.toString());

            h = wordTable.lookup("east");
            meaning = wordTable.meaning(h);
            motion = Motion.values()[meaning - 1];
            loc = controller.move(motion, loc);
            System.out.println(loc.toString());


            h = wordTable.lookup("south");
            meaning = wordTable.meaning(h);
            motion = Motion.values()[meaning - 1];
            loc = controller.move(motion, loc);
            System.out.println(loc.toString());
        }

    }
}
