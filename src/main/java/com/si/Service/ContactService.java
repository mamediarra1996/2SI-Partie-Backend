package com.si.Service;




import com.si.entity.ContactEntity;
import com.si.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping ("/contacts")
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    private List<ContactEntity> getContact(){
        return contactRepository.findAll();
    }
    @GetMapping("{id}")
    private Optional<ContactEntity> getcontact(@PathVariable Long id){
        return contactRepository.findById(id);
    }

    @PostMapping
    private String save(ContactEntity c){
        contactRepository.save(c);
        return "insertionReussie";
    }
    @PutMapping("{id}")
    private ContactEntity save(@PathVariable Long id, @RequestBody ContactEntity c){
        c.setId(id);
        return contactRepository.save(c);
    }
    @DeleteMapping("{id}")
    private boolean supprimer(@PathVariable Long id){
        contactRepository.deleteById(id);
        return true;
    }



}
