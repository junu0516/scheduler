package app.models.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PurchaseHistory {

	private int purchaseHistoryId;
	private String purchaseProduct;
	private int productPrice;
	private int purchaseQuantity;
	private String purchaseDate;
	private String purchaseStatus;
	
}
