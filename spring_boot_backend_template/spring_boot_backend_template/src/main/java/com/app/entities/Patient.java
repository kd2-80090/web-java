package com.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="patients")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Patient extends BaseEntity{
	
	 @Column(length = 50)
	private String name;
	
	@Column(length = 20)
	private String bloodGroup;
	
	@Column(length = 20, unique = true)
	private String email;
	
	@Column(length = 10)
	private String mobile;
	
}
