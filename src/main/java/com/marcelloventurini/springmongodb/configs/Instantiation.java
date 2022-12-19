package com.marcelloventurini.springmongodb.configs;

import com.marcelloventurini.springmongodb.dto.AuthorDTO;
import com.marcelloventurini.springmongodb.entities.Post;
import com.marcelloventurini.springmongodb.entities.User;
import com.marcelloventurini.springmongodb.repositories.PostRepository;
import com.marcelloventurini.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    Post p1 = new Post(null, Instant.parse("2022-06-20T19:22:07Z"), "Going to SP!", "I'm going to travel to Sao Paulo!", new AuthorDTO(maria));
    Post p2 = new Post(null, Instant.parse("2022-06-22T10:22:07Z"), "Good morning", "It's raining here in Sao Paulo.", new AuthorDTO(maria));

    postRepository.saveAll(Arrays.asList(p1, p2));

    maria.getPosts().addAll(Arrays.asList(p1, p2));
    userRepository.save(maria);
  }
}
