package com.textencryptionapp.algorithms;

public interface EncryptionAlgorithm {
    String encrypt(String plaintext);
    String decrypt(String ciphertext);
}