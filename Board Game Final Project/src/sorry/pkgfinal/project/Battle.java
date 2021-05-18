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
public class Battle {
    
    private Piece battleOnePiece;
    private Piece battleTwoPiece;
    private int loser;
    private int playerTurn;
    private int overallTurn;
    private int diceRoll;
    private boolean[] choseAttack =  new boolean[2];
    private boolean[] choseDefense = new boolean[2];
    private int defMulOne = 1;
    private int defMulTwo = 1;
    private int numRounds = 0;
    private int damage;
    
    public Battle(Piece pOne, Piece pTwo){
        battleOnePiece = pOne;
        battleTwoPiece = pTwo;
        playerTurn = overallTurn = (int)(Math.random()*2);
        for(int i = 0; i < 2; i++){
            choseAttack[i] = false;
            choseDefense[i] = false;
        }
    }
    
    //changes the overall turn
    public void changeOverallTurn(){
        if(overallTurn == 0){
            overallTurn = 1;
            playerTurn = 1;
        }
        else{
            overallTurn = 0;
            playerTurn = 0;
        }
    }
    
    //get choseAttack[0]
    public boolean getChoseAttackOne(){
        return choseAttack[0];
    }
    
    //get choseAttack[1]
    public boolean getChoseAttackTwo(){
        return choseAttack[1];
    }
    
    //get choseDefense[0]
    public boolean getChoseDefenseOne(){
        return choseDefense[0];
    }
    
    //get choseDefense[1]
    public boolean getChoseDefenseTwo(){
        return choseDefense[1];
    }
    
    //changes the player turn
    public void changePlayerTurn(){
        if(playerTurn == 0){
            playerTurn = 1;
        }
        else{
            playerTurn = 0;
        }
    }
    
    //adds 1 to the number of rounds
    public void addNumRounds(){
        numRounds++;
    }
    
    //gets the number of rounds
    public int getRounds(){
        return numRounds;
    }
    
    //gets player one's piece
    public Piece getPieceOne(){
        return battleOnePiece;
    }
    
    //gets the overall turn
    public int getOverallTurn(){
        return overallTurn;
    }
    
    //gets player two's piece
    public Piece getPieceTwo(){
        return battleTwoPiece;
    }
    
    //gets the number of which player lost
    public int getLoser(){
        return loser;
    }
    
    //gets the current turn
    public int getTurn(){
        return playerTurn;
    }
    
    //gets the value of the dice roll
    public int getDiceRoll(){
        return diceRoll;
    }
    
    //set attack and defend booleans to false
    public void resetBattle(){
        if(numRounds >= 4 || (choseDefense[0] && choseDefense[1]) || (numRounds > 2 && (choseDefense[0] || choseDefense[1]))){
            choseAttack[0] = false;
            choseAttack[1] = false;
            choseDefense[0] = false;
            choseDefense[1] = false;
            numRounds = 0;
            changePlayerTurn();
        }
    }
    
    //player one attacks
    public void playerOneAttacks(){
        if(!choseAttack[0]){
            choseAttack[0] = true;
            addNumRounds();
        }
        else if(choseAttack[0]){
            
            if(battleOnePiece.getIsPoisoned()){
                battleOnePiece.updateHP(-5);
            }
            
            
            if(battleOnePiece.getUnlockedAbility() && battleOnePiece.getAbility().equals("Poison Attack")){
                battleTwoPiece.setPoisoned(true);               
            }

            if(battleOnePiece.getUnlockedAbility() && battleOnePiece.getAbility().equals("Lucky Dice")){
                damage = (battleOnePiece.getAttack()/(battleTwoPiece.getDefense()*defMulTwo)) + (diceRoll*2);
            }
            else{
                damage = (battleOnePiece.getAttack()/(battleTwoPiece.getDefense()*defMulTwo)) + diceRoll;
            }
            
            
            battleTwoPiece.updateHP(-1*damage);
            defMulTwo = 1;
            addNumRounds();
            if(choseDefense[1]){
                addNumRounds();
            }

        }
        
        resetBattle();
    }
    
    //gets the amount of damage dealt
    public int getDamage(){
        return damage;
    }
    
    //player two attacks
    public void playerTwoAttacks(){
        if(!choseAttack[1]){
            choseAttack[1] = true;
            addNumRounds();
        }
        else if(choseAttack[1]){
            
            if(battleTwoPiece.getIsPoisoned()){
                battleTwoPiece.updateHP(-5);
            }
         
            
            if(battleTwoPiece.getUnlockedAbility() && battleTwoPiece.getAbility().equals("Poison Attack")){
                battleOnePiece.setPoisoned(true);
            }
            
            if(battleTwoPiece.getUnlockedAbility() && battleTwoPiece.getAbility().equals("Lucky Dice")){
                damage = (battleTwoPiece.getAttack()/(battleOnePiece.getDefense()*defMulTwo)) + (diceRoll*2);
            }
            else{
                damage = (battleTwoPiece.getAttack()/(battleOnePiece.getDefense()*defMulTwo)) + diceRoll;
            }
            
            
            battleOnePiece.updateHP(-1*damage);   
            defMulOne = 1;
            addNumRounds();
            if(choseDefense[0]){
                addNumRounds();
            }
            
        }
        
        resetBattle();
    }
    
    //player one defends
    public void playerOneDefends(){
        if(!choseDefense[0]){
            choseDefense[0] = true;
            addNumRounds();
            defMulOne = 2;
        }
        else if(choseDefense[0]);
        
        resetBattle();
    }
    
    //player two defends
    public void playerTwoDefends(){
        if(!choseDefense[1]){
            choseDefense[1] = true;
            addNumRounds();
            defMulTwo = 2;
        }
        
        resetBattle();
    }
    
    //rolls a dice(generate random number between 1 and 6)
    public void rollDice(){
        diceRoll = (int)(Math.random()*6) + 1;
    }
    
    //checks which player one
    public boolean checkWinner(){
        if(battleOnePiece.getHP() <= 0){
            loser = 0;
            return true;
        }
        else if(battleTwoPiece.getHP() <= 0){
            loser = 1;
            return true;
        }
        
        return false;
    }
    
    //checks if the player's piece has the ability: Poison
    public void checkPoison(){
        
    }
    
    //checks if the player's piece has the ability: Last Resort
    public void checkLastResort(){
        
    }
    
}
