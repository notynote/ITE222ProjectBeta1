import java.util.Random;
import java.util.Scanner;

public class Battle {

    //variable
    private Character player1;
    private Character player2;
    private Random r = new Random();

    //Scanner
    private Scanner console = new Scanner(System.in);

    //constructor Battle for 1 player vs cpu
    public  Battle(Character player1){

    }

    //constructor Battle for 2 player
    public Battle(Character player1, Character player2){

        //variable
        int whowin,starter;
        this.player1 = player1;
        this.player2 = player2;

        //Random who go first
        starter = getStarter();
        if (starter == 1){
            //player 1 go first
            System.out.println(player1.getCharname() + " go first!!");
            whowin = FightingPvP(1);
            Annoucer(whowin);
        } else {
            //player 2 go first
            System.out.println(player2.getCharname() + " go first!!");
            whowin = FightingPvP(2);
            Annoucer(whowin);
        }
    }

    //Fighting Method Player vs Player
//    private int FightingPvP(Character player1,Character player2,int Starter){
      private int FightingPvP(int Starter){
        //variable
        //int hasWinner = 0;
          String modeselect = "";

          //ask for the mode to play
          do {
              System.out.println("==========\nPlease Choose your game mode. . .\n1. Normal Mode\n2. Attack Only Mode\n3. Auto Mode");
              modeselect = console.next();
          } while (!modeselect.equalsIgnoreCase("1") && !modeselect.equalsIgnoreCase("2") && !modeselect.equalsIgnoreCase("3"));

          if (Starter == 1){ //player1 start first
            do {
                //player1 turn
                if (modeselect.equalsIgnoreCase("1")) {
                    fightturn(1, 0);
                } else if (modeselect.equalsIgnoreCase("2")){
                    AttackOnly(1,0);
                } else {
                    Automode(1,0);
                }
                //if hp fall below + equal to 0 then attacker = winner then return winner and stop the fight
                if (player2.hp <= 0){
                    return 1;
                }

                //player2 turn
                if (modeselect.equalsIgnoreCase("1")) {
                    fightturn(2, 0);
                } else if (modeselect.equalsIgnoreCase("2")){
                    AttackOnly(2,0);
                } else {
                    Automode(2,0);
                }
                if (player1.hp <= 0){
                    return 2;
                }

            } while(true);

        } else { //if player2 start first

            do {
                //player2 turn
                if (modeselect.equalsIgnoreCase("1")) {
                    fightturn(2, 0);
                } else if (modeselect.equalsIgnoreCase("2")){
                    AttackOnly(2,0);
                } else {
                    Automode(2,0);
                }
                if (player1.hp <= 0){
                    return 2;
                }

                //player1 turn
                if (modeselect.equalsIgnoreCase("1")) {
                    fightturn(1, 0);
                } else if (modeselect.equalsIgnoreCase("2")){
                    AttackOnly(1,0);
                } else {
                    Automode(1,0);
                }
                if (player2.hp <= 0){
                    return 1;
                }

            } while(true);
        }

    }

