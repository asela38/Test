package com.asela.casting;

import java.util.Scanner;

public class CastingTest2_1 {

    /** @param args
     */
    public static void main(String[] args) {
        dog();
        shark();
    }

    private static void shark() {
        Shark shark = new Shark();
        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < 10; i++) {
                shark.move();
                scanner.nextLine();
                shark.step();
            }
        }
    }

    private static void dog() {
        Dog dog = new Dog();
        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < 10; i++) {
                dog.move();
                scanner.nextLine();
                dog.step();
            }
        }
    }

    static class Animal {

    }

    static class Shark extends Animal {

        public int index = 0;

        String[]   shark = { "    __    ", "  \\/ 0\\   ", "  /\\__/   " };

        public void move() {
            System.out.println("\n\n\n\n\n");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < index; j++) {
                    System.out.print(" ");
                }
                System.out.println(shark[i]);
            }
        }

        public void step() {
            index += 3;
        }

    }

    static class Dog extends Animal {

        public int index = 0;

        String[]   dog   = { "    _    _    ", "  (  \\_/  )  ", "   \\/)\"(\\/   ", "    (_o_)    ", };

        public void move() {
            System.out.println("\n\n\n\n\n\n");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < index; j++) {
                    System.out.print(" ");
                }
                System.out.println(dog[i]);
            }
        }

        public void step() {
            index += 3;
        }

    }

}
