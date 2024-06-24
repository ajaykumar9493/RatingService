package com.learn.rating.service.controller;

import com.learn.rating.service.model.Rating;
import com.learn.rating.service.model.RequestRating;
import com.learn.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/getrating")
    public ResponseEntity<Rating> getRating(@RequestParam String name){

        System.out.println(">> Inside GetRating for movie ::: "+name);
        Rating rating=ratingService.featchrating(name);
        return ResponseEntity.ok(rating);
    }

    @PostMapping("/updateRating")
    public ResponseEntity<Rating> updateRating(@RequestBody RequestRating requestrating){
        System.out.println(">> Inside updateRating ::: ");
        Rating updatedrating = ratingService.updateRating(requestrating.getName(),requestrating.getStar());
        return ResponseEntity.ok(updatedrating);
    }


}
