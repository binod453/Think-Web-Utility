/**
 * Subscription_prorate_calculate_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Subscription_prorate_calculate_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private Think.XmlWebServices.ZZSubscripIdentifier subscrip_identifier;

    private Think.XmlWebServices.Prorate_item_data prorate_item_data;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean submit;  // attribute

    private int doc_ref_id;  // attribute

    private Think.XmlWebServices.ZZBoolean check_missing_fields;  // attribute

    private Think.XmlWebServices.ZZBoolean suppress_events;  // attribute

    public Subscription_prorate_calculate_request() {
    }

    public Subscription_prorate_calculate_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           Think.XmlWebServices.ZZSubscripIdentifier subscrip_identifier,
           Think.XmlWebServices.Prorate_item_data prorate_item_data,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean submit,
           int doc_ref_id,
           Think.XmlWebServices.ZZBoolean check_missing_fields,
           Think.XmlWebServices.ZZBoolean suppress_events) {
           this.user_login_data = user_login_data;
           this.item_identifier = item_identifier;
           this.subscrip_identifier = subscrip_identifier;
           this.prorate_item_data = prorate_item_data;
           this.dsn = dsn;
           this.submit = submit;
           this.doc_ref_id = doc_ref_id;
           this.check_missing_fields = check_missing_fields;
           this.suppress_events = suppress_events;
    }


    /**
     * Gets the user_login_data value for this Subscription_prorate_calculate_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Subscription_prorate_calculate_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the item_identifier value for this Subscription_prorate_calculate_request.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Subscription_prorate_calculate_request.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the subscrip_identifier value for this Subscription_prorate_calculate_request.
     * 
     * @return subscrip_identifier
     */
    public Think.XmlWebServices.ZZSubscripIdentifier getSubscrip_identifier() {
        return subscrip_identifier;
    }


    /**
     * Sets the subscrip_identifier value for this Subscription_prorate_calculate_request.
     * 
     * @param subscrip_identifier
     */
    public void setSubscrip_identifier(Think.XmlWebServices.ZZSubscripIdentifier subscrip_identifier) {
        this.subscrip_identifier = subscrip_identifier;
    }


    /**
     * Gets the prorate_item_data value for this Subscription_prorate_calculate_request.
     * 
     * @return prorate_item_data
     */
    public Think.XmlWebServices.Prorate_item_data getProrate_item_data() {
        return prorate_item_data;
    }


    /**
     * Sets the prorate_item_data value for this Subscription_prorate_calculate_request.
     * 
     * @param prorate_item_data
     */
    public void setProrate_item_data(Think.XmlWebServices.Prorate_item_data prorate_item_data) {
        this.prorate_item_data = prorate_item_data;
    }


    /**
     * Gets the dsn value for this Subscription_prorate_calculate_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Subscription_prorate_calculate_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the submit value for this Subscription_prorate_calculate_request.
     * 
     * @return submit
     */
    public Think.XmlWebServices.ZZBoolean getSubmit() {
        return submit;
    }


    /**
     * Sets the submit value for this Subscription_prorate_calculate_request.
     * 
     * @param submit
     */
    public void setSubmit(Think.XmlWebServices.ZZBoolean submit) {
        this.submit = submit;
    }


    /**
     * Gets the doc_ref_id value for this Subscription_prorate_calculate_request.
     * 
     * @return doc_ref_id
     */
    public int getDoc_ref_id() {
        return doc_ref_id;
    }


    /**
     * Sets the doc_ref_id value for this Subscription_prorate_calculate_request.
     * 
     * @param doc_ref_id
     */
    public void setDoc_ref_id(int doc_ref_id) {
        this.doc_ref_id = doc_ref_id;
    }


    /**
     * Gets the check_missing_fields value for this Subscription_prorate_calculate_request.
     * 
     * @return check_missing_fields
     */
    public Think.XmlWebServices.ZZBoolean getCheck_missing_fields() {
        return check_missing_fields;
    }


    /**
     * Sets the check_missing_fields value for this Subscription_prorate_calculate_request.
     * 
     * @param check_missing_fields
     */
    public void setCheck_missing_fields(Think.XmlWebServices.ZZBoolean check_missing_fields) {
        this.check_missing_fields = check_missing_fields;
    }


    /**
     * Gets the suppress_events value for this Subscription_prorate_calculate_request.
     * 
     * @return suppress_events
     */
    public Think.XmlWebServices.ZZBoolean getSuppress_events() {
        return suppress_events;
    }


    /**
     * Sets the suppress_events value for this Subscription_prorate_calculate_request.
     * 
     * @param suppress_events
     */
    public void setSuppress_events(Think.XmlWebServices.ZZBoolean suppress_events) {
        this.suppress_events = suppress_events;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Subscription_prorate_calculate_request)) return false;
        Subscription_prorate_calculate_request other = (Subscription_prorate_calculate_request) obj;
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
            ((this.subscrip_identifier==null && other.getSubscrip_identifier()==null) || 
             (this.subscrip_identifier!=null &&
              this.subscrip_identifier.equals(other.getSubscrip_identifier()))) &&
            ((this.prorate_item_data==null && other.getProrate_item_data()==null) || 
             (this.prorate_item_data!=null &&
              this.prorate_item_data.equals(other.getProrate_item_data()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.submit==null && other.getSubmit()==null) || 
             (this.submit!=null &&
              this.submit.equals(other.getSubmit()))) &&
            this.doc_ref_id == other.getDoc_ref_id() &&
            ((this.check_missing_fields==null && other.getCheck_missing_fields()==null) || 
             (this.check_missing_fields!=null &&
              this.check_missing_fields.equals(other.getCheck_missing_fields()))) &&
            ((this.suppress_events==null && other.getSuppress_events()==null) || 
             (this.suppress_events!=null &&
              this.suppress_events.equals(other.getSuppress_events())));
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
        if (getSubscrip_identifier() != null) {
            _hashCode += getSubscrip_identifier().hashCode();
        }
        if (getProrate_item_data() != null) {
            _hashCode += getProrate_item_data().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getSubmit() != null) {
            _hashCode += getSubmit().hashCode();
        }
        _hashCode += getDoc_ref_id();
        if (getCheck_missing_fields() != null) {
            _hashCode += getCheck_missing_fields().hashCode();
        }
        if (getSuppress_events() != null) {
            _hashCode += getSuppress_events().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Subscription_prorate_calculate_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">subscription_prorate_calculate_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("submit");
        attrField.setXmlName(new javax.xml.namespace.QName("", "submit"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("doc_ref_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "doc_ref_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("check_missing_fields");
        attrField.setXmlName(new javax.xml.namespace.QName("", "check_missing_fields"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_events");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_events"));
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
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZSubscripIdentifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prorate_item_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "prorate_item_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">prorate_item_data"));
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
