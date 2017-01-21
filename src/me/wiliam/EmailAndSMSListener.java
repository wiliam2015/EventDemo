package me.wiliam;

/**
 * 同时处理发送邮件事件和短信事件
 * @author wiliam
 *
 */
public class EmailAndSMSListener implements TrainTicketListener {

	@Override
	public void handEvent(TrainTicketEvent tte) {

		if(tte instanceof SendEmailEvent){
			SendEmailEvent see = (SendEmailEvent)tte;
			System.out.println(see.getEmailData());
		}else if(tte instanceof SendSMSEvent){
			SendSMSEvent sse = (SendSMSEvent)tte;
			System.out.println(sse.getSMSData());
		}else{
			System.out.println("发送未知事件，无法处理");
		}
	}

}
