/**
 * Dynamic_price.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Dynamic_price  implements java.io.Serializable {
    private int dynamic_price_id;

    private java.lang.String dynamic_price_name;

    private java.lang.String description;

    private java.lang.Integer isactive;

    public Dynamic_price() {
    }

    public Dynamic_price(
           int dynamic_price_id,
           java.lang.String dynamic_price_name,
           java.lang.String description,
           java.lang.Integer isactive) {
           this.dynamic_price_id = dynamic_price_id;
           this.dynamic_price_name = dynamic_price_name;
           this.description = description;
           this.isactive = isactive;
    }


    /**
     * Gets the dynamic_price_id value for this Dynamic_price.
     * 
     * @return dynamic_price_id
     */
    public int getDynamic_price_id() {
        return dynamic_price_id;
    }


    /**
     * Sets the dynamic_price_id value for this Dynamic_price.
     * 
     * @param dynamic_price_id
     */
    public void setDynamic_price_id(int dynamic_price_id) {
        this.dynamic_price_id = dynamic_price_id;
    }


    /**
     * Gets the dynamic_price_name value for this Dynamic_price.
     * 
     * @return dynamic_price_name
     */
    public java.lang.String getDynamic_price_name() {
        return dynamic_price_name;
    }


    /**
     * Sets the dynamic_price_name value for this Dynamic_price.
     * 
     * @param dynamic_price_name
     */
    public void setDynamic_price_name(java.lang.String dynamic_price_name) {
        this.dynamic_price_name = dynamic_price_name;
    }


    /**
     * Gets the description value for this Dynamic_price.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Dynamic_price.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the isactive value for this Dynamic_price.
     * 
     * @return isactive
     */
    public java.lang.Integer getIsactive() {
        return isactive;
    }


    /**
     * Sets the isactive value for this Dynamic_price.
     * 
     * @param isactive
     */
    public void setIsactive(java.lang.Integer isactive) {
        this.isactive = isactive;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dynamic_price)) return false;
        Dynamic_price other = (Dynamic_price) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.dynamic_price_id == other.getDynamic_price_id() &&
            ((this.dynamic_price_name==null && other.getDynamic_price_name()==null) || 
             (this.dynamic_price_name!=null &&
              this.dynamic_price_name.equals(other.getDynamic_price_name()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.isactive==null && other.getIsactive()==null) || 
             (this.isactive!=null &&
              this.isactive.equals(other.getIsactive())));
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
        if (getDynamic_price_name() != null) {
            _hashCode += getDynamic_price_name().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getIsactive() != null) {
            _hashCode += getIsactive().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dynamic_price.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">dynamic_price"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isactive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "isactive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
