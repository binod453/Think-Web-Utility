/**
 * Jqs_alert_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_alert_identifier  implements java.io.Serializable {
    private int jqs_alert_id;

    public Jqs_alert_identifier() {
    }

    public Jqs_alert_identifier(
           int jqs_alert_id) {
           this.jqs_alert_id = jqs_alert_id;
    }


    /**
     * Gets the jqs_alert_id value for this Jqs_alert_identifier.
     * 
     * @return jqs_alert_id
     */
    public int getJqs_alert_id() {
        return jqs_alert_id;
    }


    /**
     * Sets the jqs_alert_id value for this Jqs_alert_identifier.
     * 
     * @param jqs_alert_id
     */
    public void setJqs_alert_id(int jqs_alert_id) {
        this.jqs_alert_id = jqs_alert_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_alert_identifier)) return false;
        Jqs_alert_identifier other = (Jqs_alert_identifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.jqs_alert_id == other.getJqs_alert_id();
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
        _hashCode += getJqs_alert_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_alert_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">jqs_alert_identifier"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jqs_alert_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jqs_alert_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
