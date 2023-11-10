package com.gen.TropicoBoards.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.TropicoBoards.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
