package com.idanuda.simplespringapplication.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Repository
public class SwapiRepository {

    @Value("${swapi-url}")
    private String swapiBaseUrl;

    public SwapiRepository() {

    }

    @Cacheable("people")
    public Map getPeople (Integer id) {
        Mono<Map> response = WebClient.create(swapiBaseUrl)
                        .get()
                        .uri(uriBuilder -> uriBuilder
                                .path("api/people/{id}")
                                .build(id))
                        .retrieve().bodyToMono(Map.class);

        return response.block();
    }

    @Cacheable("allPeople")
    public Map getAllPeople (Integer page) {
        Mono<Map> response = WebClient.create(swapiBaseUrl)
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("api/people/")
                        .queryParam("page", page)
                        .build())
                .retrieve().bodyToMono(Map.class);

        return response.block();
    }
}
