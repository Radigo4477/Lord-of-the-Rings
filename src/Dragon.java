import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Dragon {
    int DragonHP;

    public Dragon(int DragonHP) {

       this.DragonHP = DragonHP;

    }

    public int arrowedDragon() {
        DragonHP = DragonHP - Weapons.BowAndArrow.levelOfDamage;
        return DragonHP;
    }

    public int stabbedDragon() {
        DragonHP = DragonHP - Weapons.Broadsword.levelOfDamage;
        return DragonHP;
    }

    public int shotDragon() {
        DragonHP = DragonHP - Weapons.shotgun.levelOfDamage;
        return DragonHP;
    }


    static void DragonBossFight() {
        boolean deadOrNot = false;

        JFrame frame = new JFrame("Dragon 3d fight");

        frame.setSize(1920, 1080);
        //frame.setVisible(true);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        frame.add(label);
        label.setIcon(new ImageIcon("C:\\Users\\rodco\\OneDrive\\INTRO\\INTRO\\Lord_of_the_rings\\resources\\p3.jpg"));
        frame.pack();
        frame.setVisible(true);



        Hero myFavoriteHero = new Hero(0, 100);
        Dragon bossDragon = new Dragon(100);

        Scanner heroName = new Scanner(System.in);
        String hero;

        System.out.println("Enter your Hero's name");
        hero = heroName.nextLine();

        System.out.println("Your Hero is: " + hero);

        Scanner chooseWeapon = new Scanner(System.in);
        Weapons finalWeapon;

        System.out.println("Choose your weapon: ");
        System.out.println(Weapons.shotgun.name());
        System.out.println(Weapons.Broadsword.name());
        System.out.println(Weapons.BowAndArrow.name());
        finalWeapon = Weapons.valueOf(chooseWeapon.nextLine());


        System.out.println("You have chosen: " + finalWeapon.name());
        System.out.println("");
        System.out.println("An old warrior has appeared.");
        System.out.println("He has given you " + Weapons.ChainMail.name() + "!");

        myFavoriteHero.heroHP = myFavoriteHero.heroHP + Weapons.ChainMail.protection;

        System.out.println("You now have " + myFavoriteHero.heroHP + " hp!");

        while (bossDragon.DragonHP >= 0) {     // make a while loop

            System.out.println("");
            System.out.println("Oh no the Dragon is attacking!");

            myFavoriteHero.AttackedHero();

            System.out.println("You're at " + myFavoriteHero.heroHP + " hp!");
            System.out.println("");

            if(myFavoriteHero.heroHP <= 0) {
                deadOrNot = true;
                break;
            }

            Scanner attackDragon = new Scanner(System.in);
            String attackedDragon;

            System.out.println("Press r to attack: ");
            attackedDragon = attackDragon.nextLine();
            if (finalWeapon == Weapons.shotgun) {
                bossDragon.shotDragon();
            } else if (finalWeapon == Weapons.Broadsword) {
                bossDragon.stabbedDragon();
            } else {
                bossDragon.arrowedDragon();
            }



            System.out.println("You dealt " + finalWeapon.levelOfDamage + " amount of damage");
            System.out.println("The Dragon is at " + bossDragon.DragonHP + " hp!");

            if(bossDragon.DragonHP <= 0) {
                break;
            }


        }

        if (deadOrNot == true) {
            System.out.println("Looks like you failed the mission");

        } else {
            System.out.println("");
            System.out.println("Congratulations you killed the Dragon!");
            System.out.println("The village thanks you.");
            System.out.println("Who knows what more adventures lie ahead?");

        }
    }



}
