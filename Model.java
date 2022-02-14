/**
 * Lab 06 - Event Handling and MVC Apporach
 */

import javax.swing.*;

public class Model{

    /**PRivate instance variables */
    private Boolean Player01 ;
    private int chance = 0 ;
    private View view ;
    private JButton[] btn ;
    private JLabel lbl ;

    /**Model constructor */
    public Model(View view){
        this.view = view;
        btn = this.view.getActionListernerButtons();
        lbl  = this.view.getLabel();
        StartGame();
    }

    /**Function to start the game 
     * if row-wise or column-wise or diagonal-wise the concatanation of strings == 111 or 222
     * one of the players wil win but if all the buttons were clicked but none of the matching cases found match will tie
     * sigma(a1j when j = 1 to 3) , sigma(a2j when j = 1 to 3) ,sigma(a3j when j = 1 to 3) row wise
     * sigma(ai1 when i = 1 to 3) , sigma(ai2 when i = 1 to 3)  ,sigma(ai3 when i = 1 to 3) column wise
     * sigma(aij when i = j) diagonally
    */
    /**Function to find the winner */
    public void CheckWinner(){
        String winner = null;                       /**Initiallly set the winner to null */
        int flag = 0 ;                              /**Get the concatanation of string according to the following cases */
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    winner = btn[0].getText() +  btn[1].getText() + btn[2].getText();
                    break;
                
                case 1:
                    winner = btn[3].getText() +  btn[4].getText() + btn[5].getText();
                    break;
                
                case 2:
                    winner = btn[6].getText() +  btn[7].getText() + btn[8].getText();
                    break;
                
                case 3:
                    winner = btn[0].getText() +  btn[3].getText() + btn[6].getText();
                    break;

                case 4:
                    winner = btn[1].getText() +  btn[4].getText() + btn[7].getText();
                    break;

                case 5:
                    winner = btn[2].getText() +  btn[5].getText() + btn[8].getText();
                    break;

                case 6:
                    winner = btn[0].getText() +  btn[4].getText() + btn[8].getText();
                    break;

                case 7:
                    winner = btn[2].getText() +  btn[4].getText() + btn[6].getText();
                    break;

            }
            
            /**IF winner  == 111*/
            if (winner.equals("111")) {
                lbl.setText("Player 1 won!");                      /**Set the label to Player 1 won */
                flag = 1 ;                                              /**Flag to check wthether already the player has won */
                view.GameOver("Player 1 won!");                              /**Call the game over function */
            }
            /**IF winner  == 222*/
            else if(winner.equals("222")){
                lbl.setText("Player 2 won!");                      /**Set the label to Player 2 won */
                flag = 1 ;                                              /**Flag to check wthether already the player has won */
                view.GameOver("Player 2 won!");                              /**Call the game over function */
            }
         
        }

        //boolean check = winner.equals("111") || winner.equals("222") ;
        if((getChances() == 9) && (flag == 0)){
            /**No matching cases found but all the buttons were clicked then tie the game
             * winner.equals(111) == FALSE && winner.equals(222) == FALSE && chances == 9
             */
            lbl.setText("Match Tied");
            view.GameOver("Match Tied");
        }
    }

    /**Get the current status of the player 01 */
    public boolean getPlayerStatus(){
        return this.Player01;
    }
    
    /**Set the current status of the player 01 */
    public void setPlayerStatus(Boolean status){
        this.Player01 = status;
    }

    /**returns the no of buttons were clicked */
    public int getChances(){
        return this.chance;
    }

    /**Increment no of buttons clicked */
    public void updateChances(){
        this.chance++;
    }

    /**Function to set the current player status initially */
    public void StartGame(){
        
        try {
            lbl.setText("Loading....!");                   /**Set the text label to Loading */
            Thread.sleep(200);                                  /**wait 200 millisecs */
            setPlayerStatus(true);                              /**Set the player01 status to true */
            lbl.setText("Player 1 turn");                  /**Set the text label to Player 1 turn */
        } catch (InterruptedException e) {
            System.exit(1);                                     /**Any interruption occurs exit from JVM */
        }   
    }
}
