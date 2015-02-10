package com.liker.mysunday.api.wx.entity;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>回复文本消息。
 * 
 * eg.<p>
 * {@code <xml>
 *   <ToUserName><![CDATA[toUser]]></ToUserName>
 *   <FromUserName><![CDATA[fromUser]]></FromUserName>
 *   <CreateTime>12345678</CreateTime>
 *   <MsgType><![CDATA[text]]></MsgType>
 *   <Content><![CDATA[你好]]></Content>
 *   </xml>
 *  }</p>
 * 
 *	<p>ToUserName	 接收方帐号（收到的OpenID）
 *	<p>FromUserName	 开发者微信号
 *	<p>CreateTime	 消息创建时间 （整型）
 *	<p>MsgType	 	text
 *	<p>Content	 	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
 * 
 * @author LIKER
 *
 */
@XmlRootElement(name="xml")
public class TextMessageOutput {

	@NotNull
	private String ToUserName;

	private String FromUserName;

	private String CreateTime;

	private String MsgType;

	private String Content;

	public TextMessageOutput(){
		
	}
	
	public TextMessageOutput(String toUserName, String fromUserName,
			String createTime, String msgType, String content) {
		this.ToUserName = toUserName;
		this.FromUserName = fromUserName;
		this.CreateTime = createTime;
		this.MsgType = msgType;
		this.Content = content;
	}

	@XmlElement(name = "ToUserName")
	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	@XmlElement(name = "FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	@XmlElement(name = "CreateTime")
	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@XmlElement(name = "MsgType")
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@XmlElement(name = "Content")
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "TextMessageOutput [ToUserName=" + ToUserName
				+ ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + ", Content=" + Content
				+ "]";
	}
	
}
