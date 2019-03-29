import java.util.Random;

public class CPU extends Character {

    //variable
    int level;
    static Random rsd = new Random();

    //default constructor (random cpu level)
    public CPU(){
        super(getRandomNumberInRange(1,10));

    }

    public CPU(int level){
        super(level);
    }

    //Random damage method
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }

        return rsd.nextInt((max-min)+1) + min;
    }

}
