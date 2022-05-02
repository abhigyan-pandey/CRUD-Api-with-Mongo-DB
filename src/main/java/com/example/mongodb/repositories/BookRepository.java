package com.example.mongodb.repositories;

import com.example.mongodb.entities.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Books, Integer> {
}

