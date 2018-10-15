package com.asela.casting;

import java.util.Scanner;

public class CastingTest4 {

    /** @param args
     */
    public static void main(String[] args) {
        animateAnimal(new Dog());
    }

    private static void animateAnimal(Animal animal) {
        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < 10; i++) {
                animal.move();
                scanner.nextLine();
                animal.step();

                if (animal instanceof Shark) {
                    Shark shark = (Shark) animal;
                    shark.changeAsciiLook();
                }
            }
        }
    }

    static abstract class Animal {
        public int index = 0;

        public void move() {
            System.out.println("\n\n\n\n\n");
            for (int i = 0; i < getAsciiLook().length; i++) {
                for (int j = 0; j < index; j++) {
                    System.out.print(" ");
                }
                System.out.println(getAsciiLook()[i]);
            }
        }

        public abstract String[] getAsciiLook();

        public void step() {
            index += 3;
        }

    }

    static class Shark extends Animal {

        String[] shark1 = {
                "    __    ",
                "  \\/ 0\\   ",
                "  /\\__/   "
        };

        String[] shark2 = {
                "    __    ",
                "  \\/ 0/   ",
                "  /\\__\\   "
        };

        String[] shark  = shark1;

        @Override
        public String[] getAsciiLook() {
            return shark;
        }

        public void changeAsciiLook() {
            if (shark == shark1) {
                shark = shark2;
            } else {
                shark = shark1;
            }
        }

    }

    static class Dog extends Animal {

        String[] dog = {
                "    _    _    ",
                "  (  \\_/  )  ",
                "   \\/)\"(\\/   ",
                "    (_o_)    ",
        };

        @Override
        public String[] getAsciiLook() {
            return dog;
        }

    }

}
