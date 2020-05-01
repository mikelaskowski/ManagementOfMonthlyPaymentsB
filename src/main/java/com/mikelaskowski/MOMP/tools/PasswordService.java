package com.mikelaskowski.MOMP.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public String encodePassword(String password){
       return BCrypt.hashpw(password,BCrypt.gensalt(10));
    }

    public boolean decode(String passwordToCheck, String hashedPassword){
        if(BCrypt.checkpw(passwordToCheck,hashedPassword)){
            System.out.println("Password matches");
            return true;
        }else{
            System.out.println("Password doesn't match");
            return false;
        }
    }
}
