/**
 * Dynamic_price_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Dynamic_price_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Dynamic_price_card_select dynamic_price_card_select;

    private Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select[] dynamic_price_select;

    public Dynamic_price_select_response() {
    }

    public Dynamic_price_select_response(
           Think.XmlWebServices.Dynamic_price_card_select dynamic_price_card_select,
           Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select[] dynamic_price_select) {
           this.dynamic_price_card_select = dynamic_price_card_select;
           this.dynamic_price_select = dynamic_price_select;
    }


    /**
     * Gets the dynamic_price_card_select value for this Dynamic_price_select_response.
     * 
     * @return dynamic_price_card_select
     */
    public Think.XmlWebServices.Dynamic_price_card_select getDynamic_price_card_select() {
        return dynamic_price_card_select;
    }


    /**
     * Sets the dynamic_price_card_select value for this Dynamic_price_select_response.
     * 
     * @param dynamic_price_card_select
     */
    public void setDynamic_price_card_select(Think.XmlWebServices.Dynamic_price_card_select dynamic_price_card_select) {
        this.dynamic_price_card_select = dynamic_price_card_select;
    }


    /**
     * Gets the dynamic_price_select value for this Dynamic_price_select_response.
     * 
     * @return dynamic_price_select
     */
    public Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select[] getDynamic_price_select() {
        return dynamic_price_select;
    }


    /**
     * Sets the dynamic_price_select value for this Dynamic_price_select_response.
     * 
     * @param dynamic_price_select
     */
    public void setDynamic_price_select(Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select[] dynamic_price_select) {
        this.dynamic_price_select = dynamic_price_select;
    }

    public Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select getDynamic_price_select(int i) {
        return this.dynamic_price_select[i];
    }

    public void setDynamic_price_select(int i, Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select _value) {
        this.dynamic_price_select[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dynamic_price_select_response)) return false;
        Dynamic_price_select_response other = (Dynamic_price_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dynamic_price_card_select==null && other.getDynamic_price_card_select()==null) || 
             (this.dynamic_price_card_select!=null &&
              this.dynamic_price_card_select.equals(other.getDynamic_price_card_select()))) &&
            ((this.dynamic_price_select==null && other.getDynamic_price_select()==null) || 
             (this.dynamic_price_select!=null &&
              java.util.Arrays.equals(this.dynamic_price_select, other.getDynamic_price_select())));
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
        if (getDynamic_price_card_select() != null) {
            _hashCode += getDynamic_price_card_select().hashCode();
        }
        if (getDynamic_price_select() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDynamic_price_select());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDynamic_price_select(), i);
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
        new org.apache.axis.description.TypeDesc(Dynamic_price_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">dynamic_price_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price_card_select");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price_card_select"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">dynamic_price_card_select"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price_select");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price_select"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>dynamic_price_select_response>dynamic_price_select"));
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
