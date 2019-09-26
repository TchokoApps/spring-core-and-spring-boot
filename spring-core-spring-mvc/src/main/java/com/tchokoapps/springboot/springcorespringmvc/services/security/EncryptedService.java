package com.tchokoapps.springboot.springcorespringmvc.services.security;

public interface EncryptedService {
    String encryptString(String input);

    boolean checkPassword(String plainPassword, String encryptedPassword);
}
