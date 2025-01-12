package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CartItemsEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//
//@Repository
public interface CartItemsRepository extends JpaRepository<CartItemsEntity, Long> {
    @Override
    <S extends CartItemsEntity> List<S> findAll(Example<S> example);
}
