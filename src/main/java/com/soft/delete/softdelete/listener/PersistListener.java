package com.soft.delete.softdelete.listener;

import com.soft.delete.softdelete.entity.UserDbo;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

public class PersistListener {

  @PrePersist
  private void beforeCreate(UserDbo user) {
    user.setCreatedAt(LocalDateTime.now());
  }

  @PreUpdate
  private void beforeUpdate(UserDbo user) {
    user.setUpdatedAt(LocalDateTime.now());
  }
}
