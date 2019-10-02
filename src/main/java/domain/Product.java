package model;

import java.sql.Date;
import java.util.Objects;

public class Product {
    private String name;
    private Double cost;
    private String manufacturer;
    private Date dateOfManufacture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getCost(), getCost()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getManufacturer(), product.getManufacturer()) &&
                Objects.equals(getDateOfManufacture(), product.getDateOfManufacture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCost(), getManufacturer(), getDateOfManufacture());
    }
}
