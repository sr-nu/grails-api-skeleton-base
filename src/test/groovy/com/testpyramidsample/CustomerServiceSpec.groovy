package com.testpyramidsample

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CustomerServiceSpec extends Specification implements DataTest, ServiceUnitTest<CustomerService>{

    def setup() {
        mockDomain(Customer)
        setupMocks()
    }

    def customer = new CustomerBuilder().withName("customer name").withLocation("location-1").build()
    def setupMocks(def service = service) {
        def customerService = Mock(CustomerService)
        customerService.saveCustomerDetails(_, _,) >> customer
        service.eventDetailService = eventDetailServiceMock

        def eventAssetServiceMock = Mock(EventAssetService)
        eventAssetServiceMock.createEventAsset(_, _, _, _) >> eventAsset
        service.eventAssetService = eventAssetServiceMock
    }



    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
