package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1000, 50);
        Warrior warrior = new Warrior(270, 10);
        Medic doc = new Medic(200, 5, 15);
        Berserk berserk = new Berserk(280, 15);
        Magic magic = new Magic(260, 20);
        Medic assistant = new Medic(250, 10, 5);
        Hacker.Hecker hecker = new Hacker.Hecker(200, 25);
        Hero[] heroes = {warrior, doc, berserk, magic, assistant};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        round_number++;
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].hit(boss);
            heroes[i].applySuperPower(boss, heroes);
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(round_number + " ROUND _________________");
        System.out.println("Boss health: " + boss.getHealth()
                + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Medic) {
                System.out.println(heroes[i].getClass().getSimpleName()
                        + " health: " + heroes[i].getHealth()
                        + " [" + heroes[i].getDamage() + "] +" +
                        ((Medic) heroes[i]).getHealPoints() + "+");
            } else {
                System.out.println(heroes[i].getClass().getSimpleName()
                        + " health: " + heroes[i].getHealth()
                        + " [" + heroes[i].getDamage() + "]");
            }
        }
    }
}
