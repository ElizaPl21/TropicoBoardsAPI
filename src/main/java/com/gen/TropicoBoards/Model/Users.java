package com.gen.TropicoBoards.Model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Long id_users;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Orders> orders;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payments> payments;

    // Constructor vacío
    public Users() {

    }
    
    // Constructores
    public Users(Long id_users, String user_name, String last_name, String email, String password) {
		super();
		this.id_users = id_users;
		this.user_name = user_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

    // Getters y Setters
   

    public Long getId_users() {
		return id_users;
	}

	public void setId_users(Long id_users) {
		this.id_users = id_users;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<Payments> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payments> payments) {
		this.payments = payments;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id_users, users.id_users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_users);
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUsers=" + id_users +
                ", user_name='" + user_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}