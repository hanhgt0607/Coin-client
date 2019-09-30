package com.example.demo.controller;

import com.example.demo.entity.Coin;
import com.example.demo.entity.JsonResponse;
import com.example.demo.service.Coin.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/coin")
public class CoinController {

    @Autowired
    CoinService coinService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> coins() {
        try {
            List<Coin> coins = coinService.coinList();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success!")
                    .setMetaData(coins), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Coin coin) {
        try {
            if (coin == null)
                return new ResponseEntity<>(new JsonResponse()
                        .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                        .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_CREATED)
                    .setMessage("Create success!")
                    .setMetaData(coinService.store(coin)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.GET,value = "/name/{name}")
    public ResponseEntity<Object> findCoinByName(@PathVariable String name) {
        try {
            if (name == null){
                return coins();
            }
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success !")
                    .setMetaData(coinService.findCoinByName(name)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET ,value = "/marketId/{marketId}")
    public ResponseEntity<Object> findCoinByMarketId(@PathVariable Long marketId) {
        try {
            if (marketId == null){
                return coins();
            }
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success !")
                    .setMetaData(coinService.findCoinByMarket(marketId)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
