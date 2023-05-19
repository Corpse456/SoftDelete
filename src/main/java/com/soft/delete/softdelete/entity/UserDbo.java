package com.soft.delete.softdelete.entity;

import com.soft.delete.softdelete.listener.PersistListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.annotations.Filter;
//import org.hibernate.annotations.FilterDef;
//import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Setter
@Getter
@Entity(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true, deleted_at = now() WHERE id = ?")
//@FilterDef(name = "deletedFilter", defaultCondition = "false", parameters = @ParamDef(name = "isDeleted", type = boolean.class))
//@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")
@Where(clause = "deleted is false")
@EntityListeners(PersistListener.class)
public class UserDbo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String lastName;

  private boolean deleted;

  private LocalDateTime deletedAt;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

}
