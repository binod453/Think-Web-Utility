/**
 * Dynamic_price_isusedinorder_select_responseDynamic_price.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Dynamic_price_isusedinorder_select_responseDynamic_price  implements java.io.Serializable {
    private int dynamic_price_id;  // attribute

    public Dynamic_price_isusedinorder_select_responseDynamic_price() {
    }

    public Dynamic_price_isusedinorder_select_responseDynamic_price(
           int dynamic_price_id) {
           this.dynamic_price_id = dynamic_price_id;
    }


    /**
     * Gets the dynamic_price_id value for this Dynamic_price_isusedinorder_select_responseDynamic_price.
     * 
     * @return dynamic_price_id
     */
    public int getDynamic_price_id() {
        return dynamic_price_id;
    }


    /**
     * Sets the dynamic_price_id value for this Dynamic_price_isusedinorder_select_responseDynamic_price.
     * 
     * @param dynamic_price_id
     */
    public void setDynamic_price_id(int dynamic_price_id) {
        this.dynamic_price_id = dynamic_price_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dynamic_price_isusedinorder_select_responseDynamic_price)) return false;
        Dynamic_price_isusedinorder_select_responseDynamic_price other = (Dynamic_price_isusedinorder_select_responseDynamic_price) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.dynamic_price_id == other.getDynamic_price_id();
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
        _hashCode += getDynamic_price_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dynamic_price_isusedinorder_select_responseDynamic_price.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>dynamic_price_isusedinorder_select_response>dynamic_price"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dynamic_price_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dynamic_price_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
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
