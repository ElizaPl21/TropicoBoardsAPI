package com.gen.TropicoBoards.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders")
    private Long id_orders;

    @Column(name = "order_date", nullable = false)
    private Date order_date;

    @Column(name = "order_status", nullable = false)
    private String order_status;

    @ManyToOne
    @JoinColumn(name = "Payments_id_payments", nullable = false)
    private Payments payments;

    @ManyToOne
    @JoinColumn(name = "Users_id_users", nullable = false)
    private Users users;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Products_has_Orders> orderProducts;

    // Constructor vacío
    public Orders() {

    }

    // Constructores
    public Orders(Long id_orders, Date order_date, String order_status, Payments payments, Users users) {
        this.id_orders = id_orders;
        this.order_date = order_date;
        this.order_status = order_status;
        this.payments = payments;
        this.users = users;
    }

    // Getters y Setters
    
    public Long getId_orders() {
		return id_orders;
	}

	public void setId_orders(Long id_orders) {
		this.id_orders = id_orders;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
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
        Orders orders = (Orders) o;
        return Objects.equals(id_orders, orders.id_orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_orders);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrders=" + id_orders +
                ", order_date=" + order_date +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}