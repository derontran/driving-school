package com.drivingschool.drivingschool.User;

import Exception.InvalidUserException;

public class UserValidation {
   public static void validateName(String name) throws InvalidUserException {
      if (name == null || name.length() <= 0) {
         throw new InvalidUserException("Invalid user name, user should not be empty");
      }

   }

   public static void validateName(String newName, String oldName) throws InvalidUserException {
      if (newName == null || newName.length() <= 0)
         throw new InvalidUserException("Invalid user name, user should not be empty");
      if (newName.equals(oldName)) {
         throw new InvalidUserException("Invalid user name, user name taken");
      }

   }

   public static void validateEmail(String email) throws InvalidUserException {
      if (email == null || email.length() <= 0) {
         throw new InvalidUserException("Invalid email, email should not be empty");
      }
   }

   public static void validateEmail(String newEmail, String oldEmail) throws InvalidUserException {
      if (newEmail == null || newEmail.length() <= 0)
         throw new InvalidUserException("Invalid email , email should not be empty");
      if (newEmail.equals(oldEmail)) {
         throw new InvalidUserException("Invalid email, email name taken");
      }
   }
}
