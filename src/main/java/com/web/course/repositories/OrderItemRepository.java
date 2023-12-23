package com.web.course.repositories;

import com.web.course.entities.OrderItem;
import com.web.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{


}
