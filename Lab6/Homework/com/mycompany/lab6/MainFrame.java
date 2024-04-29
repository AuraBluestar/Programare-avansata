package com.mycompany.lab6;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    ConfigPanel configPanel; //NORTH
    DrawingPanel canvas; //CENTER
    ControlPanel controlPanel; //SOUTH

    public MainFrame() {
        super("My GridGame");
        init();
    }

    private void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        configPanel = new ConfigPanel(this);
        add(configPanel, NORTH);
        
        canvas = new DrawingPanel(this);
        add(canvas, CENTER);
        
        controlPanel = new ControlPanel(this);
        add(controlPanel, SOUTH);
        
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }
}
