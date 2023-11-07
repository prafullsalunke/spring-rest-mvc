package prafull.springboot.spring6restmvc.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import prafull.springboot.spring6restmvc.model.Beer;
import prafull.springboot.spring6restmvc.model.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Get Beer ID in service was called : "+id);
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Beera")
                .beerStyle(BeerStyle.LAGER)
                .upc("7653345")
                .price(new BigDecimal("254"))
                .quantityOnHand(223)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
