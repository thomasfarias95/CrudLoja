package com.web.course.config;

import com.web.course.entities.*;
import com.web.course.entities.enums.OrderStatus;
import com.web.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void run(String... args) throws Exception{

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur", 90.5,"");
        Product p2 = new Product(null, "Smart Tv", "Nulla eu imperdiet purs. Maecenas ante", 2190.0,"");
        Product p3 = new Product(null, "Pc Gamer", "Donec aliquet odio ac rhoncus cursus.", 1250.0,"");
        Product p4 = new Product(null, "Macbook", "Nam eleifend maximus tortor, at nollis", 1200.0,"");
        Product p5 = new Product(null, "Rails for Dumiens", "Cras fringilla convallis sem vel faucibus", 100.99,"");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User (null, "Maria Brown", "mariabrown@gmail.com", "81988888888", "12345678");
        User u2 = new User (null, "Alex Green", "alexgreen@gmail.com", "8198747358", "12345678900");

        Order o1 = new Order(null, Instant.parse("2023-12-18T09:00:15z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-12-18T09:00:40z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-12-18T09:01:15z"),OrderStatus.DELIVERED, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

       Payment pay1 = new Payment(null,Instant.parse("2023-12-18T11:30:15z"),o1 );
        o1.setPayment(pay1);


       orderRepository.save(o1);

    }
}
