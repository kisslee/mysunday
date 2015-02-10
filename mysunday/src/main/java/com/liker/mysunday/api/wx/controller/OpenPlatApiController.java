package com.liker.mysunday.api.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liker.mysunday.api.wx.entity.JavaBean;
import com.liker.mysunday.api.wx.entity.TestMessage;
import com.liker.mysunday.api.wx.entity.TextMessageInput;
import com.liker.mysunday.api.wx.entity.TextMessageOutput;
import com.liker.mysunday.api.wx.service.MsgService;

/**
 * Restful API Controller.
 * 
 * AppID(应用ID)       wxf60fa48ab2c83083
 * AppSecret(应用密钥) b2a1dfd84e7484d3f4cb68f618051097
 * @author LIKER
 */
@RestController
@RequestMapping(value = "/api/wx")
public class OpenPlatApiController {
	
	@Autowired
	MsgService msgService;

	@RequestMapping(method = RequestMethod.GET)
	public String sign(@RequestParam("echostr") String echostr){
		System.out.println("echostr--->" + echostr);
		return echostr; 
	}
	
	@RequestMapping(value="/xml", method=RequestMethod.POST)
	public String readXml(@RequestBody JavaBean bean) {
		System.out.println("bean---->" + bean.toString());
		return "Read from XML: " + bean;
	}
	
	@RequestMapping(value="/xml2", method=RequestMethod.POST)
	public String readXml2(@RequestBody TestMessage test) {
		System.out.println("test---->" + test.toString());
		return "Read from XML: " + test;
	}
	
	@RequestMapping(value="/xml4", method=RequestMethod.POST)
	public JavaBean readXml4(@RequestBody JavaBean bean) {
		System.out.println("bean---->" + bean.toString());
		bean.setFruit("lee");
		bean.setFoo("kiss");
		return bean;
	}
	
	@RequestMapping(value="/xml3", method=RequestMethod.GET)
	public TextMessageOutput readXml3() {
		return new TextMessageOutput("AAA", "BBB", "CCC", "DDD", "EEE");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public TextMessageOutput doMsg(@RequestBody TextMessageInput inMsg) {
		
//		System.out.println("进来了......");
//		System.out.println("TextMessageInput----->" + inMsg.toString());
//		System.out.println(inMsg.getMsgType());
//		System.out.println(inMsg.getContent());
		
		if("text".equals(inMsg.getMsgType())){
			return msgService.doText(inMsg);
		}
		if("event".equals(inMsg.getMsgType())){
			
		}
		
		return null;
	}
	
}
