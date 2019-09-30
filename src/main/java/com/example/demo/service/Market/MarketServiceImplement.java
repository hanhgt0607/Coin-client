package com.example.demo.service.Market;

import com.example.demo.entity.Market;
import com.example.demo.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class MarketServiceImplement implements MarketService {
    @Autowired
    MarketRepository marketRepository;
    @Override
    public Market store(Market market) {
        try {
            if (market == null) {
                return null;
            }
            market.setStatus(1);
            market.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
            market.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
            return marketRepository.save(market);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Market> marketList() {
        return marketRepository.findAll();
    }
}
