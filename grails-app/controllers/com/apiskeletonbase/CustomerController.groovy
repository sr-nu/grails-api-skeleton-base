package com.apiskeletonbase

import grails.converters.JSON

class CustomerController {
	static responseFormats = ['json']
    def customerService
	
    def index() {
        def result = [:]
        result = customerService.getAllCustomers()
        render(result as JSON)
    }

    def show() {
        def identifier = params?.id as Long
        Customer customer = customerService.getCustomer(identifier)
        if(!customer){
            return response.sendError(404, "Customer does not exist")
        }

        render(customer as JSON)
    }

    def save() {
        Map requestDetails = request.JSON as Map
        String name = requestDetails?.name
        String location = requestDetails?.location
        String address = requestDetails?.address

        def result = [:]
        if (name && location && address) {
            result = customerService.createCustomer(name, location, address)
        } else {
            return response.sendError(404, "Missing mandatory parameters")
        }

        render(result as JSON)
    }

}
