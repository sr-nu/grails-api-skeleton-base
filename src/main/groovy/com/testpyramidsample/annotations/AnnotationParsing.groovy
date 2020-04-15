package com.testpyramidsample.annotations

import grails.converters.JSON
import grails.util.Holders

// To refactor if there is a better way
class AnnotationParsing {

    static initJsonMarshallers() {
        try {
            def grailsApplication = Holders.grailsApplication

            grailsApplication.getArtefacts("Domain").findAll {
                it?.clazz?.declaredFields?.findAll { field ->
                    if (field.isAnnotationPresent(JsonMarshallerFormat.class)) {
                        JSON.registerObjectMarshaller(it.clazz, it.getPropertyValue(field.name) as Closure<?>)
                    }
                }
            }


        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace()
        }
    }
}