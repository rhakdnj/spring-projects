package com.example.config

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class MyAutoConfigImportSelector : DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        return arrayOf(
            "com.example.config.autoconfig.DispatcherServletConfig",
            "com.example.config.autoconfig.TomcatWebServerConfig",
        )
    }
}
