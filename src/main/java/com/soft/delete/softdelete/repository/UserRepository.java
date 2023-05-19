package com.soft.delete.softdelete.repository;

import com.soft.delete.softdelete.entity.UserDbo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
//@NoRepositoryBean
public interface UserRepository extends JpaRepository<UserDbo, Long> {

  @Query(value = "select * from users e where e.deleted is true and id = ?1", nativeQuery = true)
  Optional<UserDbo> findDeletedById(Long aLong);

  @Query(value = "select * from users e where e.deleted is true", nativeQuery = true)
  List<UserDbo> findAllDeleted();
}
