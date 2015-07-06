package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.Season;

/**
 *
 * @author IQJB
 */
public class EnumDemo {
    public static void main(String[] args) {
        Season s = Season.SPRING;
        System.out.println("s: " + s);

        Season season = Season.valueOf("AUTUMN");
        System.out.println("season: " + season);
        for (Season value : Season.values()) {
            System.out.println("s: " + value.name());
        }
    }
}
