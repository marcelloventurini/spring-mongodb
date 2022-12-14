package com.marcelloventurini.springmongodb.resources;

import com.marcelloventurini.springmongodb.dto.UserDTO;
import com.marcelloventurini.springmongodb.entities.User;
import com.marcelloventurini.springmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> list = userService.findAll();
    List<UserDTO> dtoList = list.stream().map(o -> new UserDTO(o)).toList();
    return ResponseEntity.ok().body(dtoList);
  }
}
