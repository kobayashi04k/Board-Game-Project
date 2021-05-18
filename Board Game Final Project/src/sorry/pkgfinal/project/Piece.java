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
public class Piece {
    
    private int hp;
    private int attack;
    private int defense;
    private int position;
    private String imagePath;
    private String ability;
    private String abilityDescription;
    private boolean unlockedAbility;
    private int upgradeHP = 0;
    private int upgradeAttack = 0;
    private int upgradeDefense = 0;
    private int totalUpgradeCost = 0;
    private int maxHP;
    private int pieceNum;
    private boolean isPoisoned;
    
    public Piece(int startPosition, String imageName, String tempAbility, String tempDescription, int num){
        hp = 15;
        maxHP = 15;
        attack = 10;
        defense = 10;
        position = startPosition;
        imagePath = imageName;
        ability = tempAbility;
        abilityDescription = tempDescription;
        pieceNum = num;
    }
    
    //sets the boolean isPoisoned
    public void setPoisoned(boolean x){
        isPoisoned = x;
    }
    
    //gets the boolean isPoisoned
    public boolean getIsPoisoned(){
        return isPoisoned;
    }
    
    //gets the piece's num
    public int getPieceNum(){
        return pieceNum;
    }
    
    //sets the upgrade numbers to zero
    public void resetUpgradeNumbers(){
        upgradeAttack = 0;
        upgradeDefense = 0;
        upgradeHP = 0;
        totalUpgradeCost = 0;
    }
    
    //tracks how much the player wants to increases/decreases a piece's attack by
    public void  upgradeAttackNum(int num){
        upgradeAttack+=num;
    }
    
    //gets the amount the user wants to upgrade the attack stat
    public int getUpgradeAttack(){
        return upgradeAttack;
    }
    
    //tracks how much the player wants to increases/decreases a piece's defense by
    public void upgradeDefenseNum(int num){
        upgradeDefense+=num;
    }
    
    //gets the amount the user wants to upgrade the defense stat
    public int getUpgradeDefense(){
        return upgradeDefense;
    }
    
    //tracks how much the player wans to increase/decrease a piece's hp by
    public void upgradeHPNum(int num){
        upgradeHP+=num;
    }
    
    //upgrades the piece's max hp
    public void upgradeMaxHP(int num){
        maxHP+=num;
    }
    
    //sets the unlockedAbility boolean to true
    public void setUnlockedAbility(){
        unlockedAbility = true;
    }
    
    //gets the amount the user wants to upgrade the hp stat
    public int getUpgradeHP(){
        return upgradeHP;
    }
    
    //updates total cost for upgrades
    public void upgradeTotalUpgradeCost(int num){
        totalUpgradeCost+=num;
    }
    
    //gets the boolean for if the ability is unlocked
    public boolean getUnlockedAbility(){
        return unlockedAbility;
    }
    
    //gets the piece's max hp
    public int getMaxHP(){
        return maxHP;
    }
    
    //gets the piece's currrent hp
    public int getHP(){
        return hp;
    }
    
    //gets the piece's attack stat
    public int getAttack(){
        return attack;
    }
    
    //gets the piece's defense stat
    public int getDefense(){
        return defense;
    }
    
    //gets the piece's position on the board
    public int getPosition(){
        return position;
    }
    
    //gets the total cost to upgrade the piece
    public int getTotalUpgradeCost(){
        return totalUpgradeCost;
    }
    
    //gets the piece's ability
    public String getAbility(){
        return ability;
    }
    
    //gets the ability's description
    public String getAbilityDescription(){
        return abilityDescription;
    }
    
    //gets the piece's previous position
    public int getPreviousPosition(int diceRoll,int playerNum){
        if(playerNum == 0){
            return (position - diceRoll);
        }
        return (position + diceRoll);
    }
    
    //gets the piece's image name
    public String getImagePath(){
        return imagePath;
    }
    
    //restores the piece's hp
    public void restoreHP(){
        hp = maxHP;
    }
    
    //updates hp
    public void updateHP(int num){
        hp+=num;
    }
    
    //update attack
    public void updateAttack(int num){
        attack+=num;
    }
    
    //updates defense
    public void updateDefense(int num){
        defense+=num;
    }
    
    //updates position
    public void updatePosition(int roll, int playerNum){
        if(playerNum == 0){
            position+=roll;
            if(position > 35){
                position = 35;
            }
        }
        else{
            position-=roll;
            if(position < 0){
                position = 0;
            }
        }
        
    }
    
    //returns the player back to start after they lost the battle
    public void sendBackToStart(int playerNum){
        if(playerNum == 0){
            position = 0;
        }
        if(playerNum == 1){
            position = 35;
        }
    }
    
    //returns the piece back to start
    public void returnToStart(int playerNum){
        if(playerNum == 0 && position == 35){
            position = 0;
        }
        if(playerNum == 1 && position == 0){
            position = 35;
        }
    }
    
   
}
