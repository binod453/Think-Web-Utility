/**
 * Back_issue_full_list_select_responseBack_issue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Back_issue_full_list_select_responseBack_issue  implements java.io.Serializable {
    private int subscrip_id;  // attribute

    private int qty_ordered;  // attribute

    private int qty_sent;  // attribute

    private int status;  // attribute

    private int reason;  // attribute

    private int rollback_job_id;  // attribute

    private int issue_type;  // attribute

    private int issue_id;  // attribute

    private int oc_id;  // attribute

    private int inventory_id;  // attribute

    private java.lang.String user_code;  // attribute

    private java.util.Date issue_date;  // attribute

    private java.lang.String enumeration;  // attribute

    private int enum_volume_nbr;  // attribute

    private int enum_issue_nbr;  // attribute

    private java.util.Calendar issue_close_date;  // attribute

    private int sub_out_bit_pos;  // attribute

    private java.util.Date drop_date;  // attribute

    private java.util.Date audit_begin_date;  // attribute

    private java.util.Date audit_end_date;  // attribute

    private int audit_galley_created;  // attribute

    private int audit_galley_sorted;  // attribute

    private int audit_galley_nth_done;  // attribute

    private int volume_group_id;  // attribute

    private int generate_revenue;  // attribute

    private int update_orders;  // attribute

    private java.lang.String issue_url;  // attribute

    private int analyzed;  // attribute

    private int frozen;  // attribute

    public Back_issue_full_list_select_responseBack_issue() {
    }

    public Back_issue_full_list_select_responseBack_issue(
           int subscrip_id,
           int qty_ordered,
           int qty_sent,
           int status,
           int reason,
           int rollback_job_id,
           int issue_type,
           int issue_id,
           int oc_id,
           int inventory_id,
           java.lang.String user_code,
           java.util.Date issue_date,
           java.lang.String enumeration,
           int enum_volume_nbr,
           int enum_issue_nbr,
           java.util.Calendar issue_close_date,
           int sub_out_bit_pos,
           java.util.Date drop_date,
           java.util.Date audit_begin_date,
           java.util.Date audit_end_date,
           int audit_galley_created,
           int audit_galley_sorted,
           int audit_galley_nth_done,
           int volume_group_id,
           int generate_revenue,
           int update_orders,
           java.lang.String issue_url,
           int analyzed,
           int frozen) {
           this.subscrip_id = subscrip_id;
           this.qty_ordered = qty_ordered;
           this.qty_sent = qty_sent;
           this.status = status;
           this.reason = reason;
           this.rollback_job_id = rollback_job_id;
           this.issue_type = issue_type;
           this.issue_id = issue_id;
           this.oc_id = oc_id;
           this.inventory_id = inventory_id;
           this.user_code = user_code;
           this.issue_date = issue_date;
           this.enumeration = enumeration;
           this.enum_volume_nbr = enum_volume_nbr;
           this.enum_issue_nbr = enum_issue_nbr;
           this.issue_close_date = issue_close_date;
           this.sub_out_bit_pos = sub_out_bit_pos;
           this.drop_date = drop_date;
           this.audit_begin_date = audit_begin_date;
           this.audit_end_date = audit_end_date;
           this.audit_galley_created = audit_galley_created;
           this.audit_galley_sorted = audit_galley_sorted;
           this.audit_galley_nth_done = audit_galley_nth_done;
           this.volume_group_id = volume_group_id;
           this.generate_revenue = generate_revenue;
           this.update_orders = update_orders;
           this.issue_url = issue_url;
           this.analyzed = analyzed;
           this.frozen = frozen;
    }


    /**
     * Gets the subscrip_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the qty_ordered value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return qty_ordered
     */
    public int getQty_ordered() {
        return qty_ordered;
    }


    /**
     * Sets the qty_ordered value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param qty_ordered
     */
    public void setQty_ordered(int qty_ordered) {
        this.qty_ordered = qty_ordered;
    }


    /**
     * Gets the qty_sent value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return qty_sent
     */
    public int getQty_sent() {
        return qty_sent;
    }


    /**
     * Sets the qty_sent value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param qty_sent
     */
    public void setQty_sent(int qty_sent) {
        this.qty_sent = qty_sent;
    }


    /**
     * Gets the status value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the reason value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return reason
     */
    public int getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param reason
     */
    public void setReason(int reason) {
        this.reason = reason;
    }


    /**
     * Gets the rollback_job_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return rollback_job_id
     */
    public int getRollback_job_id() {
        return rollback_job_id;
    }


    /**
     * Sets the rollback_job_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param rollback_job_id
     */
    public void setRollback_job_id(int rollback_job_id) {
        this.rollback_job_id = rollback_job_id;
    }


    /**
     * Gets the issue_type value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return issue_type
     */
    public int getIssue_type() {
        return issue_type;
    }


    /**
     * Sets the issue_type value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param issue_type
     */
    public void setIssue_type(int issue_type) {
        this.issue_type = issue_type;
    }


    /**
     * Gets the issue_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return issue_id
     */
    public int getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param issue_id
     */
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the oc_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the inventory_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return inventory_id
     */
    public int getInventory_id() {
        return inventory_id;
    }


    /**
     * Sets the inventory_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param inventory_id
     */
    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }


    /**
     * Gets the user_code value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the issue_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return issue_date
     */
    public java.util.Date getIssue_date() {
        return issue_date;
    }


    /**
     * Sets the issue_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param issue_date
     */
    public void setIssue_date(java.util.Date issue_date) {
        this.issue_date = issue_date;
    }


    /**
     * Gets the enumeration value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return enumeration
     */
    public java.lang.String getEnumeration() {
        return enumeration;
    }


    /**
     * Sets the enumeration value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param enumeration
     */
    public void setEnumeration(java.lang.String enumeration) {
        this.enumeration = enumeration;
    }


    /**
     * Gets the enum_volume_nbr value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return enum_volume_nbr
     */
    public int getEnum_volume_nbr() {
        return enum_volume_nbr;
    }


    /**
     * Sets the enum_volume_nbr value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param enum_volume_nbr
     */
    public void setEnum_volume_nbr(int enum_volume_nbr) {
        this.enum_volume_nbr = enum_volume_nbr;
    }


    /**
     * Gets the enum_issue_nbr value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return enum_issue_nbr
     */
    public int getEnum_issue_nbr() {
        return enum_issue_nbr;
    }


    /**
     * Sets the enum_issue_nbr value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param enum_issue_nbr
     */
    public void setEnum_issue_nbr(int enum_issue_nbr) {
        this.enum_issue_nbr = enum_issue_nbr;
    }


    /**
     * Gets the issue_close_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return issue_close_date
     */
    public java.util.Calendar getIssue_close_date() {
        return issue_close_date;
    }


    /**
     * Sets the issue_close_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param issue_close_date
     */
    public void setIssue_close_date(java.util.Calendar issue_close_date) {
        this.issue_close_date = issue_close_date;
    }


    /**
     * Gets the sub_out_bit_pos value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return sub_out_bit_pos
     */
    public int getSub_out_bit_pos() {
        return sub_out_bit_pos;
    }


    /**
     * Sets the sub_out_bit_pos value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param sub_out_bit_pos
     */
    public void setSub_out_bit_pos(int sub_out_bit_pos) {
        this.sub_out_bit_pos = sub_out_bit_pos;
    }


    /**
     * Gets the drop_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return drop_date
     */
    public java.util.Date getDrop_date() {
        return drop_date;
    }


    /**
     * Sets the drop_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param drop_date
     */
    public void setDrop_date(java.util.Date drop_date) {
        this.drop_date = drop_date;
    }


    /**
     * Gets the audit_begin_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return audit_begin_date
     */
    public java.util.Date getAudit_begin_date() {
        return audit_begin_date;
    }


    /**
     * Sets the audit_begin_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param audit_begin_date
     */
    public void setAudit_begin_date(java.util.Date audit_begin_date) {
        this.audit_begin_date = audit_begin_date;
    }


    /**
     * Gets the audit_end_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return audit_end_date
     */
    public java.util.Date getAudit_end_date() {
        return audit_end_date;
    }


    /**
     * Sets the audit_end_date value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param audit_end_date
     */
    public void setAudit_end_date(java.util.Date audit_end_date) {
        this.audit_end_date = audit_end_date;
    }


    /**
     * Gets the audit_galley_created value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return audit_galley_created
     */
    public int getAudit_galley_created() {
        return audit_galley_created;
    }


    /**
     * Sets the audit_galley_created value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param audit_galley_created
     */
    public void setAudit_galley_created(int audit_galley_created) {
        this.audit_galley_created = audit_galley_created;
    }


    /**
     * Gets the audit_galley_sorted value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return audit_galley_sorted
     */
    public int getAudit_galley_sorted() {
        return audit_galley_sorted;
    }


    /**
     * Sets the audit_galley_sorted value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param audit_galley_sorted
     */
    public void setAudit_galley_sorted(int audit_galley_sorted) {
        this.audit_galley_sorted = audit_galley_sorted;
    }


    /**
     * Gets the audit_galley_nth_done value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return audit_galley_nth_done
     */
    public int getAudit_galley_nth_done() {
        return audit_galley_nth_done;
    }


    /**
     * Sets the audit_galley_nth_done value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param audit_galley_nth_done
     */
    public void setAudit_galley_nth_done(int audit_galley_nth_done) {
        this.audit_galley_nth_done = audit_galley_nth_done;
    }


    /**
     * Gets the volume_group_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return volume_group_id
     */
    public int getVolume_group_id() {
        return volume_group_id;
    }


    /**
     * Sets the volume_group_id value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param volume_group_id
     */
    public void setVolume_group_id(int volume_group_id) {
        this.volume_group_id = volume_group_id;
    }


    /**
     * Gets the generate_revenue value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return generate_revenue
     */
    public int getGenerate_revenue() {
        return generate_revenue;
    }


    /**
     * Sets the generate_revenue value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param generate_revenue
     */
    public void setGenerate_revenue(int generate_revenue) {
        this.generate_revenue = generate_revenue;
    }


    /**
     * Gets the update_orders value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return update_orders
     */
    public int getUpdate_orders() {
        return update_orders;
    }


    /**
     * Sets the update_orders value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param update_orders
     */
    public void setUpdate_orders(int update_orders) {
        this.update_orders = update_orders;
    }


    /**
     * Gets the issue_url value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return issue_url
     */
    public java.lang.String getIssue_url() {
        return issue_url;
    }


    /**
     * Sets the issue_url value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param issue_url
     */
    public void setIssue_url(java.lang.String issue_url) {
        this.issue_url = issue_url;
    }


    /**
     * Gets the analyzed value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return analyzed
     */
    public int getAnalyzed() {
        return analyzed;
    }


    /**
     * Sets the analyzed value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param analyzed
     */
    public void setAnalyzed(int analyzed) {
        this.analyzed = analyzed;
    }


    /**
     * Gets the frozen value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @return frozen
     */
    public int getFrozen() {
        return frozen;
    }


    /**
     * Sets the frozen value for this Back_issue_full_list_select_responseBack_issue.
     * 
     * @param frozen
     */
    public void setFrozen(int frozen) {
        this.frozen = frozen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Back_issue_full_list_select_responseBack_issue)) return false;
        Back_issue_full_list_select_responseBack_issue other = (Back_issue_full_list_select_responseBack_issue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.subscrip_id == other.getSubscrip_id() &&
            this.qty_ordered == other.getQty_ordered() &&
            this.qty_sent == other.getQty_sent() &&
            this.status == other.getStatus() &&
            this.reason == other.getReason() &&
            this.rollback_job_id == other.getRollback_job_id() &&
            this.issue_type == other.getIssue_type() &&
            this.issue_id == other.getIssue_id() &&
            this.oc_id == other.getOc_id() &&
            this.inventory_id == other.getInventory_id() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.issue_date==null && other.getIssue_date()==null) || 
             (this.issue_date!=null &&
              this.issue_date.equals(other.getIssue_date()))) &&
            ((this.enumeration==null && other.getEnumeration()==null) || 
             (this.enumeration!=null &&
              this.enumeration.equals(other.getEnumeration()))) &&
            this.enum_volume_nbr == other.getEnum_volume_nbr() &&
            this.enum_issue_nbr == other.getEnum_issue_nbr() &&
            ((this.issue_close_date==null && other.getIssue_close_date()==null) || 
             (this.issue_close_date!=null &&
              this.issue_close_date.equals(other.getIssue_close_date()))) &&
            this.sub_out_bit_pos == other.getSub_out_bit_pos() &&
            ((this.drop_date==null && other.getDrop_date()==null) || 
             (this.drop_date!=null &&
              this.drop_date.equals(other.getDrop_date()))) &&
            ((this.audit_begin_date==null && other.getAudit_begin_date()==null) || 
             (this.audit_begin_date!=null &&
              this.audit_begin_date.equals(other.getAudit_begin_date()))) &&
            ((this.audit_end_date==null && other.getAudit_end_date()==null) || 
             (this.audit_end_date!=null &&
              this.audit_end_date.equals(other.getAudit_end_date()))) &&
            this.audit_galley_created == other.getAudit_galley_created() &&
            this.audit_galley_sorted == other.getAudit_galley_sorted() &&
            this.audit_galley_nth_done == other.getAudit_galley_nth_done() &&
            this.volume_group_id == other.getVolume_group_id() &&
            this.generate_revenue == other.getGenerate_revenue() &&
            this.update_orders == other.getUpdate_orders() &&
            ((this.issue_url==null && other.getIssue_url()==null) || 
             (this.issue_url!=null &&
              this.issue_url.equals(other.getIssue_url()))) &&
            this.analyzed == other.getAnalyzed() &&
            this.frozen == other.getFrozen();
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
        _hashCode += getSubscrip_id();
        _hashCode += getQty_ordered();
        _hashCode += getQty_sent();
        _hashCode += getStatus();
        _hashCode += getReason();
        _hashCode += getRollback_job_id();
        _hashCode += getIssue_type();
        _hashCode += getIssue_id();
        _hashCode += getOc_id();
        _hashCode += getInventory_id();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getIssue_date() != null) {
            _hashCode += getIssue_date().hashCode();
        }
        if (getEnumeration() != null) {
            _hashCode += getEnumeration().hashCode();
        }
        _hashCode += getEnum_volume_nbr();
        _hashCode += getEnum_issue_nbr();
        if (getIssue_close_date() != null) {
            _hashCode += getIssue_close_date().hashCode();
        }
        _hashCode += getSub_out_bit_pos();
        if (getDrop_date() != null) {
            _hashCode += getDrop_date().hashCode();
        }
        if (getAudit_begin_date() != null) {
            _hashCode += getAudit_begin_date().hashCode();
        }
        if (getAudit_end_date() != null) {
            _hashCode += getAudit_end_date().hashCode();
        }
        _hashCode += getAudit_galley_created();
        _hashCode += getAudit_galley_sorted();
        _hashCode += getAudit_galley_nth_done();
        _hashCode += getVolume_group_id();
        _hashCode += getGenerate_revenue();
        _hashCode += getUpdate_orders();
        if (getIssue_url() != null) {
            _hashCode += getIssue_url().hashCode();
        }
        _hashCode += getAnalyzed();
        _hashCode += getFrozen();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Back_issue_full_list_select_responseBack_issue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>back_issue_full_list_select_response>back_issue"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_ordered");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_ordered"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("qty_sent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "qty_sent"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("reason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "reason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rollback_job_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rollback_job_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inventory_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "inventory_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enumeration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enumeration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enum_volume_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enum_volume_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("enum_issue_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "enum_issue_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_close_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_close_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sub_out_bit_pos");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sub_out_bit_pos"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("drop_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "drop_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_begin_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_begin_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_end_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_end_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_galley_created");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_galley_created"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_galley_sorted");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_galley_sorted"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("audit_galley_nth_done");
        attrField.setXmlName(new javax.xml.namespace.QName("", "audit_galley_nth_done"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("volume_group_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "volume_group_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("generate_revenue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "generate_revenue"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("update_orders");
        attrField.setXmlName(new javax.xml.namespace.QName("", "update_orders"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issue_url");
        attrField.setXmlName(new javax.xml.namespace.QName("", "issue_url"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("analyzed");
        attrField.setXmlName(new javax.xml.namespace.QName("", "analyzed"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("frozen");
        attrField.setXmlName(new javax.xml.namespace.QName("", "frozen"));
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