    private void fightturn(int player,int cpu){
        //variable
        String skillchoice,defendchoice;
        String attackerskill = "";
        String defenderskill = "";
        int attackerstatus = 0;
        int defenderstatus = 0;
        int finaldmg;
        Character attacker = null,defender = null;

        //ask user to choose attack skill
        do {
            if (player == 1) {
                attacker = player1;
                defender = player2;
            } else if (player == 2) {
                attacker = player2;
                defender = player1;
            }

            System.out.println(attacker.getCharname() + " turn. What skill do you want to use?\n1. " + attacker.getOffend() + "\n2. " + attacker.getNoffend());
            skillchoice = console.next();
        } while (!skillchoice.equalsIgnoreCase("1") && !skillchoice.equalsIgnoreCase("2"));

        switch (skillchoice) {
            case "1":
                attackerskill = attacker.getOffend();
                    switch (attacker.getCharclass()) {
                        case "Warrior":
                            attackerstatus = attacker.getStr();
                            break;
                        case "Mage":
                            attackerstatus = attacker.getWis();
                            break;
                        case "Archer":
                            attackerstatus = attacker.getDex();
                            break;
                        //secret class
                        default:
                            attackerstatus = 9999;
                    }
                    break;

            case "2":
                    attackerskill = attacker.getNoffend();
                    attackerstatus = attacker.getStr() + attacker.getDex() + attacker.getWis();
                    break;

            default:
                System.out.println("error");
        }

        //defender select skill
        do {
            System.out.println(defender.getCharname() + " prepare for defend\n1. " + defender.getDefend() + "\n2. " + defender.getNdefend());
            defendchoice = console.next();
        } while (!defendchoice.equalsIgnoreCase("1") && !defendchoice.equalsIgnoreCase("2"));

        switch (defendchoice) {
            case "1":
                defenderskill = defender.getDefend();
                break;

            case "2":
                defenderskill = defender.getNdefend();
                break;

            default:
                System.out.println("error");
        }

        //calculation for final damage
            //get attack damage
            int attackerdmg = Skill.OffendDamage(attackerskill, attackerstatus);
            //check the element advantage to determine final damage
            switch (attackerskill){
                case "Stab": //warrior
                    switch (defenderskill){
                        case "Shield Block": //warrior
                        case "Normal Defend":
                            finaldmg = attackerdmg;
                            break;
                        case "Ice Wall":
                            finaldmg = attackerdmg * 2;
                            break;
                        case "Dodge":
                            finaldmg = attackerdmg / 2;
                            break;
                        default:
                            finaldmg = 0;
                    }
                    break;
                case "Cast Spell": //mage
                    switch (defenderskill){
                        case "Shield Block":
                            finaldmg = attackerdmg / 2;
                            break;
                        case "Ice Wall":
                        case "Normal Defend":
                            finaldmg = attackerdmg;
                            break;
                        case "Dodge":
                            finaldmg = attackerdmg * 2;
                            break;
                        default:
                            finaldmg = 0;
                    }
                    break;
                case "Shoot": //archer
                    switch (defenderskill){
                        case "Shield Block":
                            finaldmg = attackerdmg * 2;
                            break;
                        case "Ice Wall":
                            finaldmg = attackerdmg / 2;
                            break;
                        case "Dodge":
                        case "Normal Defend":
                            finaldmg = attackerdmg;
                            break;
                        default:
                            finaldmg = 0;
                    }
                    break;
                case "Normal Attack":
                    switch (defenderskill){
                        case "Shield Block":
                        case "Ice Wall":
                        case "Dodge":
                            finaldmg = attackerdmg;
                            break;
                        case "Normal Defend":
                            finaldmg = attackerdmg*2;
                            break;
                        default:
                            finaldmg = 0;
                    }
                    break;
                default:
                    finaldmg = attackerdmg;
            }

        System.out.println(attacker.getCharname() + " " + attackerskill + " " + defender.getCharname() + " for " + attackerdmg + " damage");
        System.out.println("but " + defender.getCharname() + " " + defenderskill + " the attack and take " + finaldmg + " damage");
        defender.hp -= finaldmg;
        System.out.println("==============\n" + defender.getCharname() + " now has " + defender.hp + " hp" + "\n==============");

    }

    //attack only method
    public void AttackOnly(int player, int cpu){

        String attackerskill = "";
        Character attacker = null,defender = null;
        String skillchoice;
        int attackerstatus = 0;

            if (player == 1) {
                attacker = player1;
                defender = player2;
            } else if (player == 2) {
                attacker = player2;
                defender = player1;
            }

        do {
            System.out.println(attacker.getCharname() + " turn. What skill do you want to use?\n1. " + attacker.getOffend() + "\n2. " + attacker.getNoffend());
            skillchoice = console.next();
        } while (!skillchoice.equalsIgnoreCase("1") && !skillchoice.equalsIgnoreCase("2"));

        switch (skillchoice) {
            case "1":
                attackerskill = attacker.getOffend();
                switch (attacker.getCharclass()) {
                    case "Warrior":
                        attackerstatus = attacker.getStr();
                        break;
                    case "Mage":
                        attackerstatus = attacker.getWis();
                        break;
                    case "Archer":
                        attackerstatus = attacker.getDex();
                        break;
                    //secret class
                    default:
                        attackerstatus = 9999;
                }
                break;

            case "2":
                attackerskill = attacker.getNoffend();
                attackerstatus = attacker.getStr() + attacker.getDex() + attacker.getWis();
                break;

            default:
                System.out.println("error");
        }

        //get attack damage
        int attackerdmg = Skill.OffendDamage(attackerskill, attackerstatus);


        System.out.println(attacker.getCharname() + " " + attacker.getOffend() + " " + defender.getCharname() + " for " + attackerdmg + " damage");
        defender.hp -= attackerdmg;
        System.out.println("==============\n" + defender.getCharname() + " now has " + defender.hp + " hp" + "\n==============");

    }

