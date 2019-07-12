package com.codecool.cakeshop.repository;

import com.codecool.cakeshop.entity.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake, Long> {
}
