package prafull.springboot.spring6restmvc.services;

import prafull.springboot.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
