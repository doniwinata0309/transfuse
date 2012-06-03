package org.androidtransfuse.integrationTest.inject;

import org.androidtransfuse.annotations.Parcel;
import org.androidtransfuse.integrationTest.SerializableValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author John Ericksen
 */
@Parcel
public class ParcelExample {

    private String name;
    private double value;
    private ParcelTwo innerParcel;
    private RealParcelable realParcelable;
    private SerializableValue serializableValue;
    private boolean[] booleans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ParcelTwo getInnerParcel() {
        return innerParcel;
    }

    public void setInnerParcel(ParcelTwo innerParcel) {
        this.innerParcel = innerParcel;
    }

    public SerializableValue getSerializableValue() {
        return serializableValue;
    }

    public void setSerializableValue(SerializableValue serializableValue) {
        this.serializableValue = serializableValue;
    }

    public boolean[] getBooleans() {
        return booleans;
    }

    public void setBooleans(boolean[] booleans) {
        this.booleans = booleans;
    }

    public RealParcelable getRealParcelable() {
        return realParcelable;
    }

    public void setRealParcelable(RealParcelable realParcelable) {
        this.realParcelable = realParcelable;
    }

    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}