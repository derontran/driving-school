package com.drivingschool.drivingschool.spring_boot_taxi_booking_service;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TaxiBookingRepository extends CrudRepository<TaxiBooking,Long> {

}
