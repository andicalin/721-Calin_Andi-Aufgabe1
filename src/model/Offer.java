package model;

public class Offer {
    private final int id;
    private final String companyName;
    private final int price;
    private final double VAT;
    private final String address;
    private final Place place;

    public Offer(int id, String companyName, int price, double VAT, String address, Place place) {
        this.id = id;
        this.companyName = companyName;
        this.price = price;
        this.VAT = VAT;
        this.address = address;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPrice() {
        return price;
    }

    public double getVAT() {
        return VAT;
    }

    public String getAddress() {
        return address;
    }

    public Place getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", price=" + price +
                ", VAT=" + VAT +
                ", address='" + address + '\'' +
                ", place=" + place +
                '}';
    }
}
