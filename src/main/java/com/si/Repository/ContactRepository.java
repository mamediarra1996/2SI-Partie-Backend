package com.si.Repository;

import com.si.Entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Long> {

}
