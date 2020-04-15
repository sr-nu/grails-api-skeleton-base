package com.testpyramidsample

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {
    def customerDetailsService


    String normalise(String s) {
        return s.toUpperCase()
    }

    def getCustomer(String name) {
        return Customer.findByName(name)
    }

    def createCustomer(String name, String location, String addressString) {
        CustomerDetails customerDetails = customerDetailsService.createCustomerDetail(addressString)
        new Customer(
                name     : normalise(name),
                location : normalise(name),
                customerDetails    : customerDetails
        ).save()
    }
}
