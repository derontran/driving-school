package com.drivingschool.drivingschool.spring_boot_taxi_service;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@RedisHash("Taxi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taxi {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(updatable = false, nullable = false)
   Long taxiId; 
   TaxiType taxiType; 
   TaxiStatus taxiStatus;


   public Taxi(TaxiType taxiType, TaxiStatus taxiStatus) {
      this.taxiType = taxiType;
      this.taxiStatus = taxiStatus;
   }


   public Taxi(Long taxiId2, Object taxiType2, TaxiStatus available) {
   } 
   


   
   

   

}
