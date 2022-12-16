package com.marcelloventurini.springmongodb.repositories;

import com.marcelloventurini.springmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {}
