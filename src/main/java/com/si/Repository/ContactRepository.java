package com.si.Repository;

import com.si.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Long> {

}
