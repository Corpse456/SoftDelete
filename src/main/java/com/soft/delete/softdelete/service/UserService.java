package com.soft.delete.softdelete.service;

import com.soft.delete.softdelete.dto.UserDto;
import com.soft.delete.softdelete.mapper.UserMapper;
import com.soft.delete.softdelete.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  private final UserMapper mapper;

  public UserDto postUser(UserDto request) {
    final var userDbo = mapper.toDbo(request);
    final var savedUser = repository.save(userDbo);
    return mapper.toDto(savedUser);
  }

  public List<UserDto> getAllUsers() {
    final var all = repository.findAll();
    final var allDeleted = repository.findAllDeleted();
    System.out.println(allDeleted);
    return mapper.toDto(all);
  }

  public List<UserDto> getAllDeletedUsers() {
    final var allDeleted = repository.findAllDeleted();
    return mapper.toDto(allDeleted);
  }

  public UserDto getUserById(Long id) {
    final var user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
    return mapper.toDto(user);
  }

  public UserDto getDeletedUserById(Long id) {
    final var user = repository.findDeletedById(id).orElseThrow(EntityNotFoundException::new);
    return mapper.toDto(user);
  }

  public UserDto updateUser(Long id, UserDto request) {
    final var user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
    user.setName(request.getName());
    user.setLastName(request.getLastName());
    return mapper.toDto(repository.save(user));
  }

  public void deleteUser(Long id) {
    repository.deleteById(id);
  }

}
