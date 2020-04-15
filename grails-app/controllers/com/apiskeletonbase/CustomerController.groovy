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

}
