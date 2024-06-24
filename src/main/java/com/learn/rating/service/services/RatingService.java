package com.learn.rating.service.services;

import com.learn.rating.service.Exception.NotFoundException;
import com.learn.rating.service.model.Rating;
import com.learn.rating.service.repository.Ratingrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    Ratingrepository ratingrepository;

    public Rating featchrating(String name){

        Rating rateting = ratingrepository.findByName(name);

        if(rateting == null){
            throw new NotFoundException(" >>> Movie Not Found With that Name "+ name);
        }else{
            return rateting;
        }
    }

    public Rating updateRating(String name, double star){

        Rating rateing = ratingrepository.findByName(name);

        if(rateing == null){
            rateing = new Rating();
            rateing.setName(name);
            rateing.setAvgrateing(star);
            rateing.setCount(1L);
        }else {
            rateing.setCount(rateing.getCount()+1);
            rateing.setAvgrateing( (rateing.getAvgrateing() * rateing.getCount() + star)/(rateing.getCount() + 1)  );
        }

        return ratingrepository.save(rateing);

    }



}