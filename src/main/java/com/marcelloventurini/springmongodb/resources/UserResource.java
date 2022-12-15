package com.marcelloventurini.springmongodb.resources;

import com.marcelloventurini.springmongodb.dto.UserDTO;
import com.marcelloventurini.springmongodb.entities.User;
import com.marcelloventurini.springmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User user = userService.findById(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
    User user = userService.fromDTO(userDTO);
    user = userService.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
