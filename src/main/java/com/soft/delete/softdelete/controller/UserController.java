package com.soft.delete.softdelete.controller;

import com.soft.delete.softdelete.dto.UserDto;
import com.soft.delete.softdelete.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @PostMapping
  public UserDto postUser(@RequestBody UserDto request) {
    return service.postUser(request);
  }

  @GetMapping
  public List<UserDto> getAllUsers() {
    return service.getAllUsers();
  }

  @GetMapping("/deleted")
  public List<UserDto> getAllDeletedUsers() {
    return service.getAllDeletedUsers();
  }

  @GetMapping("/{id}")
  public UserDto getUserById(@PathVariable("id") Long id) {
    return service.getUserById(id);
  }

  @GetMapping("/deleted/{id}")
  public UserDto getDeletedUserById(@PathVariable("id") Long id) {
    return service.getDeletedUserById(id);
  }

  @PutMapping("/{id}")
  public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto request) {
    return service.updateUser(id, request);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    service.deleteUser(id);
  }
}
