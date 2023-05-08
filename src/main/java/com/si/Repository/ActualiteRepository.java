package com.si.Repository;

import com.si.entity.ActualiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ActualiteRepository extends JpaRepository<ActualiteEntity , Integer> {

}
