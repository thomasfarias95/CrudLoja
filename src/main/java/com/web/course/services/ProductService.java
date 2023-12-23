package com.web.course.services;

import com.web.course.entities.Product;
import com.web.course.entities.User;
import com.web.course.repositories.ProductRepository;
import com.web.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public  Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }


}
