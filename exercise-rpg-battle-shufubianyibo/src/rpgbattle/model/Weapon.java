package rpgbattle.model;

import java.util.Random;

public class Weapon {
    private static final Random rand = new Random();
    private final int swordMinDamage, swordMaxDamage;
    private final int fireballDamage;
    private final int EnergyRequired;

    public Weapon(int swordMinDamage, int swordMaxDamage, int fireballDamage, int EnergyRequired){
        if ((swordMinDamage != 0 || swordMaxDamage != 0) && (fireballDamage != 0 || EnergyRequired != 0)) {
            throw new IllegalArgumentException("Character cannot have both sword and fireball damage");
        }
        this.swordMinDamage = swordMinDamage;
        this.swordMaxDamage = swordMaxDamage;
        this.fireballDamage = fireballDamage;
        this.EnergyRequired = EnergyRequired;

    }

    public String getWeaponDescription() {
        if (fireballDamage > 0) {
            return "Fireball (" + EnergyRequired + " ⚡️ → " + fireballDamage + " ☠️)";
        } else {
            if (swordMinDamage == swordMaxDamage ) {
                return "Sword (" + swordMinDamage + " ☠️)";
            } else {
                return "Sword (" + swordMinDamage + "–" + swordMaxDamage + " ☠️)";
            }
        }
    }

    public String attack(GameCharacter attacker, GameCharacter target) {
        if (fireballDamage > 0) {
            if (attacker.useEnergy(EnergyRequired)) {
                target.takeDamage(fireballDamage);
                return attacker.getName() + " hit " + target.getName() + " with a fireball for "
                    + fireballDamage + " points of damage";
            } else {
                return attacker.getName() + " did not have enough energy for a fireball attack";
            }
        } else {
            int damage = rand.nextInt(swordMaxDamage - swordMinDamage + 1) + swordMinDamage;
            target.takeDamage(damage);
            return attacker.getName() + " struck " + target.getName() + " with a sword for "
                + damage + " points of damage";
        }
    }
}
