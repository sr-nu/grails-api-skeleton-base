package com.testpyramidsample

import com.testpyramidsample.annotations.AnnotationParsing

class BootStrap {

    def init = { servletContext ->
            AnnotationParsing.initJsonMarshallers()
    }
    def destroy = {
    }
}
