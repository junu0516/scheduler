package app.conf;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import app.models.product.Product;
import app.models.purchase.PurchaseHistory;

@Repository
public class MainRepositoryImpl implements MainRepository {
	
	@Resource(name="sessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int insertProduct(String queryId, Map productInsertMap) throws Exception {
		
		return template.insert(queryId, productInsertMap);
	}

	@Override
	public List<Product> selectProducts(String queryId) throws Exception {
		
		return template.selectList(queryId);
	}

	@Override
	public int insertHistory(String queryId, Map historyInsertMap) {
		
		return template.insert(queryId,historyInsertMap);
	}

	@Override
	public List<PurchaseHistory> selectHistories(String queryId) {
		
		return template.selectList(queryId);
	}

	@Override
	public List<Integer> selectAllNotPaidLists(String queryId) {
		
		return template.selectList(queryId);
	}

	@Override
	public int updateStatus(String queryId, int purchaseHistoryId) {

		return template.update(queryId, purchaseHistoryId);
	}
	
}
