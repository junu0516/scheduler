package app.schedulers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.models.purchase.PurchaseService;

@Component
public class OrderProcessScheduler {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PurchaseService purchaseService;
	
	@Scheduled(fixedDelay = 1000 * 10)
	public void checkAndUpdateStatus() throws Exception {
		
		//10초에 한번씩 상태값이 N이 것들을 찾아 상태값과 결제일자 업데이트
		List<Integer> notPaidLists = purchaseService.selectAllNotPaidLists();
		
		logger.debug("미완료 결제건 pk 목록 : {}", notPaidLists);
		
		
		if(notPaidLists.size() >0) {
			int count = 0;
			for(int key : notPaidLists) {
				count += purchaseService.updateStatus(key);
				logger.debug("총 {}건 수정",count);
				//System.out.println("총 "+count+"건 수정");
				
			}
			count = 0;			
		}else {
			logger.debug("업데이트 대상 없음");
		}
	}
}
