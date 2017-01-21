package me.wiliam;

/**
 * 事件测试类
 * @author wiliam
 *
 */
public class TestBuyTrainTicketSuccessEvent {

	public static void main(String[] args) {
		TestBuyTrainTicketSuccessEvent  tbtts = new TestBuyTrainTicketSuccessEvent();
		tbtts.buySuccessTicket();
	}
	
	private void buySuccessTicket(){
		TrainTicket tt = new TrainTicket();
		tt.setTicketName("【北京---济南】");
		tt.setUserName("小明");
		System.out.println("购票成功");
		TrainTicketPublisher.instance().publishEvent(new SendEmailEvent(tt));
		TrainTicketPublisher.instance().publishEvent(new SendSMSEvent(tt));
	}

}
