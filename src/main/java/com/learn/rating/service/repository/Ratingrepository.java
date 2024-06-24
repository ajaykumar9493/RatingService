package com.learn.rating.service.repository;

import com.learn.rating.service.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ratingrepository extends JpaRepository<Rating,Long> {

    Rating findByName(String name);
    List<Rating> findAllByAvgrateingBetween(double min, double max);

}
