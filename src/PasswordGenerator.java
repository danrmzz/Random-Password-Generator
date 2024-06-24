package src;

// this class works as the back end and will generate the password

import java.util.Random;

public class PasswordGenerator {
    // character pools
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "1234567890";
    public static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    private final Random random;

    // constructor
    public PasswordGenerator() {random = new Random();}

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers,
                                   boolean includeSpecialSymbols) {

        StringBuilder passwordBuilder = new StringBuilder();

        // store valid characters (toggle states)
        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_CHARACTERS;

        // build password
        for (int i = 0; i < length; i++) {
            // generate random index
            int randomIndex = random.nextInt(validCharacters.length());

            // get the char based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            // store char into the password builder
            passwordBuilder.append(randomChar);
        }

        return passwordBuilder.toString();

    }
}
