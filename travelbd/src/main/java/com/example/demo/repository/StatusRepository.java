package com.example.demo.repository;

import com.example.demo.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asus on 05-Jun-20.
 */
@Repository
public interface StatusRepository extends JpaRepository<UserStatus,Long> {
    List<UserStatus> findByPrivacyId(long publicId);

    List<UserStatus> findByUserId(long userId);
}
