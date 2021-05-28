package app.models.purchase;

import java.util.List;

public interface PurchaseService {

	int insertHistory(PurchaseHistory purchaseHistory) throws Exception;

	List<PurchaseHistory> selectHistories() throws Exception;

	List<Integer> selectAllNotPaidLists() throws Exception;

	int updateStatus(int purchaseHistoryId) throws Exception;

}
