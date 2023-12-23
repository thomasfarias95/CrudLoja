package com.web.course.repositories;

import com.web.course.entities.Order;
import com.web.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long>{


}
