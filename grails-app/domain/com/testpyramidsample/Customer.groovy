package com.testpyramidsample

import com.testpyramidsample.annotations.JsonMarshallerFormat

class Customer {

    String name
    String location
    CustomerDetails customerDetails

    static constraints = {
        name blank: false
        location nullable: false
        customerDetails nullable: true
    }

    @JsonMarshallerFormat
    static marshallerFormat = { Customer customer ->
        return [
                name    : customer?.name,
                location: customer?.location,
                address1: customer?.customerDetails?.address1,
                address2: customer?.customerDetails?.address1,
                zipcode : customer?.customerDetails?.zipcode
        ]
    }

}
