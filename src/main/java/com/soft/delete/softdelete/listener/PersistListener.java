package com.soft.delete.softdelete.listener;

import com.soft.delete.softdelete.entity.Model;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

public class PersistListener {

  @PrePersist
  private void beforeCreate(Model model) {
    model.setCreatedAt(LocalDateTime.now());
  }

  @PreUpdate
  private void beforeUpdate(Model model) {
    model.setUpdatedAt(LocalDateTime.now());
  }
}
