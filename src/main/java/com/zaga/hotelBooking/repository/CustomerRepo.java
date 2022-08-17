package com.zaga.hotelBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaga.hotelBooking.Entity.CustomerDetails;

public interface CustomerRepo extends JpaRepository<CustomerDetails, Long> {

}
