package com.example.demo.service.Coin;

import com.example.demo.entity.Coin;
import com.example.demo.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CoinServiceImplement implements CoinService {
    @Autowired
    CoinRepository coinRepository;
    @Override
    public Coin store(Coin coin) {
        try {
            if (coin == null){
                return null;
            }
            coin.setStatus(1);
            coin.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
            coin.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
            return coinRepository.save(coin);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Coin> coinList() {
        return coinRepository.findAll();
    }

    @Override
    public List<Coin> findCoinByName(String name) {
        return coinRepository.findAllByNameEquals(name);
    }

    @Override
    public List<Coin> findCoinByMarket(long id) {
        return coinRepository.findAllByMarketIdEquals(id);
    }
}
