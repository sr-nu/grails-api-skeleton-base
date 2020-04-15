package com.apiskeletonbase

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CustomerDetailsServiceSpec extends Specification implements DataTest, ServiceUnitTest<CustomerDetailsService>{

    def setup() {
        mockDomain(CustomerDetails)
        setupMocks()
    }

    def setupMocks() {
    }

    def cleanup() {
    }

    def "test valid address can be split to components"() {
        given:
            def addressString = "some block, some area, 1234"
        when:
            String[] addressComponents = service.splitToComponents(addressString)
        then:
            addressComponents.length == 3
    }

    def "test address can be split to components"() {
        given:
            def addressString = "some block"
        when:
            String[] addressComponents = service.splitToComponents(addressString)
        then:
            addressComponents.length == 3
    }

    def "test customer details are split before save"() {
        given:
            def addressString = "some block, some area, 1234"
        when:
            def result = service.createCustomerDetail(addressString)
        then:
            result.address1 ==  'some block'
            result.address2 ==  'some area'
            result.zipcode == '1234'

    }
}
