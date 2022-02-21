import kg.geektech.game.players.Hero;
import kg.geektech.game.players.SuperAbility;

public class Wither {
    public abstract class wither extends Hero {

        public wither(int health, int damage, SuperAbility ability) {
            super(health, damage, ability);

        }
    }
}
      @Override
     public void applySuperPower(Boss boss, Hero[] heroes) {
             boolean chance = RPG_Game.random.nextBoolean();
             int damageBoss = boss.getDamage() - RPG_Game.random.nextInt(50);
             for (int i = 0; i < heroes.length; i++) {