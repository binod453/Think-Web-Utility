/**
 * Dynamic_price_edit_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Dynamic_price_edit_response  implements java.io.Serializable {
    private Think.XmlWebServices.Dynamic_price dynamic_price;

    private java.lang.String[] warning;

    public Dynamic_price_edit_response() {
    }

    public Dynamic_price_edit_response(
           Think.XmlWebServices.Dynamic_price dynamic_price,
           java.lang.String[] warning) {
           this.dynamic_price = dynamic_price;
           this.warning = warning;
    }


    /**
     * Gets the dynamic_price value for this Dynamic_price_edit_response.
     * 
     * @return dynamic_price
     */
    public Think.XmlWebServices.Dynamic_price getDynamic_price() {
        return dynamic_price;
    }


    /**
     * Sets the dynamic_price value for this Dynamic_price_edit_response.
     * 
     * @param dynamic_price
     */
    public void setDynamic_price(Think.XmlWebServices.Dynamic_price dynamic_price) {
        this.dynamic_price = dynamic_price;
    }


    /**
     * Gets the warning value for this Dynamic_price_edit_response.
     * 
     * @return warning
     */
    public java.lang.String[] getWarning() {
        return warning;
    }


    /**
     * Sets the warning value for this Dynamic_price_edit_response.
     * 
     * @param warning
     */
    public void setWarning(java.lang.String[] warning) {
        this.warning = warning;
    }

    public java.lang.String getWarning(int i) {
        return this.warning[i];
    }

    public void setWarning(int i, java.lang.String _value) {
        this.warning[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dynamic_price_edit_response)) return false;
        Dynamic_price_edit_response other = (Dynamic_price_edit_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dynamic_price==null && other.getDynamic_price()==null) || 
             (this.dynamic_price!=null &&
              this.dynamic_price.equals(other.getDynamic_price()))) &&
            ((this.warning==null && other.getWarning()==null) || 
             (this.warning!=null &&
              java.util.Arrays.equals(this.warning, other.getWarning())));
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
        if (getDynamic_price() != null) {
            _hashCode += getDynamic_price().hashCode();
        }
        if (getWarning() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWarning());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWarning(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dynamic_price_edit_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">dynamic_price_edit_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">dynamic_price"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warning");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "warning"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
