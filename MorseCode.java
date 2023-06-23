package Textencryptionapp.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MorseCode implements EncryptionAlgorithm {

    private static final Map<Character, String> morseCodeMap;

    static {
        morseCodeMap = new HashMap<>();
        morseCodeMap.put('A', "•-");
        morseCodeMap.put('B', "-•••");
        morseCodeMap.put('C', "-•-•");
        morseCodeMap.put('D', "-••");
        morseCodeMap.put('E', "•");
        morseCodeMap.put('F', "••-•");
        morseCodeMap.put('G', "--•");
        morseCodeMap.put('H', "••••");
        morseCodeMap.put('I', "••");
        morseCodeMap.put('J', "•---");
        morseCodeMap.put('K', "-•-");
        morseCodeMap.put('L', "•-••");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-•");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', "•--•");
        morseCodeMap.put('Q', "--•-");
        morseCodeMap.put('R', "•-•");
        morseCodeMap.put('S', "•••");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "••-");
        morseCodeMap.put('V', "•••-");
        morseCodeMap.put('W', "•--");
        morseCodeMap.put('X', "-••-");
        morseCodeMap.put('Y', "-•--");
        morseCodeMap.put('Z', "--••");
    }

    @Override
    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (String word : plaintext.toUpperCase().split(" ")) {
            for (char letter : word.toCharArray()) {
                String morseCode = morseCodeMap.get(letter);
                if (morseCode != null) {
                    ciphertext.append(morseCode).append("/");  // add a slash after each letter
                } else {
                    ciphertext.append(letter);
                }
            }
            ciphertext.append("/");  // add a double slash after each word
        }
        return ciphertext.toString().trim();
    }


    @Override
    public String decrypt(String ciphertext) {
        // Decryption
        return "";
    }
}