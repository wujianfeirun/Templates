package jaxb.demo1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MsgBody")
@XmlAccessorType(XmlAccessType.NONE)
public class MsgBody {

    @XmlElement(name = "InstgAcctNm")
    private String instgacctNm;

    @XmlElement(name = "ResfdAcctIssrId")
    private String resfdAcctIssrId;

    public String getInstgacctNm() {
        return instgacctNm;
    }

    public void setInstgacctNm(String instgacctNm) {
        this.instgacctNm = instgacctNm;
    }

    public String getResfdAcctIssrId() {
        return resfdAcctIssrId;
    }

    public void setResfdAcctIssrId(String resfdAcctIssrId) {
        this.resfdAcctIssrId = resfdAcctIssrId;
    }
}
