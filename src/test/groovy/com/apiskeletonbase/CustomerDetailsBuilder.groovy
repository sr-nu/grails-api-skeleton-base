package com.apiskeletonbase

class CustomerDetailsBuilder {
    String address1
    String address2
    String zipcode

    CustomerDetailsBuilder() {
        address1 = "some address 1"
        address2 = "some address 2"
        zipcode = "some zip"
    }

    def withAddress1(String address1){
        this.address1 = address1
        return this
    }

    def withAddress2(String address2){
        this.address2 = address2
        return this
    }

    def withZipcode(String zipcode){
        this.zipcode = zipcode
        return this
    }

    def build() {
        return new CustomerDetails(
                address1: address1,
                address2: address2,
                zipcode: zipcode
        )
    }
}
