package com.zaga.hotelBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zaga.hotelBooking.Entity.HotelRoomDetails;

public interface RoomsRepo extends JpaRepository<HotelRoomDetails, Long> {
    @Query("SELECT c FROM HotelRoomDetails c WHERE hotel_name = ?1 AND room_type = ?2 AND available_rooms >= ?3")
    List<HotelRoomDetails> availabilityCheck(String hotelName, String roomType, Integer availableRooms);

}
