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
    private JCheckBox catCheckBox;
    private JCheckBox dogCheckBox;
    private JCheckBox fishCheckBox;
    private JButton quitButton;
    private JPanel rootPanel;
    private JLabel surveyResultsLabel;

    boolean fish, cat, dog;
    String message = "";
    PetSurvey(){
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setSize(300,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        catCheckBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
               cat = catCheckBox.isSelected();
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
        quitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int quit= JOptionPane.showConfirmDialog(PetSurvey.this,
                        "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);
                if(quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
    }
    private void updateResultLabel(){
        String hasDog = dog?" a dog ":"no dogs ";
        String hasCat = cat?" a cat, ":"no cats, ";
        String hasFish = fish?" and a fish ":" and no fishes";
        surveyResultsLabel.setText("The user has " +hasCat+hasDog+hasFish);
    }
}
