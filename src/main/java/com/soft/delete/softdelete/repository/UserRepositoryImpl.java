//package com.soft.delete.softdelete.repository;
//
//import com.soft.delete.softdelete.entity.UserDbo;
//import jakarta.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Supplier;
//import org.hibernate.Filter;
//import org.hibernate.Session;
//import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserRepositoryImpl extends SimpleJpaRepository<UserDbo, Long> implements UserRepository {
//
//  private final EntityManager entityManager;
//
//  public UserRepositoryImpl(EntityManager entityManager) {
//    super(JpaEntityInformationSupport.getEntityInformation(UserDbo.class, entityManager), entityManager);
//    this.entityManager = entityManager;
//  }
//
//  @Override
//  public Optional<UserDbo> findById(final Long aLong) {
//    return find(() -> super.findById(aLong), false);
//  }
//
//  @Override
//  public Optional<UserDbo> findDeletedById(final Long aLong) {
//    return find(() -> super.findById(aLong), true);
//  }
//
//  @Override
//  public List<UserDbo> findAll() {
//    return find(super::findAll, false);
//  }
//
//
//  @Override
//  public List<UserDbo> findAllDeleted() {
//    return find(super::findAll, true);
//  }
//
//  private <T> T find(final Supplier<T> supplier, final boolean deleted) {
//    Session session = entityManager.unwrap(Session.class);
//    Filter filter = session.enableFilter("deletedFilter");
//    filter.setParameter("isDeleted", deleted);
//    final var result = supplier.get();
//    filter.setParameter("isDeleted", true);
//    return result;
//  }
//
//}
