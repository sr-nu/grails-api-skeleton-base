package com.testpyramidsample

class CustomerBuilder {
    String name
    String location


    def withName(String name){
        this.name = name
        return this
    }

    def withLocation(String location){
        this.location = location
        return this
    }

    def build() {
        return new Customer(
                name: name,
                location: location
        )
    }

}
