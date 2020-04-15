package com.apiskeletonbase

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CustomerServiceSpec extends Specification implements DataTest, ServiceUnitTest<CustomerService>{

    def setup() {
        mockDomain(Customer)
        mockDomain(CustomerDetails)
        setupMocks()
    }

    def customer = new CustomerBuilder().withName("customer name").withLocation("location-1").build()
    def customerDetails = new CustomerDetailsBuilder().build()


    def setupMocks(def service = service) {
        def customerDetailsService = Mock(CustomerDetailsService)
        customerDetailsService.createCustomerDetail(_) >> customerDetails

        service.customerDetailsService = customerDetailsService
    }



    def cleanup() {
    }

    void "test create customer"() {
        when:
            def customer = service.createCustomer("some name", "some location", "someaddress")
        then:
            customer.name.toLowerCase() == "some name"
            customer.customerDetails.address1 == customerDetails.address1
    }
}
