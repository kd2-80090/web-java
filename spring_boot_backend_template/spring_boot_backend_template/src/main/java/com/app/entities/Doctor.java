package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="doctors")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Doctor extends BaseEntity {
	   
   @Column(length = 50)
   private String name;
   
   @Column(length = 30)
   private String special;
	
   @Column(length = 20,unique = true)
   private String email;
   
   @Column(length = 20)
   private String hospital;
   
   @Column(length = 150)
   private String address;
		
}
