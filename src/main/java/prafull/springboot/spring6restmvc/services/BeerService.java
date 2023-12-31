package prafull.springboot.spring6restmvc.services;

import prafull.springboot.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteByBeerId(UUID beerId);

    void updateBeerBatch(UUID beerId, Beer beer);
}
