package com.drivingschool.drivingschool.User;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exception.InvalidUserException;

@Service
public class UserService {
   private final UserRepository userRepository;
   Logger logger = LoggerFactory.logger(UserService.class);

   @Autowired
   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public List<User> getAllUsers() {
      List<User> allUser = userRepository.findAll();
      logger.info("Number of users: " + allUser.size());

      User newuser;
      for (int i = 0; i < 1000; i++) {
         newuser = new User();
         newuser.setName("John" + i);
         logger.info("Saving new user...");
         userRepository.save(newuser);
      }

      allUser = userRepository.findAll();
      logger.info("Number of users: " + allUser.size());
      // return List.of(new User("user1", "user1asd@gmail.com"));
      return userRepository.findAll();
   }

   public void addUser(User newUser) {
      Optional<User> userByEmail = userRepository.findStudentByEmail(newUser.getEmail());
      if (userByEmail.isPresent()) {
         throw new IllegalStateException("Email taken");
      }
      userRepository.save(newUser);

   }

   public void deleteUser(Long id) {
      boolean isExist = userRepository.existsById(id);
      if (!isExist) {
         throw new IllegalStateException("User with id " + id + "does not exits");
      }
      userRepository.deleteById(id);

   }

   @Transactional
   public void updateUser(Long id, String name, String email) throws InvalidUserException {
      Optional<User> existingUserOptional = userRepository.findById(id);

      if (!existingUserOptional.isPresent()) {
         throw new IllegalStateException("user with id " + id + " does not exits");
      }
      User existingUser = existingUserOptional.get();
      UserValidation.validateName(name, existingUser.getName());
      UserValidation.validateEmail(email, existingUser.getEmail());

      existingUser.setName(name);
      existingUser.setEmail(email);
   }
}
