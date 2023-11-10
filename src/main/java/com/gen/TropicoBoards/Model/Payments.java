package com.gen.TropicoBoards.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payments")
    private Long id_payments;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "card", nullable = false)
    private Long card;

    @ManyToOne
    @JoinColumn(name = "Users_id_users", nullable = false)
    private Users users;

    // Constructor vacío
    public Payments() {

    }
    // Constructores
    public Payments(Long id_payments, String address, Long card, Users users) {
		super();
		this.id_payments = id_payments;
		this.address = address;
		this.card = card;
		this.users = users;
	}


    // Getters y Setters

    public Long getId_payments() {
		return id_payments;
	}
	public void setId_payments(Long id_payments) {
		this.id_payments = id_payments;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCard() {
		return card;
	}
	public void setCard(Long card) {
		this.card = card;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return Objects.equals(id_payments, payments.id_payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_payments);
    }

    @Override
    public String toString() {
        return "Payments{" +
                "idPayments=" + id_payments +
                ", address='" + address + '\'' +
                '}';
    }
}