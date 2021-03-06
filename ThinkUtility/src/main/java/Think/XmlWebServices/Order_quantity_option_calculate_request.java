/**
 * Order_quantity_option_calculate_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Order_quantity_option_calculate_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private Think.XmlWebServices.Item_data item_data;

    private int new_quantity;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean default_pricing;  // attribute

    public Order_quantity_option_calculate_request() {
    }

    public Order_quantity_option_calculate_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           Think.XmlWebServices.Item_data item_data,
           int new_quantity,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean default_pricing) {
           this.user_login_data = user_login_data;
           this.item_identifier = item_identifier;
           this.item_data = item_data;
           this.new_quantity = new_quantity;
           this.dsn = dsn;
           this.default_pricing = default_pricing;
    }


    /**
     * Gets the user_login_data value for this Order_quantity_option_calculate_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Order_quantity_option_calculate_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the item_identifier value for this Order_quantity_option_calculate_request.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Order_quantity_option_calculate_request.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the item_data value for this Order_quantity_option_calculate_request.
     * 
     * @return item_data
     */
    public Think.XmlWebServices.Item_data getItem_data() {
        return item_data;
    }


    /**
     * Sets the item_data value for this Order_quantity_option_calculate_request.
     * 
     * @param item_data
     */
    public void setItem_data(Think.XmlWebServices.Item_data item_data) {
        this.item_data = item_data;
    }


    /**
     * Gets the new_quantity value for this Order_quantity_option_calculate_request.
     * 
     * @return new_quantity
     */
    public int getNew_quantity() {
        return new_quantity;
    }


    /**
     * Sets the new_quantity value for this Order_quantity_option_calculate_request.
     * 
     * @param new_quantity
     */
    public void setNew_quantity(int new_quantity) {
        this.new_quantity = new_quantity;
    }


    /**
     * Gets the dsn value for this Order_quantity_option_calculate_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Order_quantity_option_calculate_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the default_pricing value for this Order_quantity_option_calculate_request.
     * 
     * @return default_pricing
     */
    public Think.XmlWebServices.ZZBoolean getDefault_pricing() {
        return default_pricing;
    }


    /**
     * Sets the default_pricing value for this Order_quantity_option_calculate_request.
     * 
     * @param default_pricing
     */
    public void setDefault_pricing(Think.XmlWebServices.ZZBoolean default_pricing) {
        this.default_pricing = default_pricing;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_quantity_option_calculate_request)) return false;
        Order_quantity_option_calculate_request other = (Order_quantity_option_calculate_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_login_data==null && other.getUser_login_data()==null) || 
             (this.user_login_data!=null &&
              this.user_login_data.equals(other.getUser_login_data()))) &&
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.item_data==null && other.getItem_data()==null) || 
             (this.item_data!=null &&
              this.item_data.equals(other.getItem_data()))) &&
            this.new_quantity == other.getNew_quantity() &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.default_pricing==null && other.getDefault_pricing()==null) || 
             (this.default_pricing!=null &&
              this.default_pricing.equals(other.getDefault_pricing())));
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
        if (getUser_login_data() != null) {
            _hashCode += getUser_login_data().hashCode();
        }
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getItem_data() != null) {
            _hashCode += getItem_data().hashCode();
        }
        _hashCode += getNew_quantity();
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getDefault_pricing() != null) {
            _hashCode += getDefault_pricing().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_quantity_option_calculate_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_quantity_option_calculate_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("default_pricing");
        attrField.setXmlName(new javax.xml.namespace.QName("", "default_pricing"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("new_quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "new_quantity"));
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
