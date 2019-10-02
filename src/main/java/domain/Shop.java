package model;

import java.util.List;
import java.util.Objects;

public class Shop {
    private String name;
    private String phoneNumber;
    private TypeOfShop type;
    private Integer numberOfCashDesk;
    private Boolean deliverable;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TypeOfShop getType() {
        return type;
    }

    public void setType(TypeOfShop type) {
        this.type = type;
    }

    public Integer getNumberOfCashDesk() {
        return numberOfCashDesk;
    }

    public void setNumberOfCashDesk(Integer numberOfCashDesk) {
        this.numberOfCashDesk = numberOfCashDesk;
    }

    public Boolean getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(Boolean deliverable) {
        this.deliverable = deliverable;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Shop)) return false;
        if (!super.equals(object)) return false;
        Shop shop = (Shop) object;
        return java.util.Objects.equals(name, shop.name) &&
                java.util.Objects.equals(phoneNumber, shop.phoneNumber) &&
                java.util.Objects.equals(type, shop.type) &&
                java.util.Objects.equals(numberOfCashDesk, shop.numberOfCashDesk) &&
                java.util.Objects.equals(deliverable, shop.deliverable) &&
                java.util.Objects.equals(products, shop.products);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, phoneNumber, type, numberOfCashDesk, deliverable, products);
    }
}
