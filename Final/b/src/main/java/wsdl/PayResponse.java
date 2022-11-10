
package wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="system_transaction_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayResponse", propOrder = {
    "systemTransactionId"
})
public class PayResponse {

    @XmlElement(name = "system_transaction_id")
    protected long systemTransactionId;

    /**
     * Gets the value of the systemTransactionId property.
     * 
     */
    public long getSystemTransactionId() {
        return systemTransactionId;
    }

    /**
     * Sets the value of the systemTransactionId property.
     * 
     */
    public void setSystemTransactionId(long value) {
        this.systemTransactionId = value;
    }

}
