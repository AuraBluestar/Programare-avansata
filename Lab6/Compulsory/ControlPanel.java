package lab6.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Exit, etc.)
    //...TODO

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        //...TODO
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    //...TODO
}
