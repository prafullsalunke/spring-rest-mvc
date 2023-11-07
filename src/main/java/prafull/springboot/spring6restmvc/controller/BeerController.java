package prafull.springboot.spring6restmvc.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import prafull.springboot.spring6restmvc.model.Beer;
import prafull.springboot.spring6restmvc.services.BeerService;

import java.util.UUID;

@Slf4j
@Controller
@AllArgsConstructor
public class BeerController {
    private final BeerService beerService;
    public Beer getBeerById(UUID id){
        log.debug("Get Beer by Id - in controller");
        return beerService.getBeerById(id);
    }
}
