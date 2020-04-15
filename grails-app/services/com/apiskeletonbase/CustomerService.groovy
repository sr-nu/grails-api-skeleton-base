package com.apiskeletonbase

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {
    def customerDetailsService

    def getCustomer(String name) {
        return Customer.findByName(name)
    }

    def getCustomer(Long id) {
        return Customer.findById(id)
    }

    def getAllCustomers() {
        return Customer.list()
    }

    def createCustomer(String name, String location, String addressString) {
        CustomerDetails customerDetails = customerDetailsService.createCustomerDetail(addressString)
        new Customer(
                name     : normalise(name),
                location : normalise(location),
                customerDetails    : customerDetails
        ).save()
    }

    def normalise(String s) {
        return s.toUpperCase()
    }
}
