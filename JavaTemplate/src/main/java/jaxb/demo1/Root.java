package jaxb.demo1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root",namespace="demo1")
@XmlAccessorType(XmlAccessType.NONE)
public class Root {
 
    @XmlElement(name = "MsgHeader")
    private MsgHeader MsgHeader;
 
    @XmlElement(name = "MsgBody")
    private MsgBody MsgBody;

    public MsgHeader getMsgHeader() {
        return MsgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        MsgHeader = msgHeader;
    }

    public MsgBody getMsgBody() {
        return MsgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        MsgBody = msgBody;
    }
}