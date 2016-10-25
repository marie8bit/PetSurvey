package com.MarieErickson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by yd7581ku on 10/25/2016.
 */
public class PetSurvey extends JFrame
{
    //initialze form objects
    private JCheckBox catCheckBox;
    private JCheckBox dogCheckBox;
    private JCheckBox fishCheckBox;
    private JButton quitButton;
    private JPanel rootPanel;
    private JLabel surveyResultsLabel;
    //boolean variables for user output
    boolean fish, cat, dog;
    String message = "";
    //constructor method for the petsurvey form
    PetSurvey(){
        //call rootpanel GUI
        setContentPane(rootPanel);
        pack();
        //make visible
        setVisible(true);
        //set size
        setSize(300,400);
        //close program when x button is clicked
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //event handlers for CheckBoxes
        catCheckBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                //set boolean values
               cat = catCheckBox.isSelected();
                //call method to update the user output
                updateResultLabel();
            }
        });
        dogCheckBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                dog=dogCheckBox.isSelected();
                updateResultLabel();
            }
        });
        fishCheckBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                fish = fishCheckBox.isSelected();
                updateResultLabel();
            }
        });
        //event handler for click event of quit button
        quitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //verify user wants to close and potentially lose data/work
                int quit= JOptionPane.showConfirmDialog(PetSurvey.this,
                        "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);
                //handle ok button click event in dialog box
                if(quit == JOptionPane.OK_OPTION){
                    //0 means no problems/errors
                    System.exit(0);
                }
            }
        });
    }
    //method to display output to user
    private void updateResultLabel(){
        //ternary operators for boolean variables
        String hasDog = dog?" a dog ":"no dogs ";
        String hasCat = cat?" a cat, ":"no cats, ";
        String hasFish = fish?" and a fish ":" and no fishes";
        //use boolean variables to display information to user
        surveyResultsLabel.setText("The user has " +hasCat+hasDog+hasFish);
    }
}
