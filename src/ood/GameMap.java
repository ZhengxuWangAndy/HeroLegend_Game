package ood;

import java.util.ArrayList;
import java.util.Collections;

/*
* The game's map extends from ood.Board and contains cell.
* */

public class GameMap extends Board{


    ArrayList<String> arrange = new ArrayList<>();
    ColorfulOutput color = new ColorfulOutput();

    public GameMap(int width, int height) {
        super(width, height);

        for(int i = 0; i < width*height; i++){
            if(i <= Math.ceil(width*height*0.2)){
                arrange.add(" X ");
            } else if (i > Math.ceil(width*height*0.2) && i <= Math.ceil(width*height*0.5)) {
                arrange.add(" M ");
            }else {
                arrange.add("   ");
            }
        }
    }

    public void shuffleMap(){
        Collections.shuffle(arrange);

        for(int i = 0; i < this.getHeight(); i++){
            for(int j = 0; j < this.getWidth(); j++){
                HeroLegendCell cell = new HeroLegendCell();
                if (i == 0 && j == 0) {
                    cell.setPos(i,j);
                    cell.setSymbol(color.yellowBG(" H "));
                    cell.setStatus("   ");
                    this.board[i][j] = cell;

                } else if(arrange.get(i*getWidth() + j).equals(" X ")){
                    cell.setPos(i,j);
                    cell.setSymbol(color.redBG(arrange.get(i*getWidth() + j)));
                    cell.setStatus(" X ");
                    this.board[i][j] = cell;

                } else if (arrange.get(i*getWidth() + j).equals(" M ")) {
                    cell.setPos(i,j);
                    cell.setSymbol(color.purpleBG(arrange.get(i*getWidth() + j)));
                    cell.setStatus(" M ");
                    this.board[i][j] = cell;

                }else {
                    cell.setPos(i, j);
                    cell.setSymbol(arrange.get(i * getWidth() + j));
                    cell.setStatus("   ");
                    this.board[i][j] = cell;
                }
            }
        }
    }

    public void printMap(){

        for(int i = 0; i < 2*getHeight()+1; i++){
            for(int j = 0; j < 2*getWidth()+1; j++){
                if(i%2 == 0){
                    if (j != 0) {
                        System.out.printf("--");
                    }else {
                        System.out.printf("-");
                    }
                }
                else if(j%2 == 0){
                    System.out.printf("|");
                }
                else {
                    System.out.printf(board[Math.floorDiv(i,2)][Math.floorDiv(j,2)].getSymbol());
                }
            }
            System.out.println("");
        }
    }

    public Boolean move(String move,HerosTeam hero){
        int i = hero.getTeamPos_i();
        int j = hero.getTeamPos_j();
        int new_i = i;
        int new_j = j;
        switch (move){
            case "a":
                if (j < 1){
                    return false;
                }else {
                    new_j = j - 1;
                }
                break;

            case "w":
                if (i < 1){
                    return false;
                }else {
                    new_i = i - 1;
                }
                break;


            case "d":
                if (j >= getHeight() - 1){
                    return false;
                }else {
                    new_j = j + 1;
                }
                break;

            case "s":
                if (i >= getWidth() - 1){
                    return false;
                }else {
                    new_i = i + 1;
                }
                break;

            case "i":
                hero.printAllMembers();
                return false;
        }

        if (board[new_i][new_j].getStatus().equals(" X ")){
            return false;
        }
        else if (board[new_i][new_j].getStatus().equals("   ")){
            //roll a dice to battle

            //move to new place, print map
            board[new_i][new_j].setSymbol(color.yellowBG(" H "));
            hero.setTeamPos_i(new_i);
            hero.setTeamPos_j(new_j);
            //change origin place
            board[i][j].setSymbol(board[i][j].getStatus());


        }else if(board[new_i][new_j].getStatus().equals(" M ")){
            //start market situation

            //move to new place, print map
            board[new_i][new_j].setSymbol(color.yellowBG(" H "));
            hero.setTeamPos_i(new_i);
            hero.setTeamPos_j(new_j);
            //change origin place
            board[i][j].setSymbol(board[i][j].getStatus());
        }
        return true;
    }


    public String getCurrentPosStatus(int i, int j){
        return this.board[i][j].getStatus();
    }

}
