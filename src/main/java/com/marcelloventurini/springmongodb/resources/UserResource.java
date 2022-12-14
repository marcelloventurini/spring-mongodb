package com.marcelloventurini.springmongodb.resources;

import com.marcelloventurini.springmongodb.dto.UserDTO;
import com.marcelloventurini.springmongodb.entities.User;
import com.marcelloventurini.springmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ValueExp;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> list = userService.findAll();
    List<UserDTO> dtoList = list.stream().map(UserDTO::new).toList();
    return ResponseEntity.ok().body(dtoList);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(String id) {
    User user = userService.findById(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }
}
