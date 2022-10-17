
package homework.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListPersonsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListPersonsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListPersonsResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListPersonsResponse", propOrder = {
    "listPersonsResult"
})
public class ListPersonsResponse {

    @XmlElement(name = "ListPersonsResult")
    protected Object listPersonsResult;

    /**
     * Gets the value of the listPersonsResult property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getListPersonsResult() {
        return listPersonsResult;
    }

    /**
     * Sets the value of the listPersonsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setListPersonsResult(Object value) {
        this.listPersonsResult = value;
    }

}
