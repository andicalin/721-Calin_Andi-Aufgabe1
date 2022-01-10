package repository;

import model.Offer;
import model.Place;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Repository {

    public Repository() {
    }

    public List<Offer> readFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        String[] tokens;
        Offer offer;
        List<Offer> offerList = new ArrayList<>();
        while (line != null) {
            tokens = line.split("&");
            Place place = null;
            if (tokens[5].equals("Thurgau"))
                place = Place.Thurgau;
            else if (tokens[5].equals("Zürich"))
                place = Place.Zurich;
            else if (tokens[5].equals("St. Gallen"))
                place = Place.StGallen;
            offer = new Offer(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]), tokens[4], place);

            offerList.add(offer);

            line = bufferedReader.readLine();
        }

        return offerList;
    }

    public void writeToFile(List<Offer> offerList, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Offer offer : offerList) {
            String line = offer.getId() + "&" + offer.getCompanyName() + "&" +
                    offer.getPrice() + "&" + offer.getVAT() + "&" + offer.getAddress() + "&" + offer.getPlace();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    public void writeStatistics(Map<Place, Integer> incomes, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<Place, Integer> entry : incomes.entrySet()) {
            String line = entry.getKey() + ": " + entry.getValue();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
