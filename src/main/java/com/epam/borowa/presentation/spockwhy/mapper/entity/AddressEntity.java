package com.epam.borowa.presentation.spockwhy.mapper.entity;

import java.util.Objects;

public class AddressEntity {

    private String streetName;
    private String streetNumber;
    private String postcode;

    public AddressEntity() {
    }

    public AddressEntity(String streetName, String streetNumber, String postcode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postcode = postcode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddressEntity address = (AddressEntity) o;
        return Objects.equals(streetName, address.streetName) &&
                Objects.equals(streetNumber, address.streetNumber) &&
                Objects.equals(postcode, address.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetNumber, postcode);
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("streetName", streetName)
                .add("streetNumber", streetNumber)
                .add("postcode", postcode)
                .toString();
    }
}
