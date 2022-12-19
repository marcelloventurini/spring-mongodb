package com.marcelloventurini.springmongodb.services;

import com.marcelloventurini.springmongodb.entities.Post;
import com.marcelloventurini.springmongodb.repositories.PostRepository;
import com.marcelloventurini.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;

  public Post findById(String id) {
    Optional<Post> post = postRepository.findById(id);
    return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
  }

  public List<Post> findByTitle(String text) {
    return postRepository.findByTitleContainingIgnoreCase(text);
  }
}
