/**
 * Threshold_option_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Threshold_option_type implements java.io.Serializable {
    private org.apache.axis.types.NMToken _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Threshold_option_type(org.apache.axis.types.NMToken value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.NMToken _accept_as_full = new org.apache.axis.types.NMToken("accept_as_full");
    public static final org.apache.axis.types.NMToken _prorate = new org.apache.axis.types.NMToken("prorate");
    public static final org.apache.axis.types.NMToken _partial = new org.apache.axis.types.NMToken("partial");
    public static final org.apache.axis.types.NMToken _refund_or_deposit = new org.apache.axis.types.NMToken("refund_or_deposit");
    public static final org.apache.axis.types.NMToken _reject = new org.apache.axis.types.NMToken("reject");
    public static final Threshold_option_type accept_as_full = new Threshold_option_type(_accept_as_full);
    public static final Threshold_option_type prorate = new Threshold_option_type(_prorate);
    public static final Threshold_option_type partial = new Threshold_option_type(_partial);
    public static final Threshold_option_type refund_or_deposit = new Threshold_option_type(_refund_or_deposit);
    public static final Threshold_option_type reject = new Threshold_option_type(_reject);
    public org.apache.axis.types.NMToken getValue() { return _value_;}
    public static Threshold_option_type fromValue(org.apache.axis.types.NMToken value)
          throws java.lang.IllegalArgumentException {
        Threshold_option_type enumeration = (Threshold_option_type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Threshold_option_type fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        try {
            return fromValue(new org.apache.axis.types.NMToken(value));
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_.toString();}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Threshold_option_type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "threshold_option_type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
