/**
 * E / 18 / 173
 * Kasthuripitiya K.A.I.M.
 * Lab 06 - Event Handling and MVC Apporach
 */

import java.awt.*;
import javax.swing.*;

public class View {
    /**Creates a Frame that is initially invisible */
    private JFrame frame = new JFrame("Tic Tac Toe");

    /**simplest container class. It provides space in which an application can attach any other component. 
     * It is used to create a new JPanel with a double buffer and a flow layout.
    */
    private JPanel btnpanel = new JPanel();                         /**Button Panel for Buttons */
    private JPanel txtpanel = new JPanel();                         /**Text panel for label */

    /**Create 9 button instances and add the buttons to the panel */
    private JButton[] btn = new JButton[9];
    private JLabel lbl = new JLabel();

    /**TictacToe Constructor */
    public View(){
        
        frame.add(btnpanel);                                                /**Add the btnpanel to frame*/
        frame.add(txtpanel , BorderLayout.NORTH);                           /**Add the txtpanel to frame*/
        frame.setSize(800, 600);                                            /**Set the frame size (width,height) */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);               /** Close the Window after exit*/
        frame.setVisible(true);                                             /**Set the frame visible */

        /**Panel for buttons */
        btnpanel.setLayout(new GridLayout(3,3));                            /**Take all the screen as the panel */
    
        /**Add all the buttons to the panel */
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();                                         /**Create the button instance */
            btnpanel.add(btn[i]);                                           /**Add the button to the btnpanel */
            btn[i].setFocusable(false);
            btn[i].setFont(new Font("Consolas", Font.BOLD, 80));            /**Change the font , font size of the button text */
        }

        lbl.setText("Tic Tac Toe");                                         /**Set text in the label */
        lbl.setFont(new Font("Consolas" , Font.ITALIC , 30));               /**Set the font Consolas , Italic and size to 30 */
        lbl.setOpaque(true);
        lbl.setBackground(new Color(120, 20, 124));                         /**Set background color */
        lbl.setForeground(new Color(25, 255, 0));                           /**Set foregroud color */
        txtpanel.add(lbl);                                                  /**Add the label to txtpanel */
        
    }

    /**Asks the user whether the user want to restart the game */
    public void GameOver(String str){
        
        Object[] option={"Play Again!","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n" + str,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){

            /**IF restart button was clicked 
             * Create a new instance of COntroller model
             * by destroying the current windwow
            */
            frame.dispose();
            View nView = new View();
            Model nModel = new Model(nView);
            new Controller(nModel,nView);
        }
        else{

            /**Destroy the current window */
            frame.dispose();
        }
    }

    /**Returns the button array */
    public JButton[] getActionListernerButtons(){
        return this.btn; 
    }

    /**Set the button array to btn */
    public void setActionListenerButtons(JButton[] btn){
        this.btn = btn ;
    }

    /**Returns the label */
    public JLabel getLabel(){
        return this.lbl;
    }

    /**Set the label */
    public void setLabel(JLabel lbl){
        this.lbl = lbl;
    }
}
