/**
 * Subscription_history.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Subscription_history  implements java.io.Serializable {
    private int orderhdr_id;  // attribute

    private int subscrip_id;  // attribute

    private java.lang.String process_id;  // attribute

    private java.lang.String issue_id;  // attribute

    private java.lang.String qty;  // attribute

    private java.util.Calendar drop_date;  // attribute

    private java.lang.String description;  // attribute

    private int customer_id;  // attribute

    public Subscription_history() {
    }

    public Subscription_history(
           int orderhdr_id,
           int subscrip_id,
           java.lang.String process_id,
           java.lang.String issue_id,
           java.lang.String qty,
           java.util.Calendar drop_date,
           java.lang.String description,
           int customer_id) {
           this.orderhdr_id = orderhdr_id;
           this.subscrip_id = subscrip_id;
           this.process_id = process_id;
           this.issue_id = issue_id;
           this.qty = qty;
           this.drop_date = drop_date;
           this.description = description;
           this.customer_id = customer_id;
    }


    /**
     * Gets the orderhdr_id value for this Subscription_history.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this Subscription_history.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the subscrip_id value for this Subscription_history.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Subscription_history.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the process_id value for this Subscription_history.
     * 
     * @return process_id
     */
    public java.lang.String getProcess_id() {
        return process_id;
    }


    /**
     * Sets the process_id value for this Subscription_history.
     * 
     * @param process_id
     */
    public void setProcess_id(java.lang.String process_id) {
        this.process_id = process_id;
    }


    /**
     * Gets the issue_id value for this Subscription_history.
     * 
     * @return issue_id
     */
    public java.lang.String getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Subscription_history.
     * 
     * @param issue_id
     */
    public void setIssue_id(java.lang.String issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the qty value for this Subscription_history.
     * 
     * @return qty
     */
    public java.lang.String getQty() {
        return qty;
    }


    /**
     * Sets the qty value for this Subscription_history.
     * 
     * @param qty
     */
    public void setQty(java.lang.String qty) {
        this.qty = qty;
    }


    /**
     * Gets the drop_date value for this Subscription_history.
     * 
     * @return drop_date
     */
    public java.util.Calendar getDrop_date() {
        return drop_date;
    }


    /**
     * Sets the drop_date value for this Subscription_history.
     * 
     * @param drop_date
     */
    public void setDrop_date(java.util.Calendar drop_date) {
        this.drop_date = drop_date;
    }


    /**
     * Gets the description value for this Subscription_history.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Subscription_history.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the customer_id value for this Subscription_history.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Subscription_history.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Subscription_history)) return false;
        Subscription_history other = (Subscription_history) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderhdr_id == other.getOrderhdr_id() &&
            this.subscrip_id == other.getSubscrip_id() &&
            ((this.process_id==null && other.getProcess_id()==null) || 
             (this.process_id!=null &&
              this.process_id.equals(other.getProcess_id()))) &&
            ((this.issue_id==null && other.getIssue_id()==null) || 
             (this.issue_id!=null &&
              this.issue_id.equals(other.getIssue_id()))) &&
            ((this.qty==null && other.getQty()==null) || 
             (this.qty!=null &&
              this.qty.equals(other.getQty()))) &&
            ((this.drop_date==null && other.getDrop_date()==null) || 
             (this.drop_date!=null &&
              this.drop_date.equals(other.getDrop_date()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.customer_id == other.getCustomer_id();
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
        _hashCode += getOrderhdr_id();
        _hashCode += getSubscrip_id();
        if (getProcess_id() != null) {
            _hashCode += getProcess_id().hashCode();
        }
        if (getIssue_id() != null) {
            _hashCode += getIssue_id().hashCode();
        }
        if (getQty() != null) {
            _hashCode += getQty().hashCode();
        }
        if (getDrop_date() != null) {
            _hashCode += getDrop_date().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getCustomer_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Subscription_history.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">subscription_history"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("process_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "process_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("drop_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "drop_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
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
