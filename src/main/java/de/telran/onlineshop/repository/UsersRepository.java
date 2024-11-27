package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import de.telran.onlineshop.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    @Query("SELECT ce FROM CategoriesEntity ce WHERE ce.name=?1")
    CategoriesEntity findByName(String name);

    @Query(value = "SELECT * FROM Categories ce WHERE ce.Name=?1",  nativeQuery = true)
    UsersEntity findByNameNative(String name);
}
