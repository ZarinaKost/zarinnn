package com.example.demo.reposotories;

import com.example.demo.models.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Optional<Admin> findById(Long id);
}
