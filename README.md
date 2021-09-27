### Taxi Service: This service is responsible for:
   1. registering
      - This use case is required to register a Taxi by a driver, a physical
      vehicle with a vehicle type to provide a transportation service to passengers
   2. updating taxi location
      - This use case is required to update the location of a registered Taxi while it moves around
   3. updating taxi status
      - This use case is required to update the status of a registered Taxi such as available, occupied, and so on
   4. getting taxi status
      - This use case is required to get the status of a registered Taxi
   5. searching for taxis in a geographical area
      - This use case is required to search for registered Taxis close to a
      passenger, given a geographical coordinate (latitude, longitude) and a radius in kilometers

### Taxi Booking Service: This service is responsible for:
   1. Book taxi ride
      - This use case is required to book a Taxi ride by a passenger, given a start location, end location, taxi type, and so on
   2. accepting
      - This use case is required to accept a Taxi booking made by a
      passenger by a driver   
   3. canceling
      - This use case is required to cancel a Taxi booking made by a
      passenger, either by the driver or by the passenger
   4. searching for bookings in a geographical area
      - This use case is required to search Taxi Bookings close to a
      driver, given a geographical coordinate (latitude, longitude) and a radius in
      kilometers

### User stories:
   ## As a drive, I want to:
      1. Register taxi
      2. Get taxi status
      3. Update taxi status
      4. Update taxi location
      5. Search Booking
      6. Accept taxi ride
      7. Cancel taxi ride
   ## As a passenger, I want to:
      1. Search taxi
      2. Book taxi ride
      3. Canel taxi ride
   
### Architecture
   - Spring-boot-taxi 
      -- spring-boot-taxi-config (shared common config)
      -- spring-boot-taxi-model (shared common data object)
      -- spring-boot-taxi-service 
      -- spring-boot-taxi-booking-service
### Database 
   - Redis 
      -  The decision was made base highly volatile data such as location of a moving taxi. Also because redis supports its out-of-the-box Geo data.
### The microservices will be placed behind a secure API Gateway that will be responsible for handling the authentication and authorization of users. The API Gateway will be calling the microservices that are internally accessible to it in order to perform taxi and taxi booking actions.Each microservice has a REST API to expose operations of its own to the outside world, and also uses asynchronous communication to communicate among them using a publisher/subscriber model.