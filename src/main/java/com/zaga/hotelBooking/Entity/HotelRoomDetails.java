package com.zaga.hotelBooking.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotel_room_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hotelName;
    private String roomType;
    private Integer availableRooms;
    private Long contactPhoneNo;

}
