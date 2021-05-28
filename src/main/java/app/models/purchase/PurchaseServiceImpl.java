package app.models.purchase;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.conf.MainRepository;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	MainRepository mainRepository;
	
	@Override
	public int insertHistory(PurchaseHistory purchaseHistory) {

		Map historyInsertMap = new ObjectMapper().convertValue(purchaseHistory, Map.class);
		
		return mainRepository.insertHistory("insertHistory",historyInsertMap);
	}

	@Override
	public List<PurchaseHistory> selectHistories() throws Exception {

		return mainRepository.selectHistories("selectHistories");
	}

	@Override
	public List<Integer> selectAllNotPaidLists() throws Exception {

		return mainRepository.selectAllNotPaidLists("selectAllNotPaidLists");
	}

	@Override
	public int updateStatus(int purchaseHistoryId) throws Exception {

		return mainRepository.updateStatus("updateStatus",purchaseHistoryId);
	}
}
