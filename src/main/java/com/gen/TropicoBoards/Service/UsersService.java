package com.gen.TropicoBoards.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.TropicoBoards.Model.Users;
import com.gen.TropicoBoards.Repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    public Optional<Users> getUserById(Long userId) {
        return usersRepository.findById(userId);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}