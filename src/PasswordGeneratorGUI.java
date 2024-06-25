package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// render the GUI components (front end)
// this class will inherit from the JFrame class

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

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

        // init password generator
        passwordGenerator = new PasswordGenerator();

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

        // create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.black));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        add(passwordLengthInputArea);



        // create toggle buttons
        // uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25, 302, 225, 56);
        add(uppercaseToggle);

        // lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        // numbers toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        // symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        // styles for toggled/untoggled buttons

        Color myRed = new Color(204, 80, 80);
        Color myGreen = new Color(107, 190, 90);

        uppercaseToggle.setBackground(myRed); uppercaseToggle.setForeground(Color.BLACK);
        lowercaseToggle.setBackground(myRed); lowercaseToggle.setForeground(Color.BLACK);
        numbersToggle.setBackground(myRed); numbersToggle.setForeground(Color.BLACK);
        symbolsToggle.setBackground(myRed); symbolsToggle.setForeground(Color.BLACK);

        uppercaseToggle.setBorder(BorderFactory.createLineBorder(Color.black));
        lowercaseToggle.setBorder(BorderFactory.createLineBorder(Color.black));
        numbersToggle.setBorder(BorderFactory.createLineBorder(Color.black));
        symbolsToggle.setBorder(BorderFactory.createLineBorder(Color.black));

        uppercaseToggle.setUI(new javax.swing.plaf.basic.BasicToggleButtonUI());
        lowercaseToggle.setUI(new javax.swing.plaf.basic.BasicToggleButtonUI());
        numbersToggle.setUI(new javax.swing.plaf.basic.BasicToggleButtonUI());
        symbolsToggle.setUI(new javax.swing.plaf.basic.BasicToggleButtonUI());


        uppercaseToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (uppercaseToggle.isSelected()) {
                    uppercaseToggle.setBackground(myGreen);
                } else {
                    uppercaseToggle.setBackground(myRed);
                }
            }
        });
        lowercaseToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lowercaseToggle.isSelected()) {
                    lowercaseToggle.setBackground(myGreen);
                } else {
                    lowercaseToggle.setBackground(myRed);
                }
            }
        });
        numbersToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numbersToggle.isSelected()) {
                    numbersToggle.setBackground(myGreen);
                } else {
                    numbersToggle.setBackground(myRed);
                }
            }
        });
        symbolsToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (symbolsToggle.isSelected()) {
                    symbolsToggle.setBackground(myGreen);
                } else {
                    symbolsToggle.setBackground(myRed);
                }
            }
        });




        // create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.setBackground(Color.LIGHT_GRAY); generateButton.setForeground(Color.BLACK);
        generateButton.setBorder(BorderFactory.createLineBorder(Color.black));
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validation: generate a password only when length > 0 and one of the toggled buttons is toggled
                if (passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || numbersToggle.isSelected() || symbolsToggle.isSelected();

                // generate password
                // converts the text to an int value
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if (anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength, uppercaseToggle.isSelected(), lowercaseToggle.isSelected(), numbersToggle.isSelected(), symbolsToggle.isSelected());

                    // display password
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}
