package me.wiliam;
/**
 * 发送短信事件
 * @author huhailong
 *
 */
public class SendSMSEvent extends TrainTicketEvent {

	private static final long serialVersionUID = 1L;
	private TrainTicket trainTicket;
	
	public SendSMSEvent(TrainTicket source) {
		super(source);
		this.trainTicket = source;
	}
	
	public TrainTicket getTrainTicket(){
		return trainTicket;
	}
	
	public String getSMSData(){
		if(trainTicket != null){
			String data = "发送短信："+trainTicket.getUserName() + "您好，您已成功购买火车票"+trainTicket.getTicketName();
			return data;
		}
		return "";
	}

}
