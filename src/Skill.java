//import java util
import java.util.Random;

public class Skill {

    //Random object

    static Random rsd = new Random();

    //Calculate Skill Damage
    public static int OffendDamage(String usedskill, int cstatus){

        //variable
        int offdamage = 0;
        if (!usedskill.equals("Normal Attack")) {
            if (cstatus <= 3) {
                offdamage = getRandomNumberInRange(10,30);
            } else if (cstatus <= 6) {
                offdamage = getRandomNumberInRange(40,60);
            } else if (cstatus == 9999) { //for secret class
                offdamage = 9999;
            } else {
                offdamage = getRandomNumberInRange(70,100);
            }
        } else {
            if (cstatus <= 9) {
                offdamage = getRandomNumberInRange(10, 30);
            } else if (cstatus <= 18) {
                offdamage = getRandomNumberInRange(40, 60);
            } else {
                offdamage = getRandomNumberInRange(70, 100);
            }
        }


        return offdamage;
    }

    //Random damage method
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }

        return rsd.nextInt((max-min)+1) + min;
    }

}
