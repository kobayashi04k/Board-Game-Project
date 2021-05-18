/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorry.pkgfinal.project;

/**
 *
 * @author kobayashi1254
 */
public class Player {
    
    private String name;
    private int gold;
    private boolean selectedPiece;
    private Piece[] allPieces = new Piece[4];
    private boolean unlockedAbility;
    private int health;
    
    public Player(String tempName, int playerNum){
        gold = 100;
        name = tempName;
        health = 3;
        //initialize four pieces
        if(playerNum == 0){
            allPieces[0] = new Piece(0,"resources/redcircle.png","Upgrade Sale","Upgrade Costs Reduced By Half",0);
            allPieces[1] = new Piece(0,"resources/redsquare.png","Poison Attack","Deal Poison Damage on Hit",1);
            allPieces[2] = new Piece(0,"resources/redtriangle.png","Last Resort","Bring Enemy Down with You",2);
            allPieces[3] = new Piece(0,"resources/redkite.png","Lucky Dice","Doubles Dice Value in Battle",3);
        }
        if(playerNum == 1){
            allPieces[0] = new Piece(35,"resources/bluecircle.png","Upgrade Sale","Upgrade Costs Reduced By Half",0);
            allPieces[1] = new Piece(35,"resources/bluesquare.png","Poison Attack","Deal Poison Damage on Hit",1);
            allPieces[2] = new Piece(35,"resources/bluetriangle.png","Last Resort","Bring Enemy Down with You",2);
            allPieces[3] = new Piece(35,"resources/bluekite.png","Lucky Dice","Doubles Dice Value in Battle",3);
        }
        
    }
    
    
    //gets the player's name
    public String getName(){
        return name;
    }
    
    //gets the player's gold
    public int getGold(){
        return gold;
    }
    
    //gets the boolean 'selectedPiece'
    public boolean getSelectedPiece(){
        return selectedPiece;
    }
    
    //gets the player's pieces
    public Piece[] getPieces(){
        return allPieces;
    }
    
    //gets the boolean 'unlockedAbility'
    public boolean getUnlockedAbility(){
        return unlockedAbility;
    }
    
    //gets the player's health
    public int getHealth(){
        return health;
    }
    
    //updates the number of gold coins 
    public void updateGold(int num){
        gold+=num;
    }
    
    //sets selectedPiece to the parameter
    public void setSelecteddPiece(boolean x){
        selectedPiece = x;
    }
    
    //sets unlockedAbility to the parameter
    public void setUnlockedAbility(boolean x){
        unlockedAbility = x;
    }
    
    //subtracts the player's health by 1
    public void loseHealth(){
        health--;
    }
    
}
