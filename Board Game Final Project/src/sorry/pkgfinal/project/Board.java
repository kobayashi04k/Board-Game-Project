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
public class Board {
    private Player[] allPlayers = new Player[2];
    private int diceRoll;
    private int playerTurn;
    private Battle battle;
    private int totalUpgradeCost;
    private int enemyNum;
    private Piece pieceOne;
    private Piece pieceTwo;
    
    public Board(String nameOne, String nameTwo){
        allPlayers[0] = new Player(nameOne, 0);
        allPlayers[1] = new Player(nameTwo, 1);
        playerTurn = 0;
    }
    
    //adds to the total cost for upgrades
    public void updateTotalUpgradeCost(int cost){
        totalUpgradeCost+=cost;
    }
    
    //gets the total oost for upgrades
    public int getTotalUpgradeCost(){
        return totalUpgradeCost;
    }
    
    //add gold to the player's gold for moving one spot
    public void moveGainGold(){
        allPlayers[playerTurn].updateGold(diceRoll*5);
    }
    
    //checks if a player passed an enemy
    public boolean checkForPass(int pieceNum){
        int enemyTurn;
        //int dice;
        if(playerTurn == 0){
            enemyTurn = 1;
            for(int i = 0; i < 4; i++){
            if(allPlayers[playerTurn].getPieces()[pieceNum].getPosition() <= allPlayers[enemyTurn].getPieces()[i].getPosition() 
                    && allPlayers[playerTurn].getPieces()[pieceNum].getPosition() + diceRoll >= allPlayers[enemyTurn].getPieces()[i].getPosition()){
                enemyNum = i;
                pieceOne = allPlayers[playerTurn].getPieces()[pieceNum];
                pieceTwo = allPlayers[enemyTurn].getPieces()[i];
                return true;
            }
            }
        }
        else{
            enemyTurn = 0;
            for(int i = 0; i < 4; i++){
            if(allPlayers[playerTurn].getPieces()[pieceNum].getPosition() >= allPlayers[enemyTurn].getPieces()[i].getPosition() 
                    && allPlayers[playerTurn].getPieces()[pieceNum].getPosition() - diceRoll <= allPlayers[enemyTurn].getPieces()[i].getPosition()){
                enemyNum = i;
                pieceOne = allPlayers[enemyTurn].getPieces()[i];
                pieceTwo = allPlayers[playerTurn].getPieces()[pieceNum];
                        
                        
                return true;
            }
            }
        }
        
        

        return false;
    }
    
    //gets player one's piece that engaged in battle
    public Piece getPieceOne(){
        return pieceOne;
    }
    
    //gets player two's piece that engaged in battle
    public Piece getPieceTwo(){
        return pieceTwo;
    }
    
    //generates a random number between 1-6
    public void rollDice(){
        diceRoll = (int)(Math.random()*6 + 1);
        //diceRoll = 6;
    }
    
    //gets the value of the dice roll
    public int getDiceRoll(){
        return diceRoll;
    }
    
    //moves the piece on the board
    public void updatePiecePosition(int pieceNum){
        allPlayers[playerTurn].getPieces()[pieceNum].updatePosition(diceRoll,playerTurn);
    }
    
    //checks if the player has passed the end
    public void returnStart(int pieceNum){
        allPlayers[playerTurn].getPieces()[pieceNum].returnToStart(playerTurn); 
    }
    
    //gets the players
    public Player[] getPlayers(){
        return allPlayers;
    }
    
    //checks if the player got into the enemy base
    public void checkPieceInEnemyBase(int pieceNum){
        if(allPlayers[0].getPieces()[pieceNum].getPosition() >= 35){
            allPlayers[1].loseHealth();
        }
        else if(allPlayers[1].getPieces()[pieceNum].getPosition() <= 0){
            allPlayers[0].loseHealth();
        }
    }
    
    
    //changes the player turn
    public void changeTurn(){
        if(playerTurn == 0){
            playerTurn = 1;
        }
        else{
            playerTurn = 0;
        }
    }
    
    //gets the current turn
    public int getPlayerTurn(){
        return playerTurn;
    }
}
