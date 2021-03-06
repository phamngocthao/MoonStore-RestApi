package com.moon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"Username","Roleid"})
})
public class Authority implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne
	@JoinColumn(name = "Username")
	Account account;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Roleid")
	Role role;	
}
