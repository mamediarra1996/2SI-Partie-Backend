package com.si.Repository;

import com.si.Entity.ActualiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
public interface ActualiteRepository extends JpaRepository<ActualiteEntity , Integer> {

}
