package com.liker.mysunday.api.wx.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>接收微信服务器POST消息的XML数据包。
 * 微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次
 * 关于重试的消息排重，推荐使用msgid排重。
 * 假如服务器无法保证在五秒内处理并回复，可以直接回复空串，微信服务器不会对此作任何处理，并且不会发起重试。</p>
 * 
 * eg.<p>
 * {@code <xml>
 *   <ToUserName><![CDATA[toUser]]></ToUserName>
 *   <FromUserName><![CDATA[fromUser]]></FromUserName> 
 *   <CreateTime>1348831860</CreateTime>
 *   <MsgType><![CDATA[text]]></MsgType>
 *   <Content><![CDATA[this is a test]]></Content>
 *   <MsgId>1234567890123456</MsgId>
 *   </xml>
 *  }</p>
 * 
 *	<p>ToUserName	        开发者微信号
 *	<p>FromUserName		发送方帐号（一个OpenID）
 *	<p>CreateTime	 	消息创建时间 （整型）
 *	<p>MsgType	 		text
 *	<p>Content	 		文本消息内容
 *	<p>MsgId	 		消息id，64位整型
 * 
 * @author LIKER
 *
 */
@XmlRootElement(name = "xml")
public class TextMessageInput {

	private String ToUserName;

	private String FromUserName;

	private String CreateTime;

	private String MsgType;

	private String Content;

	private String MsgId;

	public TextMessageInput(){
		
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

	@XmlElement(name = "MsgId")
	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	@Override
	public String toString() {
		return "TextMessageInput [ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + ", Content=" + Content + ", MsgId=" + MsgId + "]";
	}

}
