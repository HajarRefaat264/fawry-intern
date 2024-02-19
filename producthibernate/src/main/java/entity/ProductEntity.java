package entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "product", schema = "product_repo")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private double price;
    public ProductEntity(String name, double price){
        this.name=name;
        this.price=price;
    }

    public ProductEntity() {

    }
    public ProductEntity(int id,String name, double price) {
        this.name=name;
        this.price=price;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




}
