package gra;

import images.ImageFactory;
import model.Sprite;
import model.Tower;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {

    private int playerHp;
    private int buyBaloon;
    private List<Sprite> baloonList;
    private List<Tower> towerList;

    public GameState(int playerHp, List<Sprite> baloonList, List<Tower> towerList, int buyBaloon){

        this.playerHp = playerHp;
        this.baloonList = baloonList;
        this.towerList = towerList;
        this.buyBaloon = buyBaloon;
    }

    public void addOfset(){

        for(Sprite baloon : this.baloonList) {
            baloon.setX(baloon.getX() + 650);
        }

        for(Tower tower : this.towerList) {
            tower.setX(tower.getX() + 650);
        }
    }

    public int getPlayerHp(){
       return this.playerHp;
    }

    public List<Sprite> getBaloonList() {
        return baloonList;
    }

    public List<Tower> getTowerList() {
        return towerList;
    }

    public int getBuyBaloon() {
        return buyBaloon;
    }
}
