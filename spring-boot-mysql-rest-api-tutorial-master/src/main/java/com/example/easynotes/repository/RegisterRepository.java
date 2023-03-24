package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.easynotes.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {

}
