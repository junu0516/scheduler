package app.conf;

import java.util.List;
import java.util.Map;

import app.models.product.Product;
import app.models.purchase.PurchaseHistory;

public interface MainRepository {

	int insertProduct(String queryId, Map productInsertMap) throws Exception;

	List<Product> selectProducts(String queryId) throws Exception;

	int insertHistory(String queryId, Map historyInsertMap);

	List<PurchaseHistory> selectHistories(String queryId);

	List<Integer> selectAllNotPaidLists(String queryId);

	int updateStatus(String queryId, int purchaseHistoryId);

}
