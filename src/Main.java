import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int length = 0;

        //getting user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Enter the details to generate the password-- ");

        //length input have to be int and minimum 3 characters
        while(length < 3){

            //try catch to handle exception if input is not integer
            try {
                System.out.print("Enter the length of the password (minimum 3 characters): ");
                length = scanner.nextInt();


                if(length < 3)
                {
                    System.out.println("Password length must be at least 3 characters.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");

                // Consume the invalid input to prevent an infinite loop
                scanner.nextLine();
            }

        }

        //include Uppercase
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        //include Lowercase
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        //include Numbers
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        //include Special Characters
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialCharacters = scanner.next().equalsIgnoreCase("yes");

        //birth date
        System.out.print("Enter your birthdate (YYYYMMDD): ");
        String birthdate = scanner.next();

        //place Name
        System.out.print("Enter the name of a place you like: ");
        String placeName = scanner.next();
        scanner.close();

        //PasswordGenerator class object
        PasswordGenerator passwordGenerator = new PasswordGenerator(length,
                includeUppercase, includeLowercase, includeNumbers, includeSpecialCharacters,
                birthdate, placeName);


        //PasswordGenerator class method  to get random password
        String generatedPassword = passwordGenerator.generatePassword();

        System.out.println("Generated Password: " + generatedPassword);

    }
}

