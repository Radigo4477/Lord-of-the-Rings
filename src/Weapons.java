    public enum Weapons {

    shotgun(40, 0),
    Broadsword(40, 0),
    BowAndArrow(40, 0),

    LeatherArmor(0, 20),

    ChainMail(0,30 ),

    IronArmor(0,200),

    HealingPotion(0,40);

        final int levelOfDamage;
        final int protection;


        Weapons(int levelOfDamage, int protection) {

        this.levelOfDamage = levelOfDamage;
        this.protection = protection;
        }


}