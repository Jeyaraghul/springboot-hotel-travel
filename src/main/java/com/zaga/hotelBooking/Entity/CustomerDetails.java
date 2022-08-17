package com.zaga.hotelBooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotel_booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
    @Column(name = "custome_Name")
    private String customerName;
    @Column(name = "hotel_Name")
    private String hotelName;
    @Column(name = "room_Type")
    private String roomType;
    @Column(name = "total_No_Of_Rooms")
    private Integer totalNoOfRooms;
    @Column(name = "email_Address")
    private String emailAddress;
    @Column(name = "check_In_Date")
    private String checkInDate;
    @Column(name = "check_Out_Date")
    private String checkOutDate;
    @Column(name = "booking_Status")
    private String bookingStatus;

    private Long price;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
