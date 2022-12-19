package ood;/*
* Process the whole game's process.
*
* */

public class Processor {

    public Processor() {


        int teamMemberCount = 0;

        // input and output class
        InputCheck inputCheck = new InputCheck();
        ColorfulOutput colorOut = new ColorfulOutput();

        // hero team
        HerosTeam herosTeam = new HerosTeam();



        colorOut.purpleOut(" _     _                      ___      _                                 _ \n" +
                "| |   | |                    / _ \\    | |                               | |\n" +
                "| |__ | | ____  ____ ___    ( (_) )   | |      ____ ____  ____ ____   _ | |\n" +
                "|  __)| |/ _  )/ ___) _ \\    ) _ (    | |     / _  ) _  |/ _  )  _ \\ / || |\n" +
                "| |   | ( (/ /| |  | |_| |  ( (/  \\   | |____( (/ ( ( | ( (/ /| | | ( (_| |\n" +
                "|_|   |_|\\____)_|   \\___/    \\__/\\_)  |_______)____)_|| |\\____)_| |_|\\____|\n" +
                "                                                  (_____|                  ");
        colorOut.blueOut("Welcome to the game!\t\tAuthor: Zhengxu Wang\n");
        colorOut.redOut("During the game process, whenever you input q, means quit game.");

        // init map
        GameMap gameMap = new GameMap(8,8);

        // move controller
        Controller controller = new Controller();


        teamMemberCount = herosTeam.selectMember();
        herosTeam.printAllMembers();

        Boolean validMap = false;
        while (!validMap) {
            gameMap.shuffleMap();
            gameMap.printMap();
            System.out.println(colorOut.yellowBG(" H ") + " means Heroes");
            System.out.println(colorOut.redBG(" X ") + " means obstacle");
            System.out.println(colorOut.purpleBG(" H ") + " means Market (when you been to a market it will have no BG color for helps you explore)");
            System.out.println("    Blank means you can go there but has some chance encounter monsters.");
            colorOut.cyanOut("Is that a reasonable map?(input Y to accept, other means reshuffle)");

            if(inputCheck.getInput().equals("Y")){
                validMap = true;
            }
        }


        while (true) {
            //move hero team
            gameMap.printMap();
            Boolean validMove = false;
            while (!validMove) {
                validMove = gameMap.move(controller.move(), herosTeam);
            }
            gameMap.printMap();

            int i = herosTeam.getTeamPos_i();
            int j = herosTeam.getTeamPos_j();
            String currStatus = gameMap.getCurrentPosStatus(i, j);
            if(currStatus.equals(" M ")){
                String userIn = "m";
                while (userIn.equals("M") || userIn.equals("m")) {
                    colorOut.yellowOut("Do you want to trade?(only M/m is to get in market, other continue to move)");
                    userIn = inputCheck.getInput();
                    if (userIn.equals("M") || userIn.equals("m")) {

                        // select which hero to trade
                        herosTeam.printAllMembers();
                        colorOut.purpleOut("Which hero wants to trade? (choose the serial)");

                        Hero currRole = (Hero) herosTeam.getRole_prompt();
                        colorOut.blueOut("Hello " + currRole.getName());

                        Market market;
                        // first time arrive
                        if (gameMap.board[i][j].getContent() == null) {
                            market = new Market();
                        } else {
                            // come again
                            market = gameMap.board[i][j].getContent();
                        }

                        int marketSelect = -1;
                        while (!inputCheck.checkInt(marketSelect, 0, 2)) {
                            colorOut.purpleOut("Do you wanna 1:buy 2:sell 0:passing by (input the serial number)");
                            marketSelect = inputCheck.getInt(inputCheck.getInput());
                        }
                        if (marketSelect == 1) {
                            market.buy(currRole);
                        } else if (marketSelect == 2) {
                            market.sell(currRole);
                        }
                        gameMap.board[i][j].setContent(market);
                    }
                }

            }
            else if (currStatus.equals("   ")) {
                MonsterTeam monsterTeam = new MonsterTeam(teamMemberCount);
                Battle battle = new Battle<>(monsterTeam,herosTeam);
                if (battle.possibility(0.5)){
                    System.out.println(colorOut.redBG(" !! ENCOUNTER MONSTERS !! "));
                    battle.start();
                }else{
                    colorOut.blueOut("SAFE");
                }


            }

        }




    }
}
