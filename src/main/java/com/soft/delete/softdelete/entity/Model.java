package com.soft.delete.softdelete.entity;

import java.time.LocalDateTime;

public interface Model {

  Long getId();

  String getName();

  String getLastName();

  boolean isDeleted();

  LocalDateTime getDeletedAt();

  void setCreatedAt(LocalDateTime createdAt);

  void setUpdatedAt(LocalDateTime updatedAt);


}
