//ITE222 Project (Turn Based Fighting Game) Draft by Pathompong Phongsaporamut

import java.util.Scanner;

public class Main {

    //Create Global Scanner for user input
    static Scanner console = new Scanner(System.in);

    //global variable

    public static void main(String[] args) {

        //menu variable
        String usermenu = "";
        int endprogram;

        //do while to loop the program
        do {
            //Main Menu
            System.out.println("Welcome to ITE222 Project Draft");
            System.out.println("(This is a Alpha Version)");

            do { //check for correct input
                System.out.println("1. Player vs Player\n2. Character Creator\n3. Exit the Game");
                usermenu = console.next();
            } while (!usermenu.equalsIgnoreCase("1") && !usermenu.equalsIgnoreCase("2") && !usermenu.equalsIgnoreCase("3"));

            switch (usermenu) {
                case "1":

                    //variable
                    String player1name, player2name;

                    //Create 2 character
                    System.out.println("What the name of Player 1 Character?");
                    player1name = console.next();
                    Character player1 = new Character(player1name);

                    System.out.println("What the name of Player 2 Character?");
                    player2name = console.next();
                    Character player2 = new Character(player2name);

                    System.out.println("Character 1:\n" + player1 + "\n\n*****VS*****\n\nCharacter 2:\n" + player2);
                    System.out.println("==================");

                    Battle Testbattle = new Battle(player1, player2);

                    endprogram = 0;
                    break;
                case "2":
                    charcreator();
                    endprogram = 0;
                    break;
                case "3":
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
    public static void charcreator(){

        //variable
        String charname;
        String again = "";

        do {
            System.out.println("What the name of your Character?");
            charname = console.next();
            Character testchar = new Character(charname);

            System.out.println("Please Wait . . . .");
            System.out.println("We are generating your character");
            System.out.println(".10%");
            System.out.println("..20%");
            System.out.println("...30%");
            System.out.println("....40%");
            System.out.println(".....50%");
            System.out.println("......60%");
            System.out.println(".......70%");
            System.out.println("........80%");
            System.out.println(".........90%");
            System.out.println("DONE!!");
            System.out.println("====================\n" + testchar + "\n====================");
            do {
                System.out.println("Do you want to try another character? (Y/N)");
                again = console.next();
            } while (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n"));

        } while (again.equalsIgnoreCase("y"));
    }

    //Battle method
    public static void Battle(Character player1, Character Player2){





    }
}
