//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.07.18 ʱ�� 10:33:28 PM CST 
//


package jaxb.demo;

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
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}PyerTrxTrmNo"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}BatchId"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}OrdrInf"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}PyeeInf"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}PyerInf"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}ResfdtInf"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}TrxDevcInf"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02}TrxInf"/>
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
@XmlRootElement(name = "MsgBody")
public class MsgBody {

    @XmlElementRefs({
        @XmlElementRef(name = "BatchId", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PyeeInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = PyeeInf.class, required = false),
        @XmlElementRef(name = "PyerInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = PyerInf.class, required = false),
        @XmlElementRef(name = "TrxInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = TrxInf.class, required = false),
        @XmlElementRef(name = "PyerTrxTrmNo", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ResfdtInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = ResfdtInf.class, required = false),
        @XmlElementRef(name = "OrdrInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = OrdrInf.class, required = false),
        @XmlElementRef(name = "TrxDevcInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Object> content;

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
     * {@link PyeeInf }
     * {@link PyerInf }
     * {@link TrxInf }
     * {@link String }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link ResfdtInf }
     * {@link OrdrInf }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
