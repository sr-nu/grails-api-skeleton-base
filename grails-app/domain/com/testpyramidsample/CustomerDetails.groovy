package com.testpyramidsample

class CustomerDetails {

    static constraints = {
        address1 nullable: false
        address2 nullable: true
        zipcode nullable: true
    }

    String address1
    String address2
    String zipcode
}
