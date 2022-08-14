package com.rangel.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rangel.workshopmongo.domain.User;
import com.rangel.workshopmongo.dto.UserDTO;
import com.rangel.workshopmongo.repository.UserRepository;
import com.rangel.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        if (user.get() == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user.get();
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
