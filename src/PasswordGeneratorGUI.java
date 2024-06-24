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


        // create result text area
        JTextArea passwordOutput = new JTextArea();

        // prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        // add scrollability in case output is too long
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        // create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.black));
        add(passwordOutputPane);

        // create password length label
        JLabel passwordLengthLable = new JLabel("Password Length: ");
        passwordLengthLable.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLable.setBounds(25, 215, 272, 39);
        add(passwordLengthLable);


        // create toggle buttons
        // uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setBounds(25, 302, 225, 56);
        add(uppercaseToggle);

        // lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        // numbers toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        // symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);



    }
}
