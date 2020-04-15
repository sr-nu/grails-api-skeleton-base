package com.apiskeletonbase

import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class CustomerDetailsServiceIntegrationSpec extends Specification{
    def customerDetailsService

    def setup() {
    }

    def cleanup() {
    }

    void "test create successful customerDetails"() {
        when:
            def saved = customerDetailsService.createCustomerDetail("some address 1, some address 2, 1234")
            def retrieved = CustomerDetails.findById(saved.id)
        then:
            saved.id == retrieved.id
            saved.address1 == retrieved.address1
            saved.address2 == retrieved.address2
            saved.zipcode == retrieved.zipcode

    }


}
