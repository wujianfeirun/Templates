//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.07.18 ʱ�� 10:33:28 PM CST 
//


package jaxb.demo;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PyerTrxTrmTp_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyerTrxTrmTp");
    private final static QName _ResfdAcctIssrId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "ResfdAcctIssrId");
    private final static QName _PyeeAcctId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyeeAcctId");
    private final static QName _DgtlEnvlp_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "DgtlEnvlp");
    private final static QName _SndDt_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "SndDt");
    private final static QName _PyerTrxTrmNo_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyerTrxTrmNo");
    private final static QName _AcctInTp_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "AcctInTp");
    private final static QName _IssrId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "IssrId");
    private final static QName _NcrptnSN_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "NcrptnSN");
    private final static QName _BatchId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "BatchId");
    private final static QName _PyerAcctIssrId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyerAcctIssrId");
    private final static QName _SignSN_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "SignSN");
    private final static QName _TrxDtTm_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "TrxDtTm");
    private final static QName _InstgAcctNm_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "InstgAcctNm");
    private final static QName _InstgAcctId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "InstgAcctId");
    private final static QName _TrxDevcInf_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "TrxDevcInf");
    private final static QName _PyerAcctTp_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyerAcctTp");
    private final static QName _TrxCtgy_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "TrxCtgy");
    private final static QName _PyeeAcctTp_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyeeAcctTp");
    private final static QName _BizTp_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "BizTp");
    private final static QName _Drctn_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "Drctn");
    private final static QName _PyeeAcctNm_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyeeAcctNm");
    private final static QName _SgnNo_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "SgnNo");
    private final static QName _TrxAmt_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "TrxAmt");
    private final static QName _TrxId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "TrxId");
    private final static QName _MsgTp_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "MsgTp");
    private final static QName _PyeeAcctIssrId_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", "PyeeAcctIssrId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link MsgBody }
     * 
     */
    public MsgBody createMsgBody() {
        return new MsgBody();
    }

    /**
     * Create an instance of {@link OrdrInf }
     * 
     */
    public OrdrInf createOrdrInf() {
        return new OrdrInf();
    }

    /**
     * Create an instance of {@link PyeeInf }
     * 
     */
    public PyeeInf createPyeeInf() {
        return new PyeeInf();
    }

    /**
     * Create an instance of {@link PyerInf }
     * 
     */
    public PyerInf createPyerInf() {
        return new PyerInf();
    }

    /**
     * Create an instance of {@link ResfdtInf }
     * 
     */
    public ResfdtInf createResfdtInf() {
        return new ResfdtInf();
    }

    /**
     * Create an instance of {@link TrxInf }
     * 
     */
    public TrxInf createTrxInf() {
        return new TrxInf();
    }

    /**
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyerTrxTrmTp")
    public JAXBElement<BigInteger> createPyerTrxTrmTp(BigInteger value) {
        return new JAXBElement<BigInteger>(_PyerTrxTrmTp_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "ResfdAcctIssrId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createResfdAcctIssrId(String value) {
        return new JAXBElement<String>(_ResfdAcctIssrId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyeeAcctId")
    public JAXBElement<BigInteger> createPyeeAcctId(BigInteger value) {
        return new JAXBElement<BigInteger>(_PyeeAcctId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "DgtlEnvlp")
    public JAXBElement<String> createDgtlEnvlp(String value) {
        return new JAXBElement<String>(_DgtlEnvlp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "SndDt")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createSndDt(String value) {
        return new JAXBElement<String>(_SndDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyerTrxTrmNo")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPyerTrxTrmNo(String value) {
        return new JAXBElement<String>(_PyerTrxTrmNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "AcctInTp")
    public JAXBElement<BigInteger> createAcctInTp(BigInteger value) {
        return new JAXBElement<BigInteger>(_AcctInTp_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "IssrId")
    public JAXBElement<BigInteger> createIssrId(BigInteger value) {
        return new JAXBElement<BigInteger>(_IssrId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "NcrptnSN")
    public JAXBElement<BigInteger> createNcrptnSN(BigInteger value) {
        return new JAXBElement<BigInteger>(_NcrptnSN_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "BatchId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createBatchId(String value) {
        return new JAXBElement<String>(_BatchId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyerAcctIssrId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPyerAcctIssrId(String value) {
        return new JAXBElement<String>(_PyerAcctIssrId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "SignSN")
    public JAXBElement<BigInteger> createSignSN(BigInteger value) {
        return new JAXBElement<BigInteger>(_SignSN_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "TrxDtTm")
    public JAXBElement<String> createTrxDtTm(String value) {
        return new JAXBElement<String>(_TrxDtTm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "InstgAcctNm")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createInstgAcctNm(String value) {
        return new JAXBElement<String>(_InstgAcctNm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "InstgAcctId")
    public JAXBElement<BigInteger> createInstgAcctId(BigInteger value) {
        return new JAXBElement<BigInteger>(_InstgAcctId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "TrxDevcInf")
    public JAXBElement<String> createTrxDevcInf(String value) {
        return new JAXBElement<String>(_TrxDevcInf_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyerAcctTp")
    public JAXBElement<BigInteger> createPyerAcctTp(BigInteger value) {
        return new JAXBElement<BigInteger>(_PyerAcctTp_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "TrxCtgy")
    public JAXBElement<BigInteger> createTrxCtgy(BigInteger value) {
        return new JAXBElement<BigInteger>(_TrxCtgy_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyeeAcctTp")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPyeeAcctTp(String value) {
        return new JAXBElement<String>(_PyeeAcctTp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "BizTp")
    public JAXBElement<BigInteger> createBizTp(BigInteger value) {
        return new JAXBElement<BigInteger>(_BizTp_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "Drctn")
    public JAXBElement<BigInteger> createDrctn(BigInteger value) {
        return new JAXBElement<BigInteger>(_Drctn_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyeeAcctNm")
    public JAXBElement<String> createPyeeAcctNm(String value) {
        return new JAXBElement<String>(_PyeeAcctNm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "SgnNo")
    public JAXBElement<BigInteger> createSgnNo(BigInteger value) {
        return new JAXBElement<BigInteger>(_SgnNo_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "TrxAmt")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createTrxAmt(String value) {
        return new JAXBElement<String>(_TrxAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "TrxId")
    public JAXBElement<BigInteger> createTrxId(BigInteger value) {
        return new JAXBElement<BigInteger>(_TrxId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "MsgTp")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createMsgTp(String value) {
        return new JAXBElement<String>(_MsgTp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02", name = "PyeeAcctIssrId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPyeeAcctIssrId(String value) {
        return new JAXBElement<String>(_PyeeAcctIssrId_QNAME, String.class, null, value);
    }

}
