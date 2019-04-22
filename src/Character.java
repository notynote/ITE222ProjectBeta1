//import java util
import java.util.Random;
import java.util.Scanner;

public class Character {

    //global scanner
    static Scanner console = new Scanner(System.in);

    //variable
    int hp;
    private int str;
    private int wis;
    private int dex;
    private String offend,defend,noffend,ndefend,offend2,defend2,offend3,defend3 = "";
    private String charclass = "";
    private String charname = "";

    //Random Object
    Random r = new Random();

    //Default constructor
    public Character(){

        System.out.println("What the name of your Character?");
        this.charname = console.nextLine();

        //Random attribute
        this.hp = getRandomNumberInRange(100,500);
        this.str = getRandomNumberInRange(1,9);
        this.wis = getRandomNumberInRange(1,9);
        this.dex = getRandomNumberInRange(1,9);

        //Random class
        this.charclass = getRandomClass(1,3);

        //Skill
        Skill(charclass);
    }

    //Create new character
    public Character(String name) {

        //Name
        this.charname = name;
        //System.out.println("What the name of your Character?");
        //this.charname = console.nextLine();

        //Random attribute
        this.hp = getRandomNumberInRange(100,500);
        this.str = getRandomNumberInRange(1,9);
        this.wis = getRandomNumberInRange(1,9);
        this.dex = getRandomNumberInRange(1,9);

        //this function allow user to choose the class if they know a keyword
        //check if user put the keyword for class
        switch (name.toLowerCase()){
            case "mage":
            case "wizard":
            case "boomboomboom":
                this.charclass = "Mage";
                break;
            case "warrior":
            case "swordsmen":
            case "shubshubshub":
                this.charclass = "Warrior";
                break;
            case "archer":
            case "hunter":
            case "pewpewpew":
                this.charclass = "Archer";
                break;
            case "notynotethehandsomeguy":
                this.charclass = "God";
                this.hp = 999999;
                this.str = 8888;
                this.wis = 7777;
                this.dex = 6666;
                break;
            default: //no class selected
                //Random Class
                this.charclass = getRandomClass(1,3);

        }

        //Skill
        Skill(charclass);
    }

    //Default for CPU
    public Character(int level){

        //determine cpu level as name
        switch (level){
            case 1:
                this.charname = "Noob CPU";
                this.hp = getRandomNumberInRange(50,100);
                this.str = 1;
                this.wis = 1;
                this.dex = 1;
                break;
            case 2:
                this.charname = "Extremely Easy CPU";
                this.hp = getRandomNumberInRange(50,300);
                this.str = getRandomNumberInRange(1,3);
                this.wis = getRandomNumberInRange(1,3);
                this.dex = getRandomNumberInRange(1,3);
                break;
            case 3:
                this.charname = "Very Easy CPU";
                this.hp = getRandomNumberInRange(50,500);
                this.str = getRandomNumberInRange(1,5);
                this.wis = getRandomNumberInRange(1,5);
                this.dex = getRandomNumberInRange(1,5);
                break;
            case 4:
                this.charname = "Easy CPU";
                this.hp = getRandomNumberInRange(100,300);
                this.str = getRandomNumberInRange(1,7);
                this.wis = getRandomNumberInRange(1,7);
                this.dex = getRandomNumberInRange(1,7);
                break;
            case 5:
                this.charname = "Medium CPU";
                this.hp = getRandomNumberInRange(100,500);
                this.str = getRandomNumberInRange(1,9);
                this.wis = getRandomNumberInRange(1,9);
                this.dex = getRandomNumberInRange(1,9);
                break;
            case 6:
                this.charname = "Hard CPU";
                this.hp = getRandomNumberInRange(300,500);
                this.str = getRandomNumberInRange(3,9);
                this.wis = getRandomNumberInRange(3,9);
                this.dex = getRandomNumberInRange(3,9);
                break;
            case 7:
                this.charname = "Insane CPU";
                this.hp = getRandomNumberInRange(300,800);
                this.str = getRandomNumberInRange(6,9);
                this.wis = getRandomNumberInRange(6,9);
                this.dex = getRandomNumberInRange(6,9);
                break;
            case 8:
                this.charname = "Nightmare CPU";
                this.hp = getRandomNumberInRange(500,800);
                this.str = 9;
                this.wis = 9;
                this.dex = 9;
                break;
            case 9:
                this.charname = "Impossible CPU";
                this.hp = getRandomNumberInRange(800,1500);
                this.str = getRandomNumberInRange(9,15);
                this.wis = getRandomNumberInRange(9,15);
                this.dex = getRandomNumberInRange(9,15);
                break;
            case 10:
                this.charname = "The End CPU";
                this.hp = getRandomNumberInRange(1000,1500);
                this.str = getRandomNumberInRange(9,20);
                this.wis = getRandomNumberInRange(9,20);
                this.dex = getRandomNumberInRange(9,20);
                break;
            default:
                this.charname = "You Just Cannot Win This . . .";
                this.hp = 9999;
                this.str = 9999;
                this.wis = 9999;
                this.dex = 9999;

        }


        //Random class
        this.charclass = getRandomClass(1,3);

        //Skill
        Skill(charclass);
    }

    //Random int method
    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }

        return r.nextInt((max-min)+1) + min;
    }

    //Random Class Method
    private String getRandomClass(int x, int y){

        int classint;

        classint = r.nextInt((y-x)+1) + x;
        switch (classint){
            case 1:
                return "Warrior";
            case 2:
                return "Mage";
            case 3:
                return "Archer";
            default:
                return "God";
        }

    }

    //Assign Skill
    private void Skill(String charclass){
        switch (charclass){
            case "Warrior":
                offend = "Stab";
                defend = "Shield Block";
                break;
            case "Mage":
                offend = "Cast Spell";
                defend = "Ice Wall";
                break;
            case "Archer":
                offend = "Shoot";
                defend = "Dodge";
                break;
            default:
                offend = "Kill Command";
                defend = "Disappear";
//                offend2 = "Fire";
//                defend2 = "Ice Wall";
//                offend3 = "Shoot";
//                defend3 = "Dodge";
        }
        //put normal attack
        noffend = "Normal Attack";
        ndefend = "Normal Defend";
    }

    public String toString(){

        String charskill = offend + ", " + defend + ", " + noffend + ", " + ndefend;
        return "Character Name is " + this.charname + " Class is " + this.charclass +
                " HP: " + this.hp + " STR: " + this.str + " WIS: " + this.wis + " DEX: " + this.dex +
                " Skills: " + charskill;
    }

    //get methods

    public String getCharname() {
        return charname;
    }

    public String getCharclass() {
        return charclass;
    }

    public int getHp(){
        return this.hp;
    }

    public int getStr(){
        return this.str;
    }

    public int getWis(){
        return this.wis;
    }

    public int getDex(){
        return this.dex;
    }

    public String getOffend(){
        return this.offend;
    }

    public String getDefend(){
        return this.defend;
    }

    public String getNoffend() {
        return noffend;
    }

    public String getNdefend() {
        return ndefend;
    }



}