package com.textencryptionapp.algorithms;

public class CaesarCipher implements EncryptionAlgorithm {
    private final int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char letter : plaintext.toCharArray()) {
            if (Character.isLetter(letter)) {
                char base = Character.isLowerCase(letter) ? 'a' : 'A';
                letter = (char) ((letter - base + shift) % 26 + base);
            }
            ciphertext.append(letter);
        }
        return ciphertext.toString();
    }

    @Override
    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (char letter : ciphertext.toCharArray()) {
            if (Character.isLetter(letter)) {
                char base = Character.isLowerCase(letter) ? 'a' : 'A';
                letter = (char) ((letter - base - shift) % 26 + base);
                if (letter < base) {
                    letter += 26;
                }
            }
            plaintext.append(letter);
        }
        return plaintext.toString();
    }
}