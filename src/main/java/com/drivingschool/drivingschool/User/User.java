package com.drivingschool.drivingschool.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(updatable = false, nullable = false)
   private Long Id; 

   private String name; 
   private String email;

   
   public User(String name, String email) {
      this.name = name;
      this.email = email;
   }

   // public User() {
   // }
   // public User(String name,
   //             String email) {
   //    this.name = name;
   //    this.email = email;
   // }
   // public User(Long id, 
   //             String name, 
   //             String email) {
   //    this.Id = id;
   //    this.name = name;
   //    this.email = email;
   // }

   // @Override
   // public String toString() {
   //    return "User [email=" + email + ", id=" + Id + ", name=" + name + "]";
   // }
   // public Long getId() {
   //    return Id;
   // }
   // public void setId(Long id) {
   //    this.Id = id;
   // }
   // public String getName() {
   //    return name;
   // }
   // public void setName(String name) {
   //    this.name = name;
   // }
   // public String getEmail() {
   //    return email;
   // }
   // public void setEmail(String email) {
   //    this.email = email;
   // } 
   
}
