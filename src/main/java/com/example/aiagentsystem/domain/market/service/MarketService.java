package com.example.aiagentsystem.domain.market.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MarketService {

    @Cacheable(value = "marketData", key = "#symbol")
    public Mono<MarketData> getMarketData(String symbol) {
        // This is just an example. In a real implementation, this would fetch data from an external service
        return Mono.defer(() -> {
            // Simulate external API call
            return Mono.just(new MarketData(symbol, 100.0, 101.0));
        });
    }
}

record MarketData(String symbol, double bid, double ask) {}
