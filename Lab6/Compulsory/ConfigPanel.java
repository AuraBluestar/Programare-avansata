package lab6.main;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JSpinner spinner;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        //create spinners for rows and cols, and the button
        //...TODO
        add(label); //JPanel uses FlowLayout by default
        add(spinner);
    }

    public int getRows() {
        return 0;
    }

    public int getCols() {
        return 0;
    }
}
