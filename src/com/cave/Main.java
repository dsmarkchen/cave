package com.cave;

import com.cave.word.WordConsts;
import com.cave.word.WordType;

import java.util.Scanner;

public class Main {
    private static final boolean _debugging = true;

    public static String hint(Scanner reader) {
        StringBuilder sb = new StringBuilder();
        String hint_response = reader.nextLine();
        if (hint_response.trim().toLowerCase().equals("yes")) {
            sb.append(WordConsts.WELCOME_RESPONSE);
            sb.append("\n");
        } else if (hint_response.trim().toLowerCase().equals("no")) {
        } else {
            sb.append("Please answer Yes or No.");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.build();
        Location tmpLoc;
        Location loc = Location.road;
        WordTable wordTable = new WordTable();
        Scanner reader = new Scanner(System.in);

        Boolean needHint = true;
        while(needHint) {
            System.out.println(WordConsts.WELCOME_HINT);
            System.out.print("** ");
            String hint_response = hint(reader);
            needHint = false;
            if (hint_response.equals("Please answer Yes or No.")) {
                needHint = true;
            }

            System.out.println(hint_response);
        }

        System.out.println(controller.longDesc(loc));

        for (; ; ) {
            if (_debugging) {
                System.out.println("##" + controller.toString());
            }

            System.out.print("* ");
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
                tmpLoc = controller.move(motion, loc);
                if (tmpLoc != Location.inhand) {
                    loc = tmpLoc;
                }
                System.out.println("__" + loc.toString() + "__");
                ObjectsInLocation objsInLocation = controller.getObjectInLocation(loc);
                System.out.println(controller.describeLocationObjectNotes(objsInLocation));


                if (_debugging && objsInLocation != null) {
                    System.out.println("##" + objsInLocation.toString());
                }
            } else if (type == WordType.object_type) {
                Object object = Object.values()[wordTable.meaning(h)];
                if (controller.take(loc, object)) {
                    ObjectsInLocation objsInLocation = controller.getObjectInLocation(loc);
                    System.out.println(controller.describeLocationObjectNotes(objsInLocation));
                } else {
                    System.out.println("I see no " + object.toString() + " here.");
                }

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
                    } else {
                        System.out.println("Take what?");
                        continue;
                    }
                    Object object = Object.values()[wordTable.meaning(h)];
                    if (controller.take(loc, object)) {
                        ObjectsInLocation objsInLocation = controller.getObjectInLocation(loc);
                        System.out.println(controller.describeLocationObjectNotes(objsInLocation));
                    } else {
                        System.out.println("I see no " + object.toString() + " here.");
                    }


                } else if (action == Action.OPEN) {
                    System.out.println("Open?");
                    controller.open(loc);


                } else if (action == Action.GO) {
                    System.out.println("where?");
                }
            }
        }

    }
}
