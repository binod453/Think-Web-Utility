/**
 * Payment_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private Think.XmlWebServices.ZZSubscrip[] subscrip;

    private Think.XmlWebServices.Orderhdr[] orderhdr;

    private Think.XmlWebServices.Payment payment;

    private Think.XmlWebServices.Trusted_data trusted_data;

    public Payment_edit_response() {
    }

    public Payment_edit_response(
           Think.XmlWebServices.Customer_identifier customer_identifier,
           Think.XmlWebServices.ZZSubscrip[] subscrip,
           Think.XmlWebServices.Orderhdr[] orderhdr,
           Think.XmlWebServices.Payment payment,
           Think.XmlWebServices.Trusted_data trusted_data) {
           this.customer_identifier = customer_identifier;
           this.subscrip = subscrip;
           this.orderhdr = orderhdr;
           this.payment = payment;
           this.trusted_data = trusted_data;
    }


    /**
     * Gets the customer_identifier value for this Payment_edit_response.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Payment_edit_response.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the subscrip value for this Payment_edit_response.
     * 
     * @return subscrip
     */
    public Think.XmlWebServices.ZZSubscrip[] getSubscrip() {
        return subscrip;
    }


    /**
     * Sets the subscrip value for this Payment_edit_response.
     * 
     * @param subscrip
     */
    public void setSubscrip(Think.XmlWebServices.ZZSubscrip[] subscrip) {
        this.subscrip = subscrip;
    }

    public Think.XmlWebServices.ZZSubscrip getSubscrip(int i) {
        return this.subscrip[i];
    }

    public void setSubscrip(int i, Think.XmlWebServices.ZZSubscrip _value) {
        this.subscrip[i] = _value;
    }


    /**
     * Gets the orderhdr value for this Payment_edit_response.
     * 
     * @return orderhdr
     */
    public Think.XmlWebServices.Orderhdr[] getOrderhdr() {
        return orderhdr;
    }


    /**
     * Sets the orderhdr value for this Payment_edit_response.
     * 
     * @param orderhdr
     */
    public void setOrderhdr(Think.XmlWebServices.Orderhdr[] orderhdr) {
        this.orderhdr = orderhdr;
    }

    public Think.XmlWebServices.Orderhdr getOrderhdr(int i) {
        return this.orderhdr[i];
    }

    public void setOrderhdr(int i, Think.XmlWebServices.Orderhdr _value) {
        this.orderhdr[i] = _value;
    }


    /**
     * Gets the payment value for this Payment_edit_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Payment_edit_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment payment) {
        this.payment = payment;
    }


    /**
     * Gets the trusted_data value for this Payment_edit_response.
     * 
     * @return trusted_data
     */
    public Think.XmlWebServices.Trusted_data getTrusted_data() {
        return trusted_data;
    }


    /**
     * Sets the trusted_data value for this Payment_edit_response.
     * 
     * @param trusted_data
     */
    public void setTrusted_data(Think.XmlWebServices.Trusted_data trusted_data) {
        this.trusted_data = trusted_data;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_edit_response)) return false;
        Payment_edit_response other = (Payment_edit_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.subscrip==null && other.getSubscrip()==null) || 
             (this.subscrip!=null &&
              java.util.Arrays.equals(this.subscrip, other.getSubscrip()))) &&
            ((this.orderhdr==null && other.getOrderhdr()==null) || 
             (this.orderhdr!=null &&
              java.util.Arrays.equals(this.orderhdr, other.getOrderhdr()))) &&
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment()))) &&
            ((this.trusted_data==null && other.getTrusted_data()==null) || 
             (this.trusted_data!=null &&
              this.trusted_data.equals(other.getTrusted_data())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getSubscrip() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubscrip());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubscrip(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrderhdr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrderhdr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrderhdr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        if (getTrusted_data() != null) {
            _hashCode += getTrusted_data().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_edit_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderhdr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "orderhdr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trusted_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "trusted_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">trusted_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
