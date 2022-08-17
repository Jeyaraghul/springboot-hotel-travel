package com.zaga.hotelBooking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.hotelBooking.Entity.CustomerDetails;
import com.zaga.hotelBooking.Entity.HotelRoomDetails;
import com.zaga.hotelBooking.repository.RoomsRepo;

@RestController
public class HotelBooking {
    @Autowired
    private RoomsRepo roomrepo;

    @PostMapping("/avail")
    public ResponseEntity<?> roomsAvailabilty(@RequestBody CustomerDetails customer) {
        try {

            System.out.println(customer);
            List<HotelRoomDetails> data = roomrepo.availabilityCheck(customer.getHotelName(), customer.getRoomType(),
                    customer.getTotalNoOfRooms());
            return new ResponseEntity<HotelRoomDetails>(data.get(0), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;

    }

    @PostMapping("/confirm/{id}")
    public ResponseEntity<?> bookingConfirmation(@PathVariable Long id, @RequestBody CustomerDetails customer) {

        Optional<HotelRoomDetails> data = roomrepo.findById(id);
        if (data.isPresent()) {
            HotelRoomDetails room = data.get();
            Integer update = room.getAvailableRooms() - customer.getTotalNoOfRooms();
            room.setAvailableRooms(update);
            return new ResponseEntity<HotelRoomDetails>(roomrepo.save(room), HttpStatus.CREATED);
        }
        return null;
    }

    @PostMapping("/createhotel")
    public ResponseEntity<HotelRoomDetails> createRoomDetails(@RequestBody HotelRoomDetails hotel) {
        try {
            return new ResponseEntity<>(roomrepo.save(hotel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
