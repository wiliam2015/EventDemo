package me.wiliam;

import java.util.EventObject;
/**
 * 购票事件基类
 * @author wiliam
 *
 */
public class TrainTicketEvent extends EventObject {

	
	private static final long serialVersionUID = 1L;

	public TrainTicketEvent(TrainTicket source) {
		super(source);
	}

}
