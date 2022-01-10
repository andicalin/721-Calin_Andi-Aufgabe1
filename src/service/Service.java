package service;

import model.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public List<Offer> getSortedByPrice(List<Offer> offerList) {
        return offerList.stream().sorted((offer1, offer2) -> {
            Double finalPrice1 = (100 + offer1.getVAT()) * (double) offer1.getPrice() / 100;
            Double finalPrice2 = (100 + offer1.getVAT()) * (double) offer1.getPrice() / 100;

            return finalPrice1.compareTo(finalPrice2);
        }).collect(Collectors.toList());
    }
}
