import java.util.Random;

public class PasswordGenerator {
    private int length;
    private boolean includeUppercase;
    private boolean includeLowercase;
    private boolean includeNumbers;
    private boolean includeSpecialCharacters;
    private String birthdate;
    private String placeName;

    public PasswordGenerator(int length, boolean includeUppercase, boolean includeLowercase,
                             boolean includeNumbers, boolean includeSpecialCharacters,
                             String birthdate, String placeName) {
        this.length = length;
        this.includeUppercase = includeUppercase;
        this.includeLowercase = includeLowercase;
        this.includeNumbers = includeNumbers;
        this.includeSpecialCharacters = includeSpecialCharacters;
        this.birthdate = birthdate;
        this.placeName = placeName;
    }

    public String generatePassword() {

        //get appended character
        StringBuilder allCharacters = appendCharacter();


        StringBuilder password = new StringBuilder();


        Random random = new Random();
        //for loop to add random  char to password within length requested in input
        for (int i = 0; i < length; i++) {
            //getting random number from 0 to allCharacters length -1
            int index = random.nextInt(allCharacters.length());
            //appending random char from allCharacters to password variable to create password
            password.append(allCharacters.charAt(index));
        }

        return password.toString();
    }


    //method to append user inputs and characters
    private StringBuilder appendCharacter(){

        StringBuilder allCharacters = new StringBuilder();

        if (includeUppercase) {
            allCharacters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        if (includeLowercase) {
            allCharacters.append("abcdefghijklmnopqrstuvwxyz");
        }

        if (includeNumbers) {
            allCharacters.append("0123456789");
        }

        if (includeSpecialCharacters) {
            allCharacters.append("!@#$%^&*()_-+=<>?");
        }

        if (allCharacters.isEmpty()) {
            // Default to including lowercase letters and numbers
            allCharacters.append("abcdefghijklmnopqrstuvwxyz0123456789");
        }

        // Append birthdate and placeName to increase randomness
        allCharacters.append(birthdate).append(placeName);

        return allCharacters;
    }
}
