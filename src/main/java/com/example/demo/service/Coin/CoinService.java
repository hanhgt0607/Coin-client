package com.example.demo.service.Coin;

import com.example.demo.entity.Coin;
import java.util.List;
public interface CoinService {

    Coin store(Coin coin);

    List<Coin> coinList();

    List<Coin> findCoinByName(String name);

    List<Coin> findCoinByMarket(long id);
}
