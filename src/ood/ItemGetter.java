package ood;

import ood.Items.*;

import java.util.Random;
/*
 * the class for getting different kinds of items from the txt file.
 * */

public class ItemGetter{
    private final static String ArmoryFilePath = "./data/Armory.txt";
    private final static String FireSpellsFilePath = "./data/FireSpells.txt";
    private final static String IceSpellsFilePath = "./data/IceSpells.txt";
    private final static String LightningSpellsFilePath = "./data/LightningSpells.txt";
    private final static String PotionsFilePath = "./data/Potions.txt";
    private final static String WeaponryFilePath = "./data/Weaponry.txt";


    Random rand = new Random();


    public Armor getArmor(){
        Armor armor = new Armor(ArmoryFilePath);
        armor.choose(rand.nextInt(1,armor.getChioceCount() + 1));
        return armor;
    }

    public Weapon getWeapon(){
        Weapon weapon = new Weapon(WeaponryFilePath);
        weapon.choose(rand.nextInt(1,weapon.getChioceCount() + 1));
        return weapon;
    }

    public Potions getPotions(){
        Potions potions = new Potions(PotionsFilePath);
        potions.choose(rand.nextInt(1,potions.getChioceCount() + 1));
        return potions;
    }

    public FireSpell getFireSpell(){
        FireSpell fireSpell = new FireSpell(FireSpellsFilePath);
        fireSpell.choose(rand.nextInt(1,fireSpell.getChioceCount() + 1));
        return fireSpell;
    }

    public IceSpell getIceSpell(){
        IceSpell iceSpell = new IceSpell(IceSpellsFilePath);
        iceSpell.choose(rand.nextInt(1,iceSpell.getChioceCount() + 1));
        return iceSpell;
    }

    public LightningSpell getLightningSpell(){
        LightningSpell lightningSpell = new LightningSpell(LightningSpellsFilePath);
        lightningSpell.choose(rand.nextInt(1,lightningSpell.getChioceCount() + 1));
        return lightningSpell;
    }

}
