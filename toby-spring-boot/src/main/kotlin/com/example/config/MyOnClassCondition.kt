package com.example.config

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils

class MyOnClassCondition : Condition {

    override fun matches(
        context: ConditionContext,
        metadata: AnnotatedTypeMetadata,
    ): Boolean {
        val attributes = metadata.getAnnotationAttributes(ConditionalMyOnClass::class.java.name)
        val className = attributes!!["value"] as String
        return ClassUtils.isPresent(className, context.classLoader)
    }

}
