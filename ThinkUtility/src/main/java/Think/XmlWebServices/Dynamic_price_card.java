/**
 * Dynamic_price_card.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Dynamic_price_card  implements java.io.Serializable {
    private int dynamic_price_id;

    private int dynamic_price_seq;

    private java.lang.Integer from_cycle;

    private java.lang.Integer to_cycle;

    private java.lang.Integer dynamic_price_type;

    private java.lang.String currency;

    private java.math.BigDecimal price;

    private java.math.BigDecimal percentage;

    public Dynamic_price_card() {
    }

    public Dynamic_price_card(
           int dynamic_price_id,
           int dynamic_price_seq,
           java.lang.Integer from_cycle,
           java.lang.Integer to_cycle,
           java.lang.Integer dynamic_price_type,
           java.lang.String currency,
           java.math.BigDecimal price,
           java.math.BigDecimal percentage) {
           this.dynamic_price_id = dynamic_price_id;
           this.dynamic_price_seq = dynamic_price_seq;
           this.from_cycle = from_cycle;
           this.to_cycle = to_cycle;
           this.dynamic_price_type = dynamic_price_type;
           this.currency = currency;
           this.price = price;
           this.percentage = percentage;
    }


    /**
     * Gets the dynamic_price_id value for this Dynamic_price_card.
     * 
     * @return dynamic_price_id
     */
    public int getDynamic_price_id() {
        return dynamic_price_id;
    }


    /**
     * Sets the dynamic_price_id value for this Dynamic_price_card.
     * 
     * @param dynamic_price_id
     */
    public void setDynamic_price_id(int dynamic_price_id) {
        this.dynamic_price_id = dynamic_price_id;
    }


    /**
     * Gets the dynamic_price_seq value for this Dynamic_price_card.
     * 
     * @return dynamic_price_seq
     */
    public int getDynamic_price_seq() {
        return dynamic_price_seq;
    }


    /**
     * Sets the dynamic_price_seq value for this Dynamic_price_card.
     * 
     * @param dynamic_price_seq
     */
    public void setDynamic_price_seq(int dynamic_price_seq) {
        this.dynamic_price_seq = dynamic_price_seq;
    }


    /**
     * Gets the from_cycle value for this Dynamic_price_card.
     * 
     * @return from_cycle
     */
    public java.lang.Integer getFrom_cycle() {
        return from_cycle;
    }


    /**
     * Sets the from_cycle value for this Dynamic_price_card.
     * 
     * @param from_cycle
     */
    public void setFrom_cycle(java.lang.Integer from_cycle) {
        this.from_cycle = from_cycle;
    }


    /**
     * Gets the to_cycle value for this Dynamic_price_card.
     * 
     * @return to_cycle
     */
    public java.lang.Integer getTo_cycle() {
        return to_cycle;
    }


    /**
     * Sets the to_cycle value for this Dynamic_price_card.
     * 
     * @param to_cycle
     */
    public void setTo_cycle(java.lang.Integer to_cycle) {
        this.to_cycle = to_cycle;
    }


    /**
     * Gets the dynamic_price_type value for this Dynamic_price_card.
     * 
     * @return dynamic_price_type
     */
    public java.lang.Integer getDynamic_price_type() {
        return dynamic_price_type;
    }


    /**
     * Sets the dynamic_price_type value for this Dynamic_price_card.
     * 
     * @param dynamic_price_type
     */
    public void setDynamic_price_type(java.lang.Integer dynamic_price_type) {
        this.dynamic_price_type = dynamic_price_type;
    }


    /**
     * Gets the currency value for this Dynamic_price_card.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Dynamic_price_card.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the price value for this Dynamic_price_card.
     * 
     * @return price
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Dynamic_price_card.
     * 
     * @param price
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }


    /**
     * Gets the percentage value for this Dynamic_price_card.
     * 
     * @return percentage
     */
    public java.math.BigDecimal getPercentage() {
        return percentage;
    }


    /**
     * Sets the percentage value for this Dynamic_price_card.
     * 
     * @param percentage
     */
    public void setPercentage(java.math.BigDecimal percentage) {
        this.percentage = percentage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dynamic_price_card)) return false;
        Dynamic_price_card other = (Dynamic_price_card) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.dynamic_price_id == other.getDynamic_price_id() &&
            this.dynamic_price_seq == other.getDynamic_price_seq() &&
            ((this.from_cycle==null && other.getFrom_cycle()==null) || 
             (this.from_cycle!=null &&
              this.from_cycle.equals(other.getFrom_cycle()))) &&
            ((this.to_cycle==null && other.getTo_cycle()==null) || 
             (this.to_cycle!=null &&
              this.to_cycle.equals(other.getTo_cycle()))) &&
            ((this.dynamic_price_type==null && other.getDynamic_price_type()==null) || 
             (this.dynamic_price_type!=null &&
              this.dynamic_price_type.equals(other.getDynamic_price_type()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            ((this.percentage==null && other.getPercentage()==null) || 
             (this.percentage!=null &&
              this.percentage.equals(other.getPercentage())));
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
        _hashCode += getDynamic_price_seq();
        if (getFrom_cycle() != null) {
            _hashCode += getFrom_cycle().hashCode();
        }
        if (getTo_cycle() != null) {
            _hashCode += getTo_cycle().hashCode();
        }
        if (getDynamic_price_type() != null) {
            _hashCode += getDynamic_price_type().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        if (getPercentage() != null) {
            _hashCode += getPercentage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dynamic_price_card.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">dynamic_price_card"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("from_cycle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "from_cycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("to_cycle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "to_cycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dynamic_price_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dynamic_price_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percentage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "Percentage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
