package me.wiliam;

import java.util.EventListener;
/**
 * 火车票事件监听器接口
 * @author wiliam
 *
 */
public interface TrainTicketListener extends EventListener {

	void handEvent(TrainTicketEvent tte);
}
