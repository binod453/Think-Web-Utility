/**
 * Payment_transfer_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Payment_transfer_response  implements java.io.Serializable {
    private Think.XmlWebServices.Payment payment;

    public Payment_transfer_response() {
    }

    public Payment_transfer_response(
           Think.XmlWebServices.Payment payment) {
           this.payment = payment;
    }


    /**
     * Gets the payment value for this Payment_transfer_response.
     * 
     * @return payment
     */
    public Think.XmlWebServices.Payment getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Payment_transfer_response.
     * 
     * @param payment
     */
    public void setPayment(Think.XmlWebServices.Payment payment) {
        this.payment = payment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Payment_transfer_response)) return false;
        Payment_transfer_response other = (Payment_transfer_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment())));
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
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Payment_transfer_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment_transfer_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">payment"));
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
