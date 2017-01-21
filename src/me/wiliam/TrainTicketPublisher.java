package me.wiliam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 事件派发器
 * @author wiliam
 *
 */
public class TrainTicketPublisher {
	
	private List<TrainTicketListener> ttlList = new ArrayList<TrainTicketListener>();
	private static TrainTicketPublisher ttp;
	private TrainTicketPublisher(){
		Properties props = new Properties();  
		try {
			props.load(TrainTicketPublisher.class.getClassLoader().getResourceAsStream("me/wiliam/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("初始化监听器失败"+e.getMessage());
		}
		String listenerStr = props.getProperty("listener");
		String[] listenerClassNames = listenerStr.split(",");
		if(listenerClassNames != null && listenerClassNames.length > 0){
			for(String listenerClassName : listenerClassNames){
				try {
					Class listenerClass = Class.forName(listenerClassName);
					TrainTicketListener ttl = (TrainTicketListener) listenerClass.newInstance();
					ttlList.add(ttl);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public static TrainTicketPublisher instance(){
		if(ttp ==  null){
			ttp = new TrainTicketPublisher();
		}
		return ttp;
	}
	
	public void publishEvent(TrainTicketEvent tte){
		for(TrainTicketListener ttl:ttlList){
			ttl.handEvent(tte);
		}
	}
}
