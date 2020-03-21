package com.example.JPAApplication.Repository;

import com.example.JPAApplication.Entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Author, Integer> {
}
