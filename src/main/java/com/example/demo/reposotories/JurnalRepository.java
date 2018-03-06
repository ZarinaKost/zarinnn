package com.example.demo.reposotories;


import com.example.demo.models.Author;
import com.example.demo.models.Jurnal;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JurnalRepository extends CrudRepository<Jurnal,Long> {
    Optional<Jurnal> findById(Long id);

}
