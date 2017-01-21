package me.wiliam;
/**
 * 发送邮件事件
 * @author wiliam
 *
 */
public class SendEmailEvent extends TrainTicketEvent {

	private static final long serialVersionUID = 1L;

	private TrainTicket trainTicket;
	
	public SendEmailEvent(TrainTicket source) {
		super(source);
		this.trainTicket = source;
	}
	
	public TrainTicket getTrainTicket(){
		return trainTicket;
	}
	
	public String getEmailData(){
		if(trainTicket != null){
			String data = "发送邮件："+trainTicket.getUserName() + "您好，您已成功购买火车票"+trainTicket.getTicketName();
			return data;
		}
		return "";
	}

}
