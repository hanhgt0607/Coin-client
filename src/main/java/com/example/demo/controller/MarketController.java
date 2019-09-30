package com.example.demo.controller;

import com.example.demo.entity.JsonResponse;
import com.example.demo.entity.Market;
import com.example.demo.service.Market.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/market")
public class MarketController {
    @Autowired
    MarketService marketService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> markets() {
        try {
            List<Market> markets = marketService.marketList();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success!")
                    .setMetaData(markets), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Market market) {
        try {
            if (market == null)
                return new ResponseEntity<>(new JsonResponse()
                        .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                        .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_CREATED)
                    .setMessage("Create success!")
                    .setMetaData(marketService.store(market)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
