package prafull.springboot.spring6restmvc.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prafull.springboot.spring6restmvc.model.Beer;
import prafull.springboot.spring6restmvc.services.BeerService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PostMapping
    public ResponseEntity handlPost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping(value ="{beerId}", method = RequestMethod.GET)
    public Beer getBeerByI(@PathVariable("beerId") UUID beerId){
        log.debug("Get Beer by Id in controller 123 " +beerId);
        return beerService.getBeerById(beerId);
    }
}
