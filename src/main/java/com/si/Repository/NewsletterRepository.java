package com.si.Repository;

import com.si.entity.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter,Long> {

   default List<String> findAllEmail() {
      return new ArrayList<>();
   }
}
