package src;

import javax.swing.*;
import java.awt.*;

// render the GUI components (front end)
// this class will inherit from the JFrame class

public class PasswordGeneratorGUI extends JFrame {
    public PasswordGeneratorGUI() {
        // render frame and add a title
        super("Password Generator");

        // set the size of the GUI
        setSize(540, 570);

        // prevent the GUI from being able to resized
        setResizable(false);

        // set the layout to null to have control over the position and size of the components
        setLayout(null);

        // terminate program when GUI is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center the GUI
        setLocationRelativeTo(null);


        // render GUI components
        addGuiComponents();
    }

    private void addGuiComponents() {
        // create title text
        JLabel titleLabel = new JLabel("Password Generator");

        // increase font size and bold title text
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        // center the title text
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // set x, y coords and width/height values
        titleLabel.setBounds(0, 10, 540, 39);

        // add to GUI
        add(titleLabel);
    }
}
