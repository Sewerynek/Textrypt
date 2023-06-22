package com.textencryptionapp.service;

import com.textencryptionapp.algorithms.EncryptionAlgorithm;

public class EncryptionService {
    private final EncryptionAlgorithm encryptionAlgorithm;

    public EncryptionService(EncryptionAlgorithm encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public String encrypt(String plaintext) {
        return encryptionAlgorithm.encrypt(plaintext);
    }

    public String decrypt(String ciphertext) {
        return encryptionAlgorithm.decrypt(ciphertext);
    }
}