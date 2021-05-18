/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorry.pkgfinal.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author kobayashi1254
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label lblError;
    @FXML
    private Label lblProfileHP,lblProfileAttack,lblProfileDefense,lblProfileAbility;
    @FXML
    private Label lblTotalCost;
    @FXML
    private ImageView imgProfilePicture;
    @FXML
    private ImageView imgBorderBorder;
    @FXML
    private Label lblProfileAbilityDescription;
    @FXML
    private Label[] playerGold = new Label[2];
    @FXML
    private ImageView imgDice,imgBattleDice;
    @FXML
    private ImageView imgX2One,imgX2Two,imgPoisonOne,imgPoisonTwo,imgLuckyDice;
    @FXML
    private Label lblPlayerTurn;
    @FXML
    private Label lblPlayerOneGold,lblPlayerTwoGold,P1Gold,P2Gold;
    @FXML
    private Label lblBattleHPOne,lblBattleAttackOne,lblBattleDefenseOne;
    @FXML
    private Label lblBattlePlayerTurn,lblBattlePlayerDamage;
    @FXML
    private Label lblBattleHPTwo,lblBattleAttackTwo,lblBattleDefenseTwo;
    private Label[][] battleLabels = new Label[2][3];
    @FXML
    private ImageView imgP1Heart1,imgP1Heart2,imgP1Heart3;
    @FXML
    private ImageView imgP2Heart1,imgP2Heart2,imgP2Heart3;
    
    @FXML
    private ImageView imgRC0,imgRC1,imgRC2,imgRC3,imgRC4,imgRC5,imgRC6,imgRC7,imgRC8,imgRC9,imgRC10,imgRC11,imgRC12,imgRC13,imgRC14,imgRC15
            ,imgRC16,imgRC17,imgRC18,imgRC19,imgRC20,imgRC21,imgRC22,imgRC23,imgRC24,imgRC25,imgRC26,imgRC27,imgRC28,imgRC29,imgRC30,imgRC31,imgRC32,imgRC33,imgRC34,imgRC35;
    @FXML
    private ImageView imgRS0,imgRS1,imgRS2,imgRS3,imgRS4,imgRS5,imgRS6,imgRS7,imgRS8,imgRS9,imgRS10,imgRS11,imgRS12,imgRS13,imgRS14,imgRS15
            ,imgRS16,imgRS17,imgRS18,imgRS19,imgRS20,imgRS21,imgRS22,imgRS23,imgRS24,imgRS25,imgRS26,imgRS27,imgRS28,imgRS29,imgRS30,imgRS31,imgRS32,imgRS33,imgRS34,imgRS35;
    
    @FXML
    private ImageView imgRT0,imgRT1,imgRT2,imgRT3,imgRT4,imgRT5,imgRT6,imgRT7,imgRT8,imgRT9,imgRT10,imgRT11,imgRT12,imgRT13,imgRT14,imgRT15
            ,imgRT16,imgRT17,imgRT18,imgRT19,imgRT20,imgRT21,imgRT22,imgRT23,imgRT24,imgRT25,imgRT26,imgRT27,imgRT28,imgRT29,imgRT30,imgRT31,imgRT32,imgRT33,imgRT34,imgRT35;
    
    @FXML
    private ImageView imgRK0,imgRK1,imgRK2,imgRK3,imgRK4,imgRK5,imgRK6,imgRK7,imgRK8,imgRK9,imgRK10,imgRK11,imgRK12,imgRK13,imgRK14,imgRK15
            ,imgRK16,imgRK17,imgRK18,imgRK19,imgRK20,imgRK21,imgRK22,imgRK23,imgRK24,imgRK25,imgRK26,imgRK27,imgRK28,imgRK29,imgRK30,imgRK31,imgRK32,imgRK33,imgRK34,imgRK35;
    
    @FXML
    private ImageView imgRedCircle,imgRedSquare,imgRedTriangle,imgRedKite;
    
    @FXML
    private ImageView imgBlueCircle,imgBlueSquare,imgBlueTriangle,imgBlueKite;
    
    @FXML
    private ImageView imgBattlePieceOne,imgBattlePieceTwo;
    
    @FXML
    private Button btnMove,btnRoll;
    @FXML
    private Button btnReturn;
    @FXML
    private Button btnBattleDice;
    @FXML
    private Button btnMainMenu;
    @FXML
    private Label lblBio;
    @FXML
    private Button btnAttackOne,btnAttackTwo,btnDefenseOne,btnDefenseTwo;
    private Button[] attackButtons =  new Button[2];
    private Button[] defenseButtons = new Button[2];
    @FXML
    private Button btnDecreaseHP,btnIncreaseHP,btnDecreaseAttack,btnIncreaseAttack,btnDecreaseDefense,btnIncreaseDefense,btnUnlockAbility,btnApply;
    
    private ImageView[][] boardPieces = new ImageView[36][4];
    
    private ImageView[][] heartImages = new ImageView[2][3];
    private String[] diceImages = new String[6];
    private Label[] goldLabels = new Label[2];
    private ImageView[][][] pieceImages = new ImageView[2][4][36];
    
    @FXML
    private Rectangle rectBlue,rectMainMenu,rectHowToPlay;
    
    @FXML
    private AnchorPane anchorPaneBattle,anchorPaneMainMenu,anchorPaneHowToPlay;
    @FXML
    private ImageView imgBorder;
    
    private Board board;
    private int pieceNum = 4;
    private int turn;
    private Battle battle;
    
    @FXML
    private void handlePoisonAttack(ActionEvent event){
        lblBio.setText("Inflict poison upon an enemy on hit. Enemy loses HP after every attack.");
    }
    
    @FXML
    private void handleUpgradeSale(ActionEvent event){
        lblBio.setText("All stat upgrades on the piece are reduced to half their original costs.");
    }
    
    @FXML
    private void handleLuckyDice(ActionEvent event){
        lblBio.setText("Double the value of the dice roll during the battle to gain more damage.");
    }
    
    @FXML
    private void handleLastResort(ActionEvent event){
        lblBio.setText("When the user's piece is taken down, the enemy's piece will be taken down.");
    }
    
    @FXML
    private void handleStartGame(ActionEvent event){
        
        rectMainMenu.setVisible(false);
        rectHowToPlay.setVisible(false);
        anchorPaneMainMenu.setVisible(false);
        anchorPaneHowToPlay.setVisible(false);
    }
    
    @FXML
    private void handleHowToPlay(ActionEvent event){
        rectMainMenu.setVisible(false);
        
        anchorPaneMainMenu.setVisible(false);
        anchorPaneHowToPlay.setVisible(true);
        rectHowToPlay.setVisible(true);
    }
    
    @FXML
    private void handleMainMenu(ActionEvent event){
        anchorPaneMainMenu.setVisible(true);
        anchorPaneHowToPlay.setVisible(true);
        rectMainMenu.setVisible(true);
        rectHowToPlay.setVisible(true);
        
    }
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handleReturnToBoard(ActionEvent event){
        rectBlue.setVisible(false);
        anchorPaneBattle.setVisible(false);
        imgBattleDice.setImage(null);
        imgPoisonOne.setImage(null);
        imgPoisonTwo.setImage(null);
        imgX2One.setImage(null);
        imgX2Two.setImage(null);
        imgLuckyDice.setImage(null);
        btnReturn.setVisible(false);
        lblBattlePlayerDamage.setText("");
        lblBattlePlayerTurn.setText("");
        if(battle.getLoser() == 0){
            int piece = battle.getPieceOne().getPieceNum();
            if(turn == 0){
                //board.changeTurn();
                turn = board.getPlayerTurn();
                lblPlayerTurn.setText(board.getPlayers()[turn].getName() + "'s Turn");
                //System.out.println("1");
            }
            else{
                //board.changeTurn();
                turn = board.getPlayerTurn();
                lblPlayerTurn.setText(board.getPlayers()[turn].getName() + "'s Turn");                
                //System.out.println("2");
            }
            clearBoard();
            board.getPlayers()[0].getPieces()[piece].sendBackToStart(0);   
            if(battle.getPieceOne().getUnlockedAbility() && battle.getPieceOne().getAbility().equals("Last Resort")){
                board.getPlayers()[1].getPieces()[battle.getPieceTwo().getPieceNum()].sendBackToStart(1);
            }
            placePieces();
            board.getPlayers()[0].getPieces()[piece].restoreHP();
        }
        else{
            int piece = battle.getPieceTwo().getPieceNum();
            if(turn == 0){
                //board.changeTurn();
                turn = board.getPlayerTurn();
                lblPlayerTurn.setText(board.getPlayers()[turn].getName() + "'s Turn");
                //System.out.println("3");
            }
            else{
                //board.changeTurn();
                turn = board.getPlayerTurn();
                lblPlayerTurn.setText(board.getPlayers()[turn].getName() + "'s Turn");
               //System.out.println("4");
            }
            clearBoard();
            board.getPlayers()[1].getPieces()[piece].sendBackToStart(1);
            if(battle.getPieceTwo().getUnlockedAbility() && battle.getPieceTwo().getAbility().equals("Last Resort")){
                board.getPlayers()[0].getPieces()[battle.getPieceOne().getPieceNum()].sendBackToStart(0);
            }
            placePieces();
            System.out.println(board.getPlayers()[1].getPieces()[piece].getPosition());
            board.getPlayers()[1].getPieces()[piece].restoreHP();
        }
        
        
        

    }
    
    @FXML
    private void handleBattleRoll(ActionEvent event){
        battle.rollDice();
        imgBattleDice.setImage(new Image(diceImages[battle.getDiceRoll() - 1]));
        if(battle.getTurn() == 0){
            battle.playerOneAttacks();
            lblBattlePlayerDamage.setText(board.getPlayers()[0].getName() + " Dealt " + battle.getDamage() + " Damage");
            displayBattleStats();
            battle.changePlayerTurn();
            imgX2Two.setImage(null);
            battleButtons();
        }
        else{
            battle.playerTwoAttacks();
            lblBattlePlayerDamage.setText(board.getPlayers()[1].getName() + " Dealt " + battle.getDamage() + " Damage");
            displayBattleStats();
            battle.changePlayerTurn();
            imgX2One.setImage(null);
            battleButtons();
        }
        btnBattleDice.setDisable(true);
        if(battle.checkWinner()){
            attackButtons[0].setDisable(true);
            attackButtons[1].setDisable(true);
            defenseButtons[0].setDisable(true);
            defenseButtons[1].setDisable(true);
            lblBattlePlayerTurn.setText(board.getPlayers()[battle.getLoser()].getName() + " has Lost");
            btnReturn.setVisible(true);
        }
    }
    
    @FXML
    private void handleAttackOne(ActionEvent event){
        if(battle.getChoseAttackOne()){
            lblBattlePlayerDamage.setText("Roll The Die To Add Damage");
            if(battle.getPieceTwo().getUnlockedAbility() && battle.getPieceTwo().getAbility().equals("Lucky Dice")){
                imgLuckyDice.setImage(new Image("resources/luckydice.jpg"));
            }
            checkBattleDie();

        }
        else{
            lblBattlePlayerDamage.setText(board.getPlayers()[battle.getTurn()].getName() +  " chose to Attack");
            battle.playerOneAttacks();
            battle.changePlayerTurn();
            battleButtons();
        }

        displayBattleStats();
        imgBattleDice.setImage(null);
        if(battle.checkWinner()){
            attackButtons[0].setDisable(true);
            attackButtons[1].setDisable(true);
            defenseButtons[0].setDisable(true);
            defenseButtons[1].setDisable(true);
            btnReturn.setVisible(true);
        }
        //battleButtons();
        //checkBattleDie();
    }
    
    @FXML
    private void handleAttackTwo(ActionEvent event){
        if(battle.getChoseAttackTwo()){
            lblBattlePlayerDamage.setText("Roll Die To Add Damage");
            if(battle.getPieceTwo().getUnlockedAbility() && battle.getPieceTwo().getAbility().equals("Lucky Dice")){
                imgLuckyDice.setImage(new Image("resources/luckydice.jpg"));
            }
            checkBattleDie();
            
        }
        else{
            lblBattlePlayerDamage.setText(board.getPlayers()[battle.getTurn()].getName() +  " chose to Attack");
            battle.playerTwoAttacks();
            battle.changePlayerTurn();
            battleButtons();
        }

        displayBattleStats();
        imgBattleDice.setImage(null);
        if(battle.checkWinner()){
            attackButtons[0].setDisable(true);
            attackButtons[1].setDisable(true);
            defenseButtons[0].setDisable(true);
            defenseButtons[1].setDisable(true);
            btnReturn.setVisible(true);
        }

    }
    
    @FXML
    private void handleDefenseOne(ActionEvent event){
        if(battle.getChoseDefenseOne()){
            lblBattlePlayerDamage.setText(board.getPlayers()[battle.getTurn()].getName() + " Cannot Defend Consecutively");
        }
        else{
            lblBattlePlayerDamage.setText(board.getPlayers()[battle.getTurn()].getName() +  " chose to Defend");
            battle.playerOneDefends();
            battle.changePlayerTurn();
            battleButtons();
            displayBattleStats(); 
            imgX2One.setImage(new Image("resources/times.jpg"));

        }
        
        imgBattleDice.setImage(null);

        
    }
    
    @FXML
    private void handleDefenseTwo(ActionEvent event){
        if(battle.getChoseDefenseTwo()){
            lblBattlePlayerDamage.setText(board.getPlayers()[battle.getTurn()].getName() + " Cannot Defend Consecutively");
        }
        else{
            lblBattlePlayerDamage.setText(board.getPlayers()[battle.getTurn()].getName() +  " chose to Defend");
            battle.playerTwoDefends();
            battle.changePlayerTurn();
            battleButtons();
            displayBattleStats();
            imgX2Two.setImage(new Image("resources/times.jpg"));
        }       
        imgBattleDice.setImage(null);

        
    }
    
    //disables and enables attack/defense buttons
    public void battleButtons(){
        if(battle.getTurn() == 0){
            if(battle.getChoseAttackOne()){
                //checkBattleDie();
                attackButtons[0].setDisable(false);
                defenseButtons[0].setDisable(true);
                attackButtons[1].setDisable(true);
                defenseButtons[1].setDisable(true);
            }           
            else if(battle.getChoseDefenseOne()){
                attackButtons[0].setDisable(true);
                defenseButtons[0].setDisable(true);
                battle.changePlayerTurn();
                //System.out.println("2");
                battleButtons();
                
            }
            else if(!battle.getChoseAttackOne() && !battle.getChoseDefenseOne()){
                attackButtons[0].setDisable(false);
                defenseButtons[0].setDisable(false);
                attackButtons[1].setDisable(true);
                defenseButtons[1].setDisable(true);
                //System.out.println("3");
            }
        }
        else if(battle.getTurn() == 1){
            if(battle.getChoseAttackTwo()){
                //checkBattleDie();
                attackButtons[1].setDisable(false);
                defenseButtons[0].setDisable(true);
                defenseButtons[1].setDisable(true);
                attackButtons[0].setDisable(true);
                //System.out.println("4");
            }
            else if(battle.getChoseDefenseTwo()){
                attackButtons[1].setDisable(true);
                defenseButtons[1].setDisable(true);
                battle.changePlayerTurn();
                //System.out.println("5");
                battleButtons();
            }
            else{
                attackButtons[1].setDisable(false);
                defenseButtons[1].setDisable(false);
                attackButtons[0].setDisable(true);
                defenseButtons[0].setDisable(true);
                //System.out.println("6");
            }
        }
        
        imgLuckyDice.setImage(null);
    }
    
    
    //enables the player to roll the battle die if he or she chose to attack
    public void checkBattleDie(){
        if(battle.getChoseAttackOne() && battle.getTurn() == 0){
            btnBattleDice.setDisable(false);
            btnAttackOne.setDisable(true);
            btnDefenseOne.setDisable(true);
        }
        else if(battle.getChoseAttackTwo() && battle.getTurn() == 1){
            btnBattleDice.setDisable(false);
            btnAttackTwo.setDisable(true);
            btnDefenseTwo.setDisable(true);
        }
        else{
            btnBattleDice.setDisable(true);
            attackButtons[battle.getTurn()].setDisable(false);
        }
    }
    
    //switches the scene from the board to the battle scene
    public void switchToBattle() throws IOException{
        Parent battle_Page_Parent = FXMLLoader.load(getClass().getResource("FXMLBattle.fxml"));
        Scene battle_Page_Scene = new Scene(battle_Page_Parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(battle_Page_Scene);
        stage.show();
    }
    
    @FXML
    private void handleDecreaseHP(ActionEvent event){
        
        if(board.getPlayers()[turn].getPieces()[pieceNum].getAbility().equals("Upgrade Sale") && board.getPlayers()[turn].getPieces()[pieceNum].getUnlockedAbility()){
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeHPNum(-5);
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(-5);
        }
        else{
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeHPNum(-5);
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(-10);
        }
            
        if(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUpgradeHP() == 0){
            btnDecreaseHP.setDisable(true);
        }
        lblTotalCost.setText(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost() + "");
        displayUpgradeStats();
    }
    
    @FXML
    private void handleIncreaseHP(ActionEvent event){
        if(pieceNum != 4){
            btnDecreaseHP.setDisable(false);
            if(board.getPlayers()[turn].getPieces()[pieceNum].getAbility().equals("Upgrade Sale") && board.getPlayers()[turn].getPieces()[pieceNum].getUnlockedAbility()){
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeHPNum(5);
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(5);
            }
            else{
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeHPNum(5);
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(10);
            }
            
            lblTotalCost.setText(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost() + "");
        }
        displayUpgradeStats();
    }
    
    @FXML
    private void handleDecreaseAttack(ActionEvent event){
        
        if(board.getPlayers()[turn].getPieces()[pieceNum].getAbility().equals("Upgrade Sale") && board.getPlayers()[turn].getPieces()[pieceNum].getUnlockedAbility()){
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeAttackNum(-5);
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(-5);
        }
        else{
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeAttackNum(-5);
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(-10);
        }
        
        if(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUpgradeAttack() == 0){
            btnDecreaseAttack.setDisable(true);
        }
        lblTotalCost.setText(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost() + "");
        displayUpgradeStats();
    }
    
    @FXML
    private void handleIncreaseAttack(ActionEvent event){
        
        if(pieceNum != 4){
            btnDecreaseAttack.setDisable(false);
            if(board.getPlayers()[turn].getPieces()[pieceNum].getAbility().equals("UpgradeSale") && board.getPlayers()[turn].getPieces()[pieceNum].getUnlockedAbility()){
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeAttackNum(5);
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(5);
            }
            else{
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeAttackNum(5);
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(10);
            }
            
            lblTotalCost.setText(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost() + "");
        }
        displayUpgradeStats();
    }
    
    @FXML
    private void handleDecreaseDefense(ActionEvent event){
        if(board.getPlayers()[turn].getPieces()[pieceNum].getAbility().equals("UpgradeSale") && board.getPlayers()[turn].getPieces()[pieceNum].getUnlockedAbility()){
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeDefenseNum(-5);
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(-5);
            }
        else{
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeDefenseNum(-5);
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(-10);
        }
        if(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUpgradeDefense() == 0){
            btnDecreaseDefense.setDisable(true);
        }
        lblTotalCost.setText(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost() + "");
        displayUpgradeStats();
    }
    
    @FXML
    private void handleIncreaseDefense(ActionEvent event){
        if(pieceNum != 4){
            btnDecreaseDefense.setDisable(false);
            if(board.getPlayers()[turn].getPieces()[pieceNum].getAbility().equals("UpgradeSale") && board.getPlayers()[turn].getPieces()[pieceNum].getUnlockedAbility()){
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeDefenseNum(5);
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(5);
            }
            else{
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeDefenseNum(5);
                board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeTotalUpgradeCost(10);
            }
            lblTotalCost.setText(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost() + "");
        }
        displayUpgradeStats();
    }
    
    @FXML
    private void handleApply(ActionEvent event){
        if(board.getPlayers()[board.getPlayerTurn()].getGold() - board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost() >= 0){
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].updateHP(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUpgradeHP());
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].updateAttack(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUpgradeAttack());
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].updateDefense(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUpgradeDefense());
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].upgradeMaxHP(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUpgradeHP());
            board.getPlayers()[board.getPlayerTurn()].updateGold(-1*(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getTotalUpgradeCost()));
            playerGold[board.getPlayerTurn()].setText(board.getPlayers()[board.getPlayerTurn()].getGold() + "");
            btnDecreaseAttack.setDisable(true);
            btnDecreaseDefense.setDisable(true);
            btnDecreaseHP.setDisable(true);
            displayStats();
            lblError.setText("");
        }
        
        else{
            lblError.setText("Not Enough Gold");
        }
        

    }
    
    public void enableIncreaseButtons(){
        btnIncreaseHP.setDisable(false);
        btnIncreaseAttack.setDisable(false);
        btnIncreaseDefense.setDisable(false);
        btnApply.setDisable(false);
        btnUnlockAbility.setDisable(false);
    }
    
    @FXML
    private void handleUnlockAbility(ActionEvent event){
        if(board.getPlayers()[board.getPlayerTurn()].getGold() - 200 >= 0 && !board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getUnlockedAbility()){
            board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].setUnlockedAbility();
            lblProfileAbility.setText(board.getPlayers()[turn].getPieces()[pieceNum].getAbility());
            lblProfileAbilityDescription.setText(board.getPlayers()[turn].getPieces()[pieceNum].getAbilityDescription());
        }
    }
    
    @FXML
    private void handleRedCircle(MouseEvent event){
        if(turn == 0){
            pieceNum = 0;
            imgProfilePicture.setImage(new Image("resources/redcircle.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    @FXML
    private void handleRedSquare(MouseEvent event){
        if(turn == 0){
            pieceNum = 1;
            imgProfilePicture.setImage(new Image("resources/redsquare.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    @FXML
    private void handleRedTriangle(MouseEvent event){
        if(turn == 0){
            pieceNum = 2;
            imgProfilePicture.setImage(new Image("resources/redtriangle.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    @FXML
    private void handleRedKite(MouseEvent event){
        if(turn == 0){
            pieceNum = 3;
            imgProfilePicture.setImage(new Image("resources/redkite.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    //ends game if there is a winner
    public void checkWinner(){
        if(board.getPlayers()[0].getHealth() <= 0){
            lblPlayerTurn.setText("GAME OVER " + board.getPlayers()[1].getName() + " has Won");
            btnMainMenu.setVisible(true);
        }
        else if(board.getPlayers()[1].getHealth() <= 0){
            lblPlayerTurn.setText("GAME OVER " + board.getPlayers()[0].getName() + " has Won");
            btnMainMenu.setVisible(true);
        }
    }
    
    @FXML
    private void handleBlueCircle(MouseEvent event){
        if(turn == 1){
            pieceNum = 0;
            imgProfilePicture.setImage(new Image("resources/bluecircle.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    @FXML
    private void handleBlueSquare(MouseEvent event){
        if(turn == 1){
            pieceNum = 1;
            imgProfilePicture.setImage(new Image("resources/bluesquare.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    @FXML
    private void handleBlueTriangle(MouseEvent event){
        if(turn == 1){
            pieceNum = 2;
            imgProfilePicture.setImage(new Image("resources/bluetriangle.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    @FXML
    private void handleBlueKite(MouseEvent event){
        if(turn == 1){
            pieceNum = 3;
            imgProfilePicture.setImage(new Image("resources/bluekite.png"));
            displayStats();
            enableIncreaseButtons();
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    board.getPlayers()[i].getPieces()[j].resetUpgradeNumbers();
                }
            }
        }
    }
    
    //displays the pieces upgrade stats
    public void displayUpgradeStats(){
        lblProfileHP.setText(board.getPlayers()[turn].getPieces()[pieceNum].getHP() + board.getPlayers()[turn].getPieces()[pieceNum].getUpgradeHP() + "");
        lblProfileAttack.setText(board.getPlayers()[turn].getPieces()[pieceNum].getAttack() + board.getPlayers()[turn].getPieces()[pieceNum].getUpgradeAttack() + "");
        lblProfileDefense.setText(board.getPlayers()[turn].getPieces()[pieceNum].getDefense() + board.getPlayers()[turn].getPieces()[pieceNum].getUpgradeDefense() + "");
    }
    
    //displays the piece's stats
    public void displayStats(){
        if(pieceNum != 4){
            lblProfileHP.setText(board.getPlayers()[turn].getPieces()[pieceNum].getHP() + "");
            lblProfileAttack.setText(board.getPlayers()[turn].getPieces()[pieceNum].getAttack() + "");
            lblProfileDefense.setText(board.getPlayers()[turn].getPieces()[pieceNum].getDefense() + "");
            lblTotalCost.setText("0");
            btnDecreaseHP.setDisable(true);
            btnDecreaseAttack.setDisable(true);
            btnDecreaseDefense.setDisable(true);
            btnIncreaseHP.setDisable(false);
            btnIncreaseAttack.setDisable(false);
            btnIncreaseDefense.setDisable(false);
            if(board.getPlayers()[turn].getPieces()[pieceNum].getUnlockedAbility()){
                lblProfileAbility.setText(board.getPlayers()[turn].getPieces()[pieceNum].getAbility());
                lblProfileAbilityDescription.setText(board.getPlayers()[turn].getPieces()[pieceNum].getAbilityDescription());
                btnUnlockAbility.setDisable(true);
            }
            else{
                btnUnlockAbility.setDisable(false);
                lblProfileAbility.setText("");
                lblProfileAbilityDescription.setText("");
            }
        }
        else{
           disableButtons();
           clearProfile();
           
        }
    }
    
    //disables every button
    public void disableButtons(){
        btnIncreaseHP.setDisable(true);
        btnIncreaseAttack.setDisable(true);
        btnIncreaseDefense.setDisable(true);
        btnApply.setDisable(true);
        btnUnlockAbility.setDisable(true);
        btnDecreaseHP.setDisable(true);
        btnDecreaseAttack.setDisable(true);
        btnDecreaseDefense.setDisable(true);
    }
    
    //clears all the labels and images on the profile section
    public void clearProfile(){
       lblProfileHP.setText("");
       lblProfileAttack.setText("");
       lblProfileDefense.setText("");
       lblTotalCost.setText("0");
       lblProfileAbility.setText("");
       lblProfileAbilityDescription.setText("");
       imgProfilePicture.setImage(null); 
    }
    
    public void clearBoard(){
        for(int i = 0; i < 36; i++){
            for(int j = 0; j < 4; j++){
                boardPieces[i][j].setImage(null);
            }
        }
    }
    
    public void placePieces(){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++){
                boardPieces[board.getPlayers()[i].getPieces()[j].getPosition()][j].setImage(new Image(board.getPlayers()[i].getPieces()[j].getImagePath()));
            }
        }
    }
   
    @FXML
    private void handleMovePiece(ActionEvent event) throws IOException{
     
        if(pieceNum == 4){
            lblPlayerTurn.setText("Select A Piece");
        }
        
        else{
           
            clearBoard();
           //System.out.println("AAAA");
            if(board.checkForPass(pieceNum)){
                rectBlue.setVisible(true);
                anchorPaneBattle.setVisible(true);
                battle = new Battle(board.getPieceOne(),board.getPieceTwo());
                displayBattleStats();
                battleButtons();
            }
            board.updatePiecePosition(pieceNum);
            board.checkPieceInEnemyBase(pieceNum);
            board.returnStart(pieceNum);
            placePieces();
            //boardPieces[board.getPlayers()[turn].getPieces()[pieceNum].getPosition()][pieceNum].setImage(new Image(board.getPlayers()[board.getPlayerTurn()].getPieces()[pieceNum].getImagePath()));
            //System.out.println("QQQ");
            board.moveGainGold();
            playerGold[turn].setText(board.getPlayers()[turn].getGold() + "");
            board.changeTurn();
            turn = board.getPlayerTurn();
            lblPlayerTurn.setText(board.getPlayers()[turn].getName() + "'s Turn");
            btnRoll.setDisable(false);
            btnMove.setDisable(true);
            pieceNum = 4;
            displayHearts();
            turn = board.getPlayerTurn();
            displayStats();
        }
    }
    
    //displays the pieces' stats during battle
    public void displayBattleStats(){       
        turn = battle.getTurn();
        lblBattlePlayerTurn.setText(board.getPlayers()[turn].getName() + "'s Turn");
        battleLabels[0][0].setText("HP: " + battle.getPieceOne().getHP());
        battleLabels[0][1].setText("Attack: " + battle.getPieceOne().getAttack());
        battleLabels[0][2].setText("Defense: " + battle.getPieceOne().getDefense());
        battleLabels[1][0].setText("HP: " + battle.getPieceTwo().getHP());
        battleLabels[1][1].setText("Attack: " + battle.getPieceTwo().getAttack());
        battleLabels[1][2].setText("Defense: " + battle.getPieceTwo().getDefense());
        imgBattlePieceOne.setImage(new Image(battle.getPieceOne().getImagePath()));
        imgBattlePieceTwo.setImage(new Image(battle.getPieceTwo().getImagePath()));
        if(battle.getPieceOne().getIsPoisoned()){
            imgPoisonOne.setImage(new Image("resources/poison.png"));
        }
        if(battle.getPieceTwo().getIsPoisoned()){
            imgPoisonTwo.setImage(new Image("resources/poison.png"));
        }
        
                
    }
    
    //dislays te players number of hearts
    public void displayHearts(){
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                heartImages[i][j].setImage(null);
            }
        }
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < board.getPlayers()[i].getHealth(); j++){
                heartImages[i][j].setImage(new Image("resources/heart.png"));
            }
        }
    }
    
    @FXML
    private void handleDiceRoll(ActionEvent event){
        board.rollDice();
        imgDice.setImage(new Image(diceImages[board.getDiceRoll() - 1]));
        //int turn = board.getPlayerTurn();
        
        
        btnMove.setDisable(false);
        btnRoll.setDisable(true);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //board = new Board("Red","Blue");
        String nameOne = JOptionPane.showInputDialog("What is Player 1's Name?");
        String nameTwo = JOptionPane.showInputDialog("What is Player 2's name?");
        
        board = new Board(nameOne,nameTwo);
        
        
        diceImages[0] = "resources/diceone.png";
        diceImages[1] = "resources/dicetwo.png";
        diceImages[2] = "resources/threedice.png";
        diceImages[3] = "resources/fourdice.png";
        diceImages[4] = "resources/fivedice.png";
        diceImages[5] = "resources/sixdice.png";
        
        lblPlayerOneGold.setText(board.getPlayers()[0].getName() + "'s Gold: ");
        lblPlayerTwoGold.setText(board.getPlayers()[1].getName() + "'s Gold: ");
        
        playerGold[0] = P1Gold;
        playerGold[1] = P2Gold;
        
        heartImages[0][0] = imgP1Heart1;
        heartImages[0][1] = imgP1Heart2;
        heartImages[0][2] = imgP1Heart3;
        heartImages[1][0] = imgP2Heart1;
        heartImages[1][1] = imgP2Heart2;
        heartImages[1][2] = imgP2Heart3;
        
        battleLabels[0][0] = lblBattleHPOne;
        battleLabels[0][1] = lblBattleAttackOne;
        battleLabels[0][2] = lblBattleDefenseOne;
        battleLabels[1][0] = lblBattleHPTwo;
        battleLabels[1][1] = lblBattleAttackTwo;
        battleLabels[1][2] = lblBattleDefenseTwo;
        
        imgRedCircle.setImage(new Image("resources/redcircle.png"));
        imgRedSquare.setImage(new Image("resources/redsquare.png"));
        imgRedTriangle.setImage(new Image("resources/redtriangle.png"));
        imgRedKite.setImage(new Image("resources/redkite.png"));
        
        imgBlueCircle.setImage(new Image("resources/bluecircle.png"));
        imgBlueSquare.setImage(new Image("resources/bluesquare.png"));
        imgBlueTriangle.setImage(new Image("resources/bluetriangle.png"));
        imgBlueKite.setImage(new Image("resources/bluekite.png"));
        
        for(int i = 0; i < heartImages.length; i++){
            for(int j = 0; j < heartImages[0].length; j++){
                heartImages[i][j].setImage(new Image("resources/heart.png"));
            }
        }
        
        attackButtons[0] = btnAttackOne;
        attackButtons[1] = btnAttackTwo;
        defenseButtons[0] = btnDefenseOne;
        defenseButtons[1] = btnDefenseTwo;
        
        boardPieces[0][0] = imgRC0;
        boardPieces[1][0] = imgRC1;
        boardPieces[2][0] = imgRC2;
        boardPieces[3][0] = imgRC3;
        boardPieces[4][0] = imgRC4;
        boardPieces[5][0] = imgRC5;
        boardPieces[6][0] = imgRC6;
        boardPieces[7][0] = imgRC7;
        boardPieces[8][0] = imgRC8;
        boardPieces[9][0] = imgRC9;
        boardPieces[10][0] = imgRC10;
        boardPieces[11][0] = imgRC11;
        boardPieces[12][0] = imgRC12;
        boardPieces[13][0] = imgRC13;
        boardPieces[14][0] = imgRC14;
        boardPieces[15][0] = imgRC15;
        boardPieces[16][0] = imgRC16;
        boardPieces[17][0] = imgRC17;
        boardPieces[18][0] = imgRC18;
        boardPieces[19][0] = imgRC19;
        boardPieces[20][0] = imgRC20;
        boardPieces[21][0] = imgRC21;
        boardPieces[22][0] = imgRC22;
        boardPieces[23][0] = imgRC23;
        boardPieces[24][0] = imgRC24;
        boardPieces[25][0] = imgRC25;
        boardPieces[26][0] = imgRC26;
        boardPieces[27][0] = imgRC27;
        boardPieces[28][0] = imgRC28;
        boardPieces[29][0] = imgRC29;
        boardPieces[30][0] = imgRC30;
        boardPieces[31][0] = imgRC31;
        boardPieces[32][0] = imgRC32;
        boardPieces[33][0] = imgRC33;
        boardPieces[34][0] = imgRC34;
        boardPieces[35][0] = imgRC35;
        
        boardPieces[0][1] = imgRS0;
        boardPieces[1][1] = imgRS1;
        boardPieces[2][1] = imgRS2;
        boardPieces[3][1] = imgRS3;
        boardPieces[4][1] = imgRS4;
        boardPieces[5][1] = imgRS5;
        boardPieces[6][1] = imgRS6;
        boardPieces[7][1] = imgRS7;
        boardPieces[8][1] = imgRS8;
        boardPieces[9][1] = imgRS9;
        boardPieces[10][1] = imgRS10;
        boardPieces[11][1] = imgRS11;
        boardPieces[12][1] = imgRS12;
        boardPieces[13][1] = imgRS13;
        boardPieces[14][1] = imgRS14;
        boardPieces[15][1] = imgRS15;
        boardPieces[16][1] = imgRS16;
        boardPieces[17][1] = imgRS17;
        boardPieces[18][1] = imgRS18;
        boardPieces[19][1] = imgRS19;
        boardPieces[20][1] = imgRS20;
        boardPieces[21][1] = imgRS21;
        boardPieces[22][1] = imgRS22;
        boardPieces[23][1] = imgRS23;
        boardPieces[24][1] = imgRS24;
        boardPieces[25][1] = imgRS25;
        boardPieces[26][1] = imgRS26;
        boardPieces[27][1] = imgRS27;
        boardPieces[28][1] = imgRS28;
        boardPieces[29][1] = imgRS29;
        boardPieces[30][1] = imgRS30;
        boardPieces[31][1] = imgRS31;
        boardPieces[32][1] = imgRS32;
        boardPieces[33][1] = imgRS33;
        boardPieces[34][1] = imgRS34;
        boardPieces[35][1] = imgRS35;
        
        boardPieces[0][2] = imgRT0;
        boardPieces[1][2] = imgRT1;
        boardPieces[2][2] = imgRT2;
        boardPieces[3][2] = imgRT3;
        boardPieces[4][2] = imgRT4;
        boardPieces[5][2] = imgRT5;
        boardPieces[6][2] = imgRT6;
        boardPieces[7][2] = imgRT7;
        boardPieces[8][2] = imgRT8;
        boardPieces[9][2] = imgRT9;
        boardPieces[10][2] = imgRT10;
        boardPieces[11][2] = imgRT11;
        boardPieces[12][2] = imgRT12;
        boardPieces[13][2] = imgRT13;
        boardPieces[14][2] = imgRT14;
        boardPieces[15][2] = imgRT15;
        boardPieces[16][2] = imgRT16;
        boardPieces[17][2] = imgRT17;
        boardPieces[18][2] = imgRT18;
        boardPieces[19][2] = imgRT19;
        boardPieces[20][2] = imgRT20;
        boardPieces[21][2] = imgRT21;
        boardPieces[22][2] = imgRT22;
        boardPieces[23][2] = imgRT23;
        boardPieces[24][2] = imgRT24;
        boardPieces[25][2] = imgRT25;
        boardPieces[26][2] = imgRT26;
        boardPieces[27][2] = imgRT27;
        boardPieces[28][2] = imgRT28;
        boardPieces[29][2] = imgRT29;
        boardPieces[30][2] = imgRT30;
        boardPieces[31][2] = imgRT31;
        boardPieces[32][2] = imgRT32;
        boardPieces[33][2] = imgRT33;
        boardPieces[34][2] = imgRT34;
        boardPieces[35][2] = imgRT35;
        
        boardPieces[0][3] = imgRK0;
        boardPieces[1][3] = imgRK1;
        boardPieces[2][3] = imgRK2;
        boardPieces[3][3] = imgRK3;
        boardPieces[4][3] = imgRK4;
        boardPieces[5][3] = imgRK5;
        boardPieces[6][3] = imgRK6;
        boardPieces[7][3] = imgRK7;
        boardPieces[8][3] = imgRK8;
        boardPieces[9][3] = imgRK9;
        boardPieces[10][3] = imgRK10;
        boardPieces[11][3] = imgRK11;
        boardPieces[12][3] = imgRK12;
        boardPieces[13][3] = imgRK13;
        boardPieces[14][3] = imgRK14;
        boardPieces[15][3] = imgRK15;
        boardPieces[16][3] = imgRK16;
        boardPieces[17][3] = imgRK17;
        boardPieces[18][3] = imgRK18;
        boardPieces[19][3] = imgRK19;
        boardPieces[20][3] = imgRK20;
        boardPieces[21][3] = imgRK21;
        boardPieces[22][3] = imgRK22;
        boardPieces[23][3] = imgRK23;
        boardPieces[24][3] = imgRK24;
        boardPieces[25][3] = imgRK25;
        boardPieces[26][3] = imgRK26;
        boardPieces[27][3] = imgRK27;
        boardPieces[28][3] = imgRK28;
        boardPieces[29][3] = imgRK29;
        boardPieces[30][3] = imgRK30;
        boardPieces[31][3] = imgRK31;
        boardPieces[32][3] = imgRK32;
        boardPieces[33][3] = imgRK33;
        boardPieces[34][3] = imgRK34;
        boardPieces[35][3] = imgRK35;
        
        boardPieces[0][0].setImage(new Image(board.getPlayers()[0].getPieces()[0].getImagePath()));
        boardPieces[0][1].setImage(new Image(board.getPlayers()[0].getPieces()[1].getImagePath()));
        boardPieces[0][2].setImage(new Image(board.getPlayers()[0].getPieces()[2].getImagePath()));
        boardPieces[0][3].setImage(new Image(board.getPlayers()[0].getPieces()[3].getImagePath()));
        
        boardPieces[35][0].setImage(new Image(board.getPlayers()[1].getPieces()[0].getImagePath()));
        boardPieces[35][1].setImage(new Image(board.getPlayers()[1].getPieces()[1].getImagePath()));
        boardPieces[35][2].setImage(new Image(board.getPlayers()[1].getPieces()[2].getImagePath()));
        boardPieces[35][3].setImage(new Image(board.getPlayers()[1].getPieces()[3].getImagePath()));
        
        lblPlayerTurn.setText(board.getPlayers()[board.getPlayerTurn()].getName() + "'s Turn");
        
        imgBorder.setImage(new Image("resources/border.png"));
        imgBorderBorder.setImage(new Image("resources/borderborder.png"));
    }    
    
}
