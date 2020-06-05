package com.example.demo.repository;

import com.example.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Asus on 05-Jun-20.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
