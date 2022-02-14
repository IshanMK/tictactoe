/**
 * Lab 06 - Event Handling and MVC Apporach
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controller implements ActionListener {
    
    /**PRivate instance variables */
    private Model model ;
    private View view;
    private JButton[] btn ;
    private JLabel lbl;

    /**Constructor */
    public Controller(Model model , View view){
        this.view = view;
        this.model = model;
        
        /**Initialize the actionlisteners to the buttons */
        lbl = this.view.getLabel();
        btn = this.view.getActionListernerButtons();
        for (int i = 0; i < btn.length; i++) {
            btn[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < btn.length; i++) {
            if (e.getSource() == btn[i]) {
                if (model.getPlayerStatus() == true) {                                     /**IF the current player01 staus is true */
                    if (btn[i].getText().equals("")) {                                     /**But button text is not avaialble */
                        btn[i].setText("1");                                               /**Then set the text as 1 */
                        btn[i].setBackground(Color.RED);                                   /**Change the button background to RED */
                        model.setPlayerStatus(false);                                      /**Set the Player01 staus to false */
                        lbl.setText("Player 2 turn");                                      /**Change the label as Player 2 turn */
                        model.updateChances();                                             /**Update the no of buttons clicked */
                        model.CheckWinner();                                               /**Check for a winner */
                    }
                }
                else{   
                    if (btn[i].getText().equals("")) {                                     /**IF the current player01 staus is false  But button text is not avaialble */               
                        btn[i].setText("2");                                               /**Then set the text as 2 */
                        btn[i].setBackground(Color.GREEN);                                 /**Change the button background to GREEN */
                        model.setPlayerStatus(true);                                       /**Set the Player01 staus to true */
                        lbl.setText("Player 1 turn");                                      /**Change the label as Player 1 turn */
                        model.updateChances();                                             /**Update the no of buttons clicked */
                        model.CheckWinner();                                               /**Check for a winner */
                    }
                }
            }
        }
    }

}
