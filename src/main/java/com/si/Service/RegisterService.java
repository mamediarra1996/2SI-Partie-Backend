package com.si.Service;

import com.si.Repository.RegisterRepository;
import com.si.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository repo;
    public Register saveRegister(Register register){
       return repo.save(register);
    }

    public Register fetchRegisterByEmail(String email){
        return repo.findByEmail(email);
    }

    public Register fetchRegisterByEmailAndPassword(String email, String password){
        return repo.findByEmailAndPassword(email,password);
    }
}
