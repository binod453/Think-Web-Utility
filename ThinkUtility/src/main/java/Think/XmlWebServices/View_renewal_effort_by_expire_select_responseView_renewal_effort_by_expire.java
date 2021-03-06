/**
 * View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire  implements java.io.Serializable {
    private int job_id;  // attribute

    private int oc_id;  // attribute

    private java.lang.String renewal_def;  // attribute

    private int renewal_def_test_seq;  // attribute

    private int effort_number;  // attribute

    private java.lang.String criterion;  // attribute

    private int totaleffort;  // attribute

    private java.lang.String oc;  // attribute

    public View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire() {
    }

    public View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire(
           int job_id,
           int oc_id,
           java.lang.String renewal_def,
           int renewal_def_test_seq,
           int effort_number,
           java.lang.String criterion,
           int totaleffort,
           java.lang.String oc) {
           this.job_id = job_id;
           this.oc_id = oc_id;
           this.renewal_def = renewal_def;
           this.renewal_def_test_seq = renewal_def_test_seq;
           this.effort_number = effort_number;
           this.criterion = criterion;
           this.totaleffort = totaleffort;
           this.oc = oc;
    }


    /**
     * Gets the job_id value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return job_id
     */
    public int getJob_id() {
        return job_id;
    }


    /**
     * Sets the job_id value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param job_id
     */
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }


    /**
     * Gets the oc_id value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the renewal_def value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return renewal_def
     */
    public java.lang.String getRenewal_def() {
        return renewal_def;
    }


    /**
     * Sets the renewal_def value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param renewal_def
     */
    public void setRenewal_def(java.lang.String renewal_def) {
        this.renewal_def = renewal_def;
    }


    /**
     * Gets the renewal_def_test_seq value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return renewal_def_test_seq
     */
    public int getRenewal_def_test_seq() {
        return renewal_def_test_seq;
    }


    /**
     * Sets the renewal_def_test_seq value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param renewal_def_test_seq
     */
    public void setRenewal_def_test_seq(int renewal_def_test_seq) {
        this.renewal_def_test_seq = renewal_def_test_seq;
    }


    /**
     * Gets the effort_number value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return effort_number
     */
    public int getEffort_number() {
        return effort_number;
    }


    /**
     * Sets the effort_number value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param effort_number
     */
    public void setEffort_number(int effort_number) {
        this.effort_number = effort_number;
    }


    /**
     * Gets the criterion value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return criterion
     */
    public java.lang.String getCriterion() {
        return criterion;
    }


    /**
     * Sets the criterion value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param criterion
     */
    public void setCriterion(java.lang.String criterion) {
        this.criterion = criterion;
    }


    /**
     * Gets the totaleffort value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return totaleffort
     */
    public int getTotaleffort() {
        return totaleffort;
    }


    /**
     * Sets the totaleffort value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param totaleffort
     */
    public void setTotaleffort(int totaleffort) {
        this.totaleffort = totaleffort;
    }


    /**
     * Gets the oc value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @return oc
     */
    public java.lang.String getOc() {
        return oc;
    }


    /**
     * Sets the oc value for this View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.
     * 
     * @param oc
     */
    public void setOc(java.lang.String oc) {
        this.oc = oc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire)) return false;
        View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire other = (View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.job_id == other.getJob_id() &&
            this.oc_id == other.getOc_id() &&
            ((this.renewal_def==null && other.getRenewal_def()==null) || 
             (this.renewal_def!=null &&
              this.renewal_def.equals(other.getRenewal_def()))) &&
            this.renewal_def_test_seq == other.getRenewal_def_test_seq() &&
            this.effort_number == other.getEffort_number() &&
            ((this.criterion==null && other.getCriterion()==null) || 
             (this.criterion!=null &&
              this.criterion.equals(other.getCriterion()))) &&
            this.totaleffort == other.getTotaleffort() &&
            ((this.oc==null && other.getOc()==null) || 
             (this.oc!=null &&
              this.oc.equals(other.getOc())));
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
        _hashCode += getJob_id();
        _hashCode += getOc_id();
        if (getRenewal_def() != null) {
            _hashCode += getRenewal_def().hashCode();
        }
        _hashCode += getRenewal_def_test_seq();
        _hashCode += getEffort_number();
        if (getCriterion() != null) {
            _hashCode += getCriterion().hashCode();
        }
        _hashCode += getTotaleffort();
        if (getOc() != null) {
            _hashCode += getOc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>view_renewal_effort_by_expire_select_response>view_renewal_effort_by_expire"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_def");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_def"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renewal_def_test_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renewal_def_test_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("effort_number");
        attrField.setXmlName(new javax.xml.namespace.QName("", "effort_number"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("criterion");
        attrField.setXmlName(new javax.xml.namespace.QName("", "criterion"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("totaleffort");
        attrField.setXmlName(new javax.xml.namespace.QName("", "totaleffort"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
