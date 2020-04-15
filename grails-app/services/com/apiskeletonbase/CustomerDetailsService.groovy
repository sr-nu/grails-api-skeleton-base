package com.apiskeletonbase

import grails.gorm.transactions.Transactional

@Transactional
class CustomerDetailsService {

    def serviceMethod() {

    }

    def createCustomerDetail(String addressString) {
        def address = splitToComponents(addressString)
        def result = new CustomerDetails([
                address1: valueOrDefault(address[0]),
                address2: valueOrDefault(address[1]),
                zipcode : valueOrDefault(address[2])
        ]).save()
        return result
    }

    def splitToComponents(String addressString) {
        def splits = addressString.split(",").toList()
        splits.addAll(["","",""])
        return splits[0..2]
    }

    private String valueOrDefault(String address) {
        return address?: ""
    }
}
