package com.gen.TropicoBoards.Model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    private Long id_products;

    @Column(name = "product_name", nullable = false)
    private String product_name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Column(name = "image", nullable = false)
    private String image;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Products_has_Orders> orderProducts;

    // Constructor vacío
    public Products() {

    }
    
    // Constructores
    public Products(Long id_products, String product_name, String description, BigDecimal price, Long stock,
			String image) {
		super();
		this.id_products = id_products;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}

	
    // Getters y Setters
 
    public Long getId_products() {
		return id_products;
	}

	public void setId_products(Long id_products) {
		this.id_products = id_products;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Products_has_Orders> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<Products_has_Orders> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(id_products, products.id_products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_products);
    }

    @Override
    public String toString() {
        return "Products{" +
                "idProducts=" + id_products +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}