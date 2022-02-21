package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker {


    public static class Hecker extends Hero {


        public Hecker(int health, int damage,int superAbility) {
            super(health, damage,SuperAbility.HACK);
        }

        public Hecker(int health, int damage) {
            super();

        }

        @Override
        public void applySuperPower(Boss boss, Hero[] heroes) {
            boolean chance = RPG_Game.random.nextBoolean();
            int damageBoss = boss.getDamage() - RPG_Game.random.nextInt(50);
            for (int i = 0; i < heroes.length; i++) {

                if (chance){
                    boss.setHealth(boss.getHealth() - damageBoss);
                    i = RPG_Game.random.nextInt(heroes.length);
                    heroes[i].setHealth(heroes[i].getHealth() + damageBoss);
                }
            }
        }
    }

}
