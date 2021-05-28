package app.models.product;

import java.util.List;

public interface ProductService {

	int insertProduct(Product product) throws Exception;

	List<Product> selectProducts() throws Exception;

		
}
