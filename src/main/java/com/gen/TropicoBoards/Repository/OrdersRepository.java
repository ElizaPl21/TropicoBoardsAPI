package com.gen.TropicoBoards.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.TropicoBoards.Model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
 
}