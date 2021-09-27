package com.drivingschool.drivingschool.spring_boot_taxi_booking_service;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("TaxiBooking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiBooking {
   @Id
   private Long taxiBookingId;
   private Point start;
   private Date startTime;
   private Point end;
   private Date endTime;
   private Date bookedTime;
   private Date acceptedTime;
   private Long customerId;
   private TaxiBookingStatus bookingStatus;
   private String reasonToCancel;
   private Date cancelTime;
   private String taxiId;
   }
