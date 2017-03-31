package com.cave;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        Controller controller = new Controller();
        controller.build();
        Location loc = Location.road;
        System.out.println(controller.desc(loc));


    }
}