    //Auto Mode
    public void Automode(int player,int cpu){
        //variable
        int skillchoice,defendchoice;
        String attackerskill = "";
        String defenderskill = "";
        int attackerstatus = 0;
        int defenderstatus = 0;
        int finaldmg;
        Character attacker = null,defender = null;

        //ask user to choose attack skill
            if (player == 1) {
                attacker = player1;
                defender = player2;
            } else if (player == 2) {
                attacker = player2;
                defender = player1;
            }

            System.out.println(attacker.getCharname() + " turn. Random skill to use.");
            skillchoice = getStarter();
            if (skillchoice == 1){
                System.out.println(attacker.getCharname() + " will use " +attacker.getOffend());
            } else {
                System.out.println(attacker.getCharname() + " will use " +attacker.getNoffend());
            }
        System.out.println("========================================");

        switch (skillchoice) {
            case 1:
                attackerskill = attacker.getOffend();
                switch (attacker.getCharclass()) {
                    case "Warrior":
                        attackerstatus = attacker.getStr();
                        break;
                    case "Mage":
                        attackerstatus = attacker.getWis();
                        break;
                    case "Archer":
                        attackerstatus = attacker.getDex();
                        break;
                    //secret class
                    default:
                        attackerstatus = 9999;
                }
                break;

            case 2:
                attackerskill = attacker.getNoffend();
                attackerstatus = attacker.getStr() + attacker.getDex() + attacker.getWis();
                break;

            default:
                System.out.println("error");
        }

        //random defender skill
            System.out.println(defender.getCharname() + " random skill for defend.");
            defendchoice = getStarter();
            if (defendchoice == 1){
                System.out.println(defender.getCharname() + " will use " +defender.getDefend());
            } else {
                System.out.println(defender.getCharname() + " will use " +defender.getNdefend());
            }
        System.out.println("========================================");

        switch (defendchoice) {
            case 1:
                defenderskill = defender.getDefend();
                break;

            case 2:
                defenderskill = defender.getNdefend();
                break;

            default:
                System.out.println("error");
        }

        //calculation for final damage
        //get attack damage
        int attackerdmg = Skill.OffendDamage(attackerskill, attackerstatus);
        //check the element advantage to determine final damage
        switch (attackerskill){
            case "Stab": //warrior
                switch (defenderskill){
                    case "Shield Block": //warrior
                    case "Normal Defend":
                        finaldmg = attackerdmg;
                        break;
                    case "Ice Wall":
                        finaldmg = attackerdmg * 2;
                        break;
                    case "Dodge":
                        finaldmg = attackerdmg / 2;
                        break;
                    default:
                        finaldmg = 0;
                }
                break;
            case "Cast Spell": //mage
                switch (defenderskill){
                    case "Shield Block":
                        finaldmg = attackerdmg / 2;
                        break;
                    case "Ice Wall":
                    case "Normal Defend":
                        finaldmg = attackerdmg;
                        break;
                    case "Dodge":
                        finaldmg = attackerdmg * 2;
                        break;
                    default:
                        finaldmg = 0;
                }
                break;
            case "Shoot": //archer
                switch (defenderskill){
                    case "Shield Block":
                        finaldmg = attackerdmg * 2;
                        break;
                    case "Ice Wall":
                        finaldmg = attackerdmg / 2;
                        break;
                    case "Dodge":
                    case "Normal Defend":
                        finaldmg = attackerdmg;
                        break;
                    default:
                        finaldmg = 0;
                }
                break;
            case "Normal Attack":
                switch (defenderskill){
                    case "Shield Block":
                    case "Ice Wall":
                    case "Dodge":
                        finaldmg = attackerdmg;
                        break;
                    case "Normal Defend":
                        finaldmg = attackerdmg*2;
                        break;
                    default:
                        finaldmg = 0;
                }
                break;
            default:
                finaldmg = attackerdmg;
        }

        System.out.println(attacker.getCharname() + " " + attackerskill + " " + defender.getCharname() + " for " + attackerdmg + " damage");
        System.out.println("but " + defender.getCharname() + " " + defenderskill + " the attack and take " + finaldmg + " damage");
        defender.hp -= finaldmg;
        System.out.println("==============\n" + defender.getCharname() + " now has " + defender.hp + " hp" + "\n==============");


    }

