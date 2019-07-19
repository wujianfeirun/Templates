package jaxb.demo1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MsgHeader")
@XmlAccessorType(XmlAccessType.NONE)
public class MsgHeader {
    @XmlElement(name = "MsgId")
    private String msgId;

    @XmlElement(name = "MsgType")
    private String msgType;

    @XmlElement(name = "SignSN")
    private String signSN;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSignSN() {
        return signSN;
    }

    public void setSignSN(String signSN) {
        this.signSN = signSN;
    }
}
