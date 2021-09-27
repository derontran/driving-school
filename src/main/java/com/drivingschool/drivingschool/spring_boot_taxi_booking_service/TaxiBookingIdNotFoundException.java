package com.drivingschool.drivingschool.spring_boot_taxi_booking_service;

public class TaxiBookingIdNotFoundException extends RuntimeException{

   public TaxiBookingIdNotFoundException(String message) {
      super(message);
   }

   public TaxiBookingIdNotFoundException(String message, Throwable cause) {
      super(message, cause);
   }

   
}
