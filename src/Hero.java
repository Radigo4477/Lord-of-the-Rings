import java.util.Random;




public class Hero {


    int plats;
    int dragonAttacks[] = new int[]{30, 20, 10};
    int cyclopsAttacks[] = new int[]{45,50,40};
    int heroHP;


    public Hero(int plats, int heroHP) {


        this.heroHP = heroHP;
        this.plats = plats;

    }


    public int AttackedHero() {
        heroHP =  heroHP - Hero.getRandomValue(dragonAttacks);
        return heroHP;
    }

    public int AttackedHeroC() {
        heroHP = heroHP - Hero.getRandomValue(cyclopsAttacks);
        return heroHP;
    }


    public static int getRandomValue(int[] array) {

        int result = new Random().nextInt(array.length);
        return array[result];

    }


}
