package com.liker.sunday.mvc.wechat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.liker.mysunday.common.MediaTypes;
import com.liker.sunday.mvc.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class RestAPIControllerTests extends AbstractContextControllerTests {

	private static String URI = "/api/wx";

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
	}

	private static String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
								"<xml>" +
									"<ToUserName>abc</ToUserName>" +
									"<FromUserName>qerqwe</FromUserName>" + 
									"<CreateTime>aaaaa</CreateTime>" +
									"<MsgType>fsdfsdf</MsgType>" +
									"<Content>asdfasdfasdfadsf</Content>" +
									"<MsgId>gfdf</MsgId>" +
								"</xml>";

	private static String content = "<xml>" +
			"<ToUserName><![CDATA[toUser]]></ToUserName>" +
			"<FromUserName><![CDATA[fromUser]]></FromUserName>" + 
			"<CreateTime>1348831860</CreateTime>" +
			"<MsgType><![CDATA[text]]></MsgType>" +
			"<Content><![CDATA[sf550563164761]]></Content>" +
			"<MsgId>1234567890123456</MsgId>" +
		 "</xml>";
	
//	@Test
	public void readXml() throws Exception {
		this.mockMvc.perform(
				post(URI)
					.contentType(MediaType.APPLICATION_XML)
					.content(content.getBytes()))
				.andExpect(content().string("Read from XML: JavaBean {foo=[bar], fruit=[apple]}"));
	}
	
	@Test
	public void readXmlHTML() throws Exception {
		this.mockMvc.perform(
				post(URI)
					.contentType(MediaTypes.TEXT_XML_UTF_8)
					.content(content.getBytes()))
				.andExpect(content().string("Read from XML: JavaBean {foo=[bar], fruit=[apple]}"));
	}

	private static String XML2 =
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
			"<javaBean><foo>bar2</foo><fruit>apple2</fruit></javaBean>";
	
//	@Test
	public void readXml2() throws Exception {
		this.mockMvc.perform(
				post(URI+"/xml")
					.contentType(MediaType.APPLICATION_XML)
					.content(XML2.getBytes()))
				.andExpect(content().string("JavaBean {foo=[bar2], fruit=[apple2]}"));
	}
	
//	@Test
	public void readXml4() throws Exception {
		this.mockMvc.perform(
				post(URI+"/xml4")
					.contentType(MediaTypes.TEXT_XML_UTF_8)
					.content(XML2.getBytes()))
				.andExpect(content().string("JavaBean {foo=[bar2], fruit=[apple2]}"));
	}
	
	private static String XML3 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
			"<xml>" +
				"<toUserName>abc</toUserName>" +
				"<fromUserName>qerqwe</fromUserName>" + 
				"<createTime>aaaaa</createTime>" +
				"<msgType>fsdfsdf</msgType>" +
				"<content>asdfasdfasdfadsf</content>" +
				"<msgId>gfdf</msgId>" +
			"</xml>";

//	@Test
	public void readXml3() throws Exception {
		this.mockMvc.perform(
				post(URI+"/xml2")
					.contentType(MediaType.APPLICATION_XML)
					.content(XML3.getBytes()))
				.andExpect(content().string("TestMessage [toUserName=abc, fromUserName=qerqwe, createTime=aaaaa, msgType=fsdfsdf, content=asdfasdfasdfadsf, msgId=gfdf]"));
	}

}
