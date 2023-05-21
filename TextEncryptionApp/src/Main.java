import com.textencryptionapp.algorithms.CaesarCipher;
import com.textencryptionapp.algorithms.MorseCode;
import com.textencryptionapp.service.EncryptionService;
import com.textencryptionapp.util.UserInput;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        String plaintext = userInput.getUserInput();

        EncryptionService encryptionService;

        System.out.println("SELECT ENCRYPTION METHOD:");
        System.out.println("1. Caesar cipher");
        System.out.println("2. Morse code");
        String choice = userInput.getUserInput();

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