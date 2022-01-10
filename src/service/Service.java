package service;

import model.Offer;
import model.Place;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {
    public List<Offer> getSortedByPrice(List<Offer> offerList) {
        return offerList.stream().sorted((offer1, offer2) -> {
            Double finalPrice1 = ((100 + offer1.getVAT()) * (double) offer1.getPrice()) / 100;
            Double finalPrice2 = ((100 + offer2.getVAT()) * (double) offer2.getPrice()) / 100;

            return finalPrice2.compareTo(finalPrice1);
        }).collect(Collectors.toList());
    }

    public Map<Place, Integer> getStatistics(List<Offer> offerList) {
        Map<Place, Integer> map = new HashMap<>();
        map.put(Place.StGallen, 0);
        map.put(Place.Zurich, 0);
        map.put(Place.Thurgau, 0);


        for (Offer offer : offerList) {
            int income = offer.getPrice();
            int oldInc = map.get(offer.getPlace());
            map.put(offer.getPlace(), oldInc + income);
        }

        return map;
    }
}
