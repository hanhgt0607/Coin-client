package com.example.demo.repository;

import com.example.demo.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoinRepository extends JpaRepository<Coin, Long> {
    List<Coin> findAllByMarketIdEquals(long id);

    List<Coin> findAllByNameEquals(String name);

    Coin save(Coin coin);

    List<Coin> findAll();
}
