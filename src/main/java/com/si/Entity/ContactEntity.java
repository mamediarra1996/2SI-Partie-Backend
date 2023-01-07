package com.si.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactEntity  {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dataNaissance;
    private String email;
    private Long tel;
    @Column(length = 2500)
    private String message;
}
