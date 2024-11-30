
import javax.swing.*;
import java.lang.management.BufferPoolMXBean;
import java.util.Scanner;

public class Cyclops {

    int cyclopsHP;

    boolean cyclopsState = false;

    public Cyclops(int cyclopsHP) {
        this.cyclopsHP = cyclopsHP;
    }

    public int arrowedCyclops() {
        cyclopsHP = cyclopsHP - Weapons.BowAndArrow.levelOfDamage;
        return cyclopsHP;
    }

    public int stabbedCyclops() {
        cyclopsHP = cyclopsHP - Weapons.Broadsword.levelOfDamage;
        return cyclopsHP;
    }

    public int shotCyclops() {
        cyclopsHP = cyclopsHP - Weapons.shotgun.levelOfDamage;
        return cyclopsHP;
    }

    static void CyclopsBossFight() {
        boolean heroDead = false;

        JFrame frame = new JFrame("Cyclops 3d fight");

        frame.setSize(1280, 720);
        frame.setVisible(true);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        frame.add(label);
        label.setIcon(new ImageIcon("C:\\Users\\rodco\\OneDrive\\INTRO\\INTRO\\Lord_of_the_rings\\resources\\p6.jpg"));
        frame.pack();
        //frame.setVisible(true);

        Hero my2favoriteHero = new Hero(2, 100);
        Cyclops BossCyclops = new Cyclops(200);

        System.out.println("A merchant appeared!");
        System.out.println("You have " + my2favoriteHero.plats + " plats");
        Scanner buyPotions = new Scanner(System.in);
        System.out.println("How many " + Weapons.HealingPotion.name() + "s do you want to buy for 1 plat each?");
        int boughtPlats = buyPotions.nextInt();


        if (boughtPlats == 2) {
            my2favoriteHero.plats = my2favoriteHero.plats - 2;
            my2favoriteHero.heroHP = my2favoriteHero.heroHP + Weapons.HealingPotion.protection + Weapons.HealingPotion.protection;

        } else if (boughtPlats == 1) {
            my2favoriteHero.plats = my2favoriteHero.plats - 1;
            my2favoriteHero.heroHP = my2favoriteHero.heroHP + Weapons.HealingPotion.protection;
        }



        System.out.println("You're at " + my2favoriteHero.heroHP + " hp");
        System.out.println("You have " + my2favoriteHero.plats + " plats");
        System.out.println("Do you wish to buy " + Weapons.IronArmor.name() + " for 1 plat?");
        System.out.println("yes/no");
        Scanner buyArmor = new Scanner(System.in);
        String boughtArmor = buyArmor.nextLine();
        System.out.println(boughtArmor);

        if (boughtArmor.equalsIgnoreCase("yes")) {
            System.out.println("You have bought " + Weapons.IronArmor.name());
            my2favoriteHero.heroHP = my2favoriteHero.heroHP + Weapons.IronArmor.protection;
            System.out.println("You are now at " + my2favoriteHero.heroHP);
        } else {
            System.out.println("The merchant is gone now");
        }
 


            Scanner chooseWeapon = new Scanner(System.in);
            Weapons finalWeapon;

           System.out.println("Choose your weapon: ");
           System.out.println(Weapons.shotgun.name());
           System.out.println(Weapons.Broadsword.name());
           System.out.println(Weapons.BowAndArrow.name());
           finalWeapon = Weapons.valueOf(chooseWeapon.nextLine());

           System.out.println("You have chosen: " + finalWeapon.name());


        while (BossCyclops.cyclopsHP > 0) {     //////////////////////////////////////////////////////////////////////////


            System.out.println("");
            System.out.println("Oh no the Cyclops is attacking!");

            my2favoriteHero.AttackedHeroC();

            System.out.println("You're at " + my2favoriteHero.heroHP + " hp!");
            System.out.println("");

            if (my2favoriteHero.heroHP < 0) {
                heroDead = true;
                break;
            }

            Scanner attackDragon = new Scanner(System.in);
            String attackedDragon;

            System.out.println("Press r to attack: ");
            attackedDragon = attackDragon.nextLine();
            if (finalWeapon == Weapons.shotgun) {
                 BossCyclops.shotCyclops();
            }
           else if (finalWeapon == Weapons.Broadsword) {
            BossCyclops.stabbedCyclops();
           } else {
            BossCyclops.arrowedCyclops();
            }

            System.out.println("You dealt " + finalWeapon.levelOfDamage + " amount of damage");
            System.out.println("The Cyclops is at " + BossCyclops.cyclopsHP + " hp!");

            if(BossCyclops.cyclopsHP <= 0) {
                break;
            }

      }

        if(heroDead == true) {
            System.out.println("Looks like you failed the mission");
        } else{
            System.out.println("You beat the Game!");
            System.out.println("Thanks For playing!");
        }


    }


}