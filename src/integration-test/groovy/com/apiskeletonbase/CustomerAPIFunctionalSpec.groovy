package com.apiskeletonbase

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

//IDE is not reliable, execute from command line ./gradlew integrationTest

@Integration
class CustomerAPIFunctionalSpec extends Specification  {
    def grailsApplication

    def setup() {
    }

    def cleanup() {
    }

    void "test creating a customer"() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        RestResponse response = rest.post("http://localhost:8080/customer") {
            json([
                    name: "test customer",
                    location: "test location",
                    address: "house 1, street1, 10001"
            ])
        }

        then:
        response.status == 200
        response.json.location == "test location".toUpperCase()
    }

    void "test retrieve a customer"() {
        given:
        RestBuilder rest = new RestBuilder()
        def createdCustomer = rest.post("http://localhost:8080/customer") {
            json([
                    name: "test customer",
                    location: "test location",
                    address: "house 1, street1, 10001"
            ])
        }

        def customerId = createdCustomer.json.id ?: 0
        when:
        RestResponse response = rest.get("http://localhost:8080/customer/"+customerId)

        then:
        response.status == 200
        response.json.location == "test location".toUpperCase()
    }
}
