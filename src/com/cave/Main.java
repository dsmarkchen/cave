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
            String word = reader.next();
            if (word.equals("exit")) break;
            if (word.equals("bye")) break;

            int h = wordTable.lookup(word);
            if (h < 0) {
                System.out.println("I can't handle `" + word + "'!");
                continue;
            }

            WordType type = wordTable.wordType(h);
            int meaning = wordTable.meaning(h);
            Motion motion = Motion.values()[meaning - 1];
            loc = controller.move(motion, loc);
            System.out.println(loc.toString());
            System.out.println(controller.longDesc(loc));
        }

    }
}
