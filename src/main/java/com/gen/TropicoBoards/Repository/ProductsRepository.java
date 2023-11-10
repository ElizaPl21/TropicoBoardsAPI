package com.gen.TropicoBoards.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.TropicoBoards.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}
