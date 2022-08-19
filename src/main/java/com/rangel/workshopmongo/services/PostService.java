package com.rangel.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rangel.workshopmongo.domain.Post;
import com.rangel.workshopmongo.repository.PostRepository;
import com.rangel.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        if (post.get() == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return post.get();
    }
}
