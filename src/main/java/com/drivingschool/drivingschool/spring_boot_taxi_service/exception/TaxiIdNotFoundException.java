package com.drivingschool.drivingschool.spring_boot_taxi_service.exception;

public class TaxiIdNotFoundException extends RuntimeException{

   public TaxiIdNotFoundException(String message) {
      super(message);
   }

   public TaxiIdNotFoundException(String message, Throwable cause) {
      super(message, cause);
   }

   
}