    //announcer method
    private void Annoucer(int winner){

        if (winner == 1){
            System.out.println("**********\n" + player1.getCharname() + " WON the fight!!\n**********");
        } else {
            System.out.println("**********\n" + player2.getCharname() + " WON the fight!!\n**********");
        }

    }



    //Random Starter method
    private int getStarter() {

        if (1 >= 2) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }

        return r.nextInt((2-1)+1) + 1;
    }

}

/*
old code
    //player 1 turn method
    private void player1turn(){
        //variable
        String p1skillchoice = "";
        String p1skill = "";
        int p1status = 0;

        //ask user to choose attack skill
        do {
            System.out.println(player1.getCharname() + " turn. What skill do you want to use?\n1. " + player1.getOffend() + "\n2. " + player1.getNoffend());
            p1skillchoice = console.nextLine();
        } while (!p1skillchoice.equalsIgnoreCase("1") && !p1skillchoice.equalsIgnoreCase("2"));

        switch (p1skillchoice) {
            case "1":
                p1skill = player1.getOffend();
                switch (player1.getCharclass()) {
                    case "Warrior":
                        p1status = player1.getStr();
                        break;
                    case "Mage":
                        p1status = player1.getWis();
                        break;
                    case "Archer":
                        p1status = player1.getDex();
                        break;
                    default: //for secret class
                        p1status = 9999;
                }
                break;
            case "2":
                p1skill = player1.getNoffend();
                p1status = player1.getStr() + player1.getDex() + player1.getWis();
                break;
            default:
                System.out.println("error");
        }
        int player1dmg = Skill.OffendDamage(p1skill,p1status);
        System.out.println(player1.getCharname() + " " + p1skill + " " + player2.getCharname() + " for " + player1dmg + " damage");
        player2.hp -= player1dmg;
        System.out.println("==============");
        System.out.println(player2.getCharname() + " now has " + player2.hp + " hp");
        System.out.println("==============");
    }

    private void player2turn(){
        //variable
        int p2status = 0;
        String p2skillchoice = "";
        String p2skill = "";

        //ask user to choose attack skill
        do {
            System.out.println(player2.getCharname() + " turn. What skill do you want to use?\n1. " + player2.getOffend() + "\n2. " + player2.getNoffend());
            p2skillchoice = console.nextLine();
        } while (!p2skillchoice.equalsIgnoreCase("1") && !p2skillchoice.equalsIgnoreCase("2"));

        switch (p2skillchoice) {
            case "1":
                p2skill = player2.getOffend();
                switch (player2.getCharclass()) {
                    case "Warrior":
                        p2status = player2.getStr();
                        break;
                    case "Mage":
                        p2status = player2.getWis();
                        break;
                    case "Archer":
                        p2status = player2.getDex();
                        break;
                    default: //for secret class
                        p2status = 9999;
                }
                break;
            case "2":
                p2skill = player2.getNoffend();
                p2status = player2.getStr() + player2.getDex() + player2.getWis();
                break;
            default:
                System.out.println("error");
        }
        int player2dmg = Skill.OffendDamage(p2skill,p2status);
        System.out.println(player2.getCharname() + " " + p2skill + " " + player1.getCharname() + " for " + player2dmg + " damage");
        player1.hp -= player2dmg;
        System.out.println("==============");
        System.out.println(player1.getCharname() + " now has " + player1.hp + " hp");
        System.out.println("==============");
    }
*/
