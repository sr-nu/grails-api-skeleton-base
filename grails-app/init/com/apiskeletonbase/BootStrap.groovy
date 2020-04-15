package com.apiskeletonbase

import com.apiskeletonbase.annotations.AnnotationParsing

class BootStrap {

    def init = { servletContext ->
            AnnotationParsing.initJsonMarshallers()
    }
    def destroy = {
    }
}
