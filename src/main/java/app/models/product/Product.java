package app.models.product;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	
	private int productId;
	@NotNull
	private String productName;
	@NotNull
	private int productPrice;
	private String productDate;
	private String productStatus;

}
