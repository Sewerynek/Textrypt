import Textencryptionapp.algorithms.CaesarCipher;
import Textencryptionapp.algorithms.MorseCode;
import Textencryptionapp.service.EncryptionService;
import Textencryptionapp.util.UserInput;
import Textencryptionapp.application.App;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        UserInput userInput = new UserInput();
        String plaintext = userInput.getUserInput(" ");

        EncryptionService encryptionService;


        String choice = userInput.getUserInput(" ");

        switch (choice) {
            case "1":
                encryptionService = new EncryptionService(new CaesarCipher(3));
                break;
            case "2":
                encryptionService = new EncryptionService(new MorseCode());
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Caesar cipher.");
                encryptionService = new EncryptionService(new CaesarCipher(3));
                break;
        }

        String ciphertext = encryptionService.encrypt(plaintext);

        userInput.displayOutput(ciphertext);
    }
}