package com.tchokoapps.springboot.springcorespringmvc.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptedService {

    private StrongPasswordEncryptor strongEncryptor;

    @Override
    public String encryptString(String input) {
        return strongEncryptor.encryptPassword(input);
    }

    @Override
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
