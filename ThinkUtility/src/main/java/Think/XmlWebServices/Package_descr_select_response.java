/**
 * Package_descr_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Package_descr_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Package_descr_select_responseOrder_code_with_pkg_def order_code_with_pkg_def;

    public Package_descr_select_response() {
    }

    public Package_descr_select_response(
           Think.XmlWebServices.Package_descr_select_responseOrder_code_with_pkg_def order_code_with_pkg_def) {
           this.order_code_with_pkg_def = order_code_with_pkg_def;
    }


    /**
     * Gets the order_code_with_pkg_def value for this Package_descr_select_response.
     * 
     * @return order_code_with_pkg_def
     */
    public Think.XmlWebServices.Package_descr_select_responseOrder_code_with_pkg_def getOrder_code_with_pkg_def() {
        return order_code_with_pkg_def;
    }


    /**
     * Sets the order_code_with_pkg_def value for this Package_descr_select_response.
     * 
     * @param order_code_with_pkg_def
     */
    public void setOrder_code_with_pkg_def(Think.XmlWebServices.Package_descr_select_responseOrder_code_with_pkg_def order_code_with_pkg_def) {
        this.order_code_with_pkg_def = order_code_with_pkg_def;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Package_descr_select_response)) return false;
        Package_descr_select_response other = (Package_descr_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.order_code_with_pkg_def==null && other.getOrder_code_with_pkg_def()==null) || 
             (this.order_code_with_pkg_def!=null &&
              this.order_code_with_pkg_def.equals(other.getOrder_code_with_pkg_def())));
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
        if (getOrder_code_with_pkg_def() != null) {
            _hashCode += getOrder_code_with_pkg_def().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Package_descr_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">package_descr_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_with_pkg_def");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_with_pkg_def"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>package_descr_select_response>order_code_with_pkg_def"));
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
