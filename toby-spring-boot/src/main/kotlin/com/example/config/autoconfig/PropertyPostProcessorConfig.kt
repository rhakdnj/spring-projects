package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import com.example.config.MyConfigurationProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.env.Environment

@MyAutoConfiguration
class PropertyPostProcessorConfig {

    /**
     * 모든 빈은 생성 후에 해당 postProcessor 처리가 됩니다.
     */
    companion object {
        @Bean
        @JvmStatic
        fun beanPostProcessor(env: Environment): BeanPostProcessor {
            return object : BeanPostProcessor {
                override fun postProcessBeforeInitialization(
                    bean: Any,
                    beanName: String,
                ): Any {
                    val annotation =
                        AnnotationUtils.findAnnotation(bean.javaClass, MyConfigurationProperties::class.java)
                            ?: return bean

                    return Binder.get(env).bindOrCreate(annotation.prefix, bean.javaClass)
                }
            }
        }
    }

}
