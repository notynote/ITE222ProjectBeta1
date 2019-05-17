//This class contain frequency use function
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Helper {

    //getRandomNumberInRange Method
    public static int getRandomNumberInRange(int min, int max) {

        //variable
        Random rsd = new Random();

        if (min >= max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }

        return rsd.nextInt((max-min)+1) + min;
    }

    //Weapon Storage
    public static void Armory(){

        //Create Array of Weapon
        Weapon[] armory = new Weapon[5];

        armory[0] = new Weapon("Stick", 5);
        armory[1] = new Weapon("Wooden Sword", 10);
        armory[2] = new Weapon("Iron Sword", 20);
        armory[3] = new Weapon("Magic Sword", 30);
        armory[4] = new Weapon("Master Sword", 50);

    }

    //Give weapon to charactor
    public static Weapon FoundWeapon(Weapon[] armory){

        int i = getRandomNumberInRange(0,4);

        return armory[i];

    }

}
