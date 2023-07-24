package com.si.controller;

import com.si.Repository.NewsletterRepository;
import com.si.Service.EmailService;
import com.si.entity.Newsletter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletters")
public class NewsletterController {
    @Autowired
    private NewsletterRepository newsletterRepository;
    @Autowired
    private EmailService emailService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> createNewsletter(@RequestBody Newsletter newsletter) {
        try {
            // Sauvegarde de la newsletter dans la base de données
            newsletterRepository.save(newsletter);

            // Envoi de l'e-mail aux abonnés
            List<String> subscribers = newsletterRepository.findAllEmail();
            for (String subscriber : subscribers) {
                String subject = newsletter.getNom();
                String content = newsletter.getEmail();
                emailService.sendEmail(subscriber, subject, content);
            }

            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            // Gestion de l'erreur de contrainte d'unicité de l'e-mail
            return ResponseEntity.status(HttpStatus.CONFLICT).body("L'e-mail est déjà utilisé.");
        }
    }


}