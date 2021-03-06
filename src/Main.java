import model.Offer;
import repository.Repository;
import service.Service;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Offer> offerList, sortedOffers;
        Repository repo = new Repository();
        Service service = new Service();
        try {
            offerList = repo.readFromFile("D:\\Java projects\\Calin Andi 721 - Ubung 1\\src\\offerten.txt");
            sortedOffers = service.getSortedByPrice(offerList);
            for (Offer offer : sortedOffers)
                System.out.println(offer);
            repo.writeToFile(sortedOffers, "D:\\Java projects\\Calin Andi 721 - Ubung 1\\src\\offersortiert.txt");
            repo.writeStatistics(service.getStatistics(offerList), "D:\\Java projects\\Calin Andi 721 - Ubung 1\\src\\statistik.txt");
        }
        catch (IOException exc) {
            System.out.println(exc.getStackTrace());
        }
    }
}
