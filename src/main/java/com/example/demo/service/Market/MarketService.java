package com.example.demo.service.Market;

import com.example.demo.entity.Market;
import java.util.List;
public interface MarketService {
    Market store(Market market);

    List<Market> marketList();
}
