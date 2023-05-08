package com.si.controller;

import com.si.Service.RegisterService;
import com.si.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterConroller {

    @Autowired
    private RegisterService service;

    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:4200")
    public Register registerUser(@RequestBody Register register) throws Exception {
        String tempEmail= register.getEmail();
        if (tempEmail != null &&  !"".equals(tempEmail)){
           Register registerObj =  service.fetchRegisterByEmail(tempEmail);
           if (registerObj != null){
               throw new Exception(("utilisateur avec "+tempEmail+ "existe déjà"));
           }
        }
        Register registerObj = null;
        registerObj = service.saveRegister(register);
        return registerObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public Register loginUser(@RequestBody Register register) throws Exception {
        String temEmail = register.getEmail();
        String tempPass = register.getPassword();
        Register registerObj = null;
        if (temEmail != null && tempPass != null){
         registerObj = service.fetchRegisterByEmailAndPassword(temEmail, tempPass);
        }
        if (registerObj == null){
            throw new Exception("Mauvaises qualifications");
        }
        return registerObj;
    }
}
