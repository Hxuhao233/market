package com.market.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.market.model.Message;
import com.market.service.ICollectListService;
import com.market.service.IStudentService;

public class MessageTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring-mybatis.xml" });
	IStudentService iStudentService = (IStudentService) ac.getBean("studentService");
	
	// @Test
	// 查看消息 
	public void getMessageTest(Integer sid) {
		List<Message> mList = iStudentService.getMessage(sid);
		System.out.println("ID为"+sid+"的学生消息列表：");
		for (int i = 0; i < mList.size(); i++) {
			Message message=mList.get(i);
			System.out.print("第"+(i+1)+"条消息:"+message.getMessage()+" ");
			System.out.print("发送者："+message.getSenderid()+" 接收者:"+message.getReceiverid()+" ");
			if (message.getIsreceived()==0)
			{
				System.out.println("未读");
			}
			else {
				System.out.println("已读");
			}
		}
	}
	
	// @Test
	// 发送消息
	public void sendMessageTest(Integer senderId,Integer receiverId,String msg){
		System.out.println("发送前:");
		getMessageTest(senderId);
		iStudentService.sendMessage(senderId, receiverId, msg);
		System.out.println("发送后:");
		getMessageTest(senderId);
	}
}
