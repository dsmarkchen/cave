package com.cave;

import com.cave.word.WordType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.build();
        Location loc = Location.road;
        System.out.println(controller.longDesc(loc));
        WordTable wordTable = new WordTable();

        Scanner reader = new Scanner(System.in);
        for (; ; ) {
            String input = reader.nextLine();
            String word, rest = "";
            int l = input.indexOf(' ');
            word = input;
            if (l > 0) {
                word = input.substring(0, l);
                rest = input.substring(l).trim();
            }
            int h = wordTable.lookup(word);
            if (h < 0) {
                System.out.println("I can't handle `" + word + "'!");
                continue;
            }
            WordType type = wordTable.wordType(h);
            int meaning = wordTable.meaning(h);
            if (type == WordType.motion_type) {
                Motion motion = Motion.values()[meaning];
                loc = controller.move(motion, loc);
                ObjectsInLocation objsInLocation = controller.getObjectInLocation(loc);
                System.out.println(controller.describeLocationObjectNotes(objsInLocation));
            } else if (type == WordType.message_type) {
                String s = wordTable.message(meaning);
                System.out.println(s);

            } else if (type == WordType.action_type) {
                Action action = Action.values()[meaning];
                System.out.println(action.toString());
                if (action == Action.QUIT) {
                    break;
                } else if (action == Action.TAKE) {
                    if (!rest.isEmpty()) {
                        h = wordTable.lookup(rest);
                    }
                    Object object = Object.values()[wordTable.meaning(h)];
                    controller.take(loc, object);
                    ObjectsInLocation objsInLocation = controller.getObjectInLocation(loc);
                    System.out.println(controller.describeLocationObjectNotes(objsInLocation));


                } else if (action == Action.GO) {
                    System.out.println("where?");
                }
            }
        }

    }
}
