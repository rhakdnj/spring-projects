## 07. 자동 구성 기반 애플리케이션

### 인프라 빈 구성 정보의 분리

`@Import`를 이용하면 스캔 대상이 아닌 클래스를 빈으로 등록하도록 추가할 수 있다.
애플리케이션 인프라스트럭처 빈 구성 정보 클래스는 스프링 부트의 자동 구성 메카니즘에 의해서 등록이 되도록 분리하는 작업이 우선 필요하다.
분리된 클래스는 @Import로 포함시킨다.

```kotlin
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(DispatcherServletConfig::class, TomcatWebServerConfig::class)
annotation class EnableMyAutoConfiguration
```

```kotlin
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
annotation class MySpringBootApplication
```
