package com.training.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Model class
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jwaproducts")
public class Product {
	
		@Id
		private int productId;
	
		private String productName;
		private int quantityOnHand;
		private int price;

		
}
