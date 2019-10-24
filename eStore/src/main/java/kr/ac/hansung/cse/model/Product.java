package kr.ac.hansung.cse.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -567117648902464025L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int id;
	
	@NotEmpty(message="The product name must not be null")
	private String name;
	
	private String category;
	
	@Min(value=0, message="The product price must be less than zero")
	private int price;
	
	@NotEmpty(message="The product manufacturer must not be null")
	private String manufacturer;
	
	@Min(value=0, message="The product unitInStock must be less than zero")
	private int unitInStock;
	
	private String description;
	
	@Transient
	private MultipartFile productImage;
	
	private String imageFilename;
	
}
