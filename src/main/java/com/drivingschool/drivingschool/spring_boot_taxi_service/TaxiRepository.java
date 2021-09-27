package com.drivingschool.drivingschool.spring_boot_taxi_service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Remove @RepositoryRestResource below to disable auto REST api:
@Repository
public interface TaxiRepository extends CrudRepository<Taxi, Long> {
}
