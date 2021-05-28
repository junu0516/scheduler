package app.models.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.conf.MainRepository;
import app.conf.SDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	MainRepository mainRepository;
	
	@Override
	public int insertProduct(Product product) throws Exception {
		
		Map productInsertMap = new ObjectMapper().convertValue(product, Map.class);
		
		int result = mainRepository.insertProduct("insertProduct",productInsertMap);
		return result;
	}

	@Override
	public List<Product> selectProducts() throws Exception {
		
		return mainRepository.selectProducts("selectProducts");
	}
}
