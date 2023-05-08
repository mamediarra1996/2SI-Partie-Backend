package com.si.Repository;

import com.si.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
    public Register findByEmail(String email);
    public Register findByEmailAndPassword(String email, String password);
}
