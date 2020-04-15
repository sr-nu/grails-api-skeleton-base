package com.testpyramidsample

class CustomerBuilder {
    String name
    String location
    CustomerDetails customerDetails


    def withName(String name){
        this.name = name
        return this
    }

    def withLocation(String location){
        this.location = location
        return this
    }

    def withCustomerDetails(String customerDetails){
        this.customerDetails = customerDetails
        return this
    }

    def build() {
        return new Customer(
                name: name,
                location: location,
                customerDetails: customerDetails
        )
    }

}
