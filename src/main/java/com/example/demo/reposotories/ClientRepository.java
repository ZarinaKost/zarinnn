package com.example.demo.reposotories;

import com.example.demo.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}

