package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.enumm.Status;
import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByPerson(Person person);

    @Modifying
    @Query("UPDATE Order orders SET orders.status = ?1 WHERE orders.id = ?2")
    int updateOrderStatus(Status status, int id);

    List<Order> findByNumberEndingWith(String number);




}
