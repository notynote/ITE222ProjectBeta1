//ITE222 Project (Turn Based Fighting Game) Draft by Pathompong Phongsaporamut

import java.util.Scanner;

public class Main {

    //Create Global Scanner for user input
    static Scanner console = new Scanner(System.in);

    //global variable

    public static void main(String[] args) throws InterruptedException {

        //menu variable
        int usermenu = 0;
        int endprogram;

        //initialise weapon
        Helper.Armory();

        //do while to loop the program
        do {
            //Main Menu
            System.out.println("Welcome to ITE222 Project Draft");
            System.out.println("(This is a Alpha Version)");
            Thread.sleep(500);

            do { //check for correct input
                try {
                    System.out.println("1. Arcade Mode\n2. Player vs CPU\n3. Player vs Player\n4. Character Creator\n5. Exit the Game");
                    System.out.println("Please input your selection");
                    usermenu = Integer.parseInt(console.next());
                } catch (Exception ignore){
                    System.out.println("=====Error=====\nPlease input the correct input\n===============");
                }
            } while (usermenu !=1 && usermenu !=2 && usermenu !=3 && usermenu !=4 && usermenu !=5);

            //declare player
            Character player1,player2;
            String player1name,player2name;

            //declare battle
            Battle arcade;

            switch (usermenu) {
                case 1:
                    //Create 1 character
                    player1 = makeChar();

                    System.out.println("Your Character:\n" + player1);
                    System.out.println("==================");
                    Thread.sleep(500);
                    arcade = new Battle(player1, "1");

                    endprogram = 0;
                    break;
                case 2:
                    //Create 1 character
                    player1 = makeChar();

                    System.out.println("Your Character:\n" + player1);
                    System.out.println("==================");
                    Thread.sleep(500);
                    arcade = new Battle(player1, "2");

                    endprogram = 0;
                    break;
                case 3:

                    //Create 2 character
                    System.out.println("=====Player 1=====");
                    player1 = makeChar();
                    Thread.sleep(500);

                    System.out.println("=====Player 2=====");
                    player2 = makeChar();
                    Thread.sleep(500);

                    System.out.println("Character 1:\n" + player1 + "\n\n*****VS*****\n\nCharacter 2:\n" + player2);
                    System.out.println("==================");

                    Battle PVPbattle = new Battle(player1, player2);

                    endprogram = 0;
                    break;
                case 4:
                    charcreator();
                    endprogram = 0;
                    break;
                case 5:
                    System.out.println("Thank you for playing this game\nBye Bye!!");
                    endprogram = 1;
                    break;
                default:
                    System.out.println("This is the end of the program");
                    endprogram = 1;

            }
        } while (endprogram == 0);

    }

    //create character method
    private static void charcreator() throws InterruptedException {

        //variable
        String again;

        do {
            Character testchar = makeChar();

            System.out.println("Please Wait . . . .");
            System.out.println("We are generating your character");
            Thread.sleep(500);
            System.out.println(".10%");
            Thread.sleep(50);
            System.out.println("..20%");
            Thread.sleep(50);
            System.out.println("...30%");
            Thread.sleep(50);
            System.out.println("....40%");
            Thread.sleep(50);
            System.out.println(".....50%");
            Thread.sleep(50);
            System.out.println("......60%");
            Thread.sleep(50);
            System.out.println(".......70%");
            Thread.sleep(50);
            System.out.println("........80%");
            Thread.sleep(50);
            System.out.println(".........90%");
            Thread.sleep(50);
            System.out.println("DONE!!");
            Thread.sleep(50);
            System.out.println("====================\n" + testchar + "\n====================");
            Thread.sleep(500);
            do {
                System.out.println("Do you want to try another character? (Y/N)");
                again = console.next();
            } while (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n"));

        } while (again.equalsIgnoreCase("y"));
    }

    //define Character name method
    private static Character makeChar(){

        System.out.println("What the name of Your Character?");
        String charname = console.next();
        return new Character(charname);

    }

}
