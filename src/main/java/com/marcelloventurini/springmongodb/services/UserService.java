package com.marcelloventurini.springmongodb.services;

import com.marcelloventurini.springmongodb.dto.UserDTO;
import com.marcelloventurini.springmongodb.entities.User;
import com.marcelloventurini.springmongodb.repositories.UserRepository;
import com.marcelloventurini.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    Optional<User> user = userRepository.findById(id);
    return user.orElseThrow(() -> new ObjectNotFoundException("Object not fount"));
  }

  public User insert(User user) {
    return userRepository.insert(user);
  }

  public void delete(String id) {
    findById(id);
    userRepository.deleteById(id);
  }

  public User fromDTO(UserDTO userDTO) {
    return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
  }
}
