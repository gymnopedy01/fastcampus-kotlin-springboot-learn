메타 에노테이션

# @EnableAutoConfiguration

스프링부트의 자동설정을 활성화 하는 어노테이션

# @SpringBootConfiguration

추가적인 설정 클래스르 ㄹ가져오거나 정의된 빈을 스프링 컨텍스트에 추가

# @ComponentScan

컴퍼넌트 어노테이션을 선언한 패키지를 스캔하도록 활성화 하는 어노테이션



# 스프링부트 자동설정
## 자동설정이란?
Auto-configuration 은 스프링부트를 말할 때 빠질 수 없는 핵심기술
자동설정은 개발자들이 스프링 관련 프레임워크나 라이브러리를 추가했을때 번거로운 설정 없이 동작하도록 최저화된 자동 설정을 내장하고 있는것을 말한다
예를 들어 스프링 부트프로젝트에 스프링 데이터 JPA, 스프링 데이ㅓ 몽고디비와 같은 프로젝트를 적용하면 내장된 설정이 동작하므로 개발자는 최소한의 설정값(DB접속정보등)만 넣어주거나 경우에 따라서는 설정을 새롭게 구성할 수있다.

org.springframework.boot:spring-boot-autoconfigure:2.7.3
예전스프링부트버전에서는 spring.factories 파일 내부에 있는 autoconfig 를 찾아서 썻엇다

현재버전은 spring\org.springframework.boot.autoconfigure.AutoConfiguration.imports 파일에 자동설정에 대한 후보군이 등록되있는걸 확인할수 있다.

Conditional 어노테이션
springframework.context.annotation.Conditional.java

Conditional 기반의 조건에 따라 로드함


# @ConditionalOnBean(OnBeanCondition.class)
org.springframework.boot.autoconfigure.condition.ConditionalOnBean 
특정한 빈이 어플리케이션컨텍스에 존재하는 경우에만 해당 설정클래스가 로드가됨

# @ConditionalOnMissingBean
특정빈이 어플리케이션 컨텍스트에 존재하지 않는 경우에만 동작하게됨

# @ConditionOnClass
특정클래스 가 존재하는 경우에만 설정클래스를 로드

# @ConditionalOnMissingClass
특정클래스가 path에 존재 하지 않는경우에만 동작

# AOPAutoconfiguration 클래스를 참고
@AutoConfiguration 자동설정 클래스이라는걸 알려줌. EnableAutoConfiguration 이 참고 하게됨
@ConditionalOnProperty(prefix="spring.aop", name="auto", havingValue="true", matchIfMissing=true) //조건부 어노테이션 프로퍼티 값이 spring.aop 의 값이 auto이고 값이 true이면 동작한다. matchIfmissing 앞에 있는 설정값들이 존재 하지 않으면 동작 한다.

spring.aop.auto=true

실제로 spring.aop.auto=true 를 설정하지 않아도 aop가 동작한다. 그이유는 matchIfMissing 설정이 true 로 되어있기 때문이다.

