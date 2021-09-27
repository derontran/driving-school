package com.drivingschool.drivingschool.spring_boot_taxi_service;

import java.util.Optional;

import com.drivingschool.drivingschool.spring_boot_taxi_service.exception.TaxiIdNotFoundException;
import com.drivingschool.drivingschool.spring_boot_taxi_service.exception.getTaxiIdNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaxiService {
   private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
   private final TaxiRepository taxiRepository;
   private final LocationToPointConverter locationToPointConverter = new LocationToPointConverter();

   @Autowired
   public TaxiService(ReactiveRedisTemplate<String, String> reactiveRedisTemplate,
                      TaxiRepository taxiRepository) {
      this.reactiveRedisTemplate = reactiveRedisTemplate;
      this.taxiRepository = taxiRepository;

   public Mono<Taxi> register(TaxiRegisterEventDTO taxiRegisterEventDTO) {
      Taxi taxi = new Taxi(taxiRegisterEventDTO.getTaxiId(), taxiRegisterEventDTO.getTaxiType(), TaxiStatus.AVAILABLE);
      return Mono.just(taxiRepository.save(taxi));

   }

   public Mono<Taxi> updateLocation(Long taxiId, LocationDTO locationDTO) {
      Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
      if(taxiOptional.isPresent()){
         Taxi taxi = taxiOptional.get(); 
         return reactiveRedisTemplate.opsForGeo()
               .add(taxi.getTaxiType().toString(), LocationToPointConverter.convert(locationDTO), taxiId.toString())
               .flatMap(l -> Mono.just(taxi));
      }else{
         throw getTaxiIdNotFoundException(taxiId);
      }; 

   }

   public Flux<GeoResult<RedisGeoCommands.GeoLocation<String>>> getAvailableTaxis(TaxiType taxiType, Double latitude,
         Double longitude, Double radius) {
      return reactiveRedisTemplate.opsForGeo().radius(taxiType.toString(),
            new Circle(new Point(longitude, latitude), new Distance(radius, Metrics.KILOMETERS)));
   }

   public Mono<TaxiStatus> getTaxiStatus(Long taxiId) {
      Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
      if (taxiOptional.isPresent()) {
         Taxi taxi = taxiOptional.get();
         return Mono.just(taxi.getTaxiStatus());
      } else {
         throw getTaxiIdNotFoundException(taxiId);
      }
   }

   public Mono<Taxi> updateTaxiStatus(Long taxiId, TaxiStatus taxiStatus) {
      Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
      if (taxiOptional.isPresent()) {
         Taxi taxi = taxiOptional.get();
         taxi.setTaxiStatus(taxiStatus);
         return Mono.just(taxiRepository.save(taxi));
      } else {
         throw getTaxiIdNotFoundException(taxiId);
      }
   }

   private TaxiIdNotFoundException getTaxiIdNotFoundException(Long taxiId) {
      return new TaxiIdNotFoundException("Taxi Id " + taxiId + " Not Found");
   }

}
