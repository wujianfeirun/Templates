//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.07.18 ʱ�� 10:33:28 PM CST 
//


package jaxb.demo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}TrxAmt"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}TrxDtTm"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}TrxId"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}AcctInTp"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}BizTp"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}TrxCtgy"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "TrxInf")
public class TrxInf {

    @XmlElementRefs({
        @XmlElementRef(name = "TrxDtTm", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TrxId", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BizTp", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TrxCtgy", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TrxAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctInTp", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

}
