# 📋 SW 활용 현황 통계 API 구축 프로젝트

> **과정명:** 코멘토 - IT 대기업 현업 개발자와 함께 하는 백엔드 개발 실무  
> **진행 기간:** 2026. 01. 17 ~ 2026. 02. 14

## 1. 프로젝트 개요
본 프로젝트는 **SW 활용 현황 통계 API**를 구축하는 과제입니다. 
품질 솔루션 확산 전략 수립을 위해 사용자 로그 데이터를 분석하고, 이를 기반으로 월별/일자별/부서별 접속 현황 등의 통계 데이터를 제공하는 RESTful API 서버를 개발했습니다.

현업 멘토님의 가이드에 따라 **Spring Legacy(MVC)** 환경에서 시작하여 **Spring Boot**로 마이그레이션하는 과정을 직접 경험하며 프레임워크의 발전 흐름과 차이점을 체득하였고, 실제 협업을 가정한 API 문서 작성 및 유지보수성을 고려한 코드 구현에 집중했습니다.

## 2. 사용 기술 스택 (Tech Stack)

### 🛠 Backend
* **Java:** JDK 17
* **Framework:** Spring Boot 3.5.10
    * (Week 1: Spring MVC 5.2.3 기반 Legacy 환경 실습 포함)
* **Database:** MariaDB 10.6.24
* **Persistence:** MyBatis Spring Boot Starter 3.0.3
    * **JDBC Driver:** MariaDB Java Client 2.3.0
* **Build Tool:** Maven

### 📚 Collaboration & Tools
* **IDE:** IntelliJ IDEA
* **VCS:** Git / GitHub

## 3. 주차별 진행 내용

### 🗓️ 1주차: 개발 환경 구축 및 Spring Legacy 이해
> **목표:** Spring Framework의 핵심 동작 원리 이해 및 Legacy 환경 셋팅

* **Spring MVC 프로젝트 환경 구성**
    * `web.xml`, `root-context.xml`, `servlet-context.xml` 등 XML 기반 설정 실습
    * Maven 의존성 관리 및 Tomcat 서버 연동
* **기본 아키텍처 구현**
    * Controller - Service - DAO - Mapper 구조 설계
    * 서버 Health Check용 `/ping` API 및 DB 연동 테스트용 `/requests` API 구현

### 🗓️ 2주차: HTTP 통신 원리 학습 및 API 설계
> **목표:** RESTful API 설계 원칙 학습 및 인터페이스 가이드 문서 작성

* **선행 학습**
    * HTTP 프로토콜(Stateless, Connectionless) 및 Method(GET, POST 등) 특징 학습
    * RESTful 자원(URI)과 행위(Method) 설계 원칙 이해
* **인터페이스 가이드 문서 작성**
    * 클라이언트 개발자와의 협업을 위한 **API 명세서(Interface Guide)** 작성
    * 통계 데이터(월별/일자별/부서별 등)에 대한 Request/Response JSON 규격 정의

### 🗓️ 3주차: Spring Boot 전환 및 핵심 비즈니스 로직 구현
> **목표:** Spring Boot 환경으로 이관 및 통계 데이터 추출을 위한 SQL 작성

* **Spring Boot 마이그레이션**
    * 복잡한 XML 설정을 `application.properties` 및 Java Config로 간소화
    * 내장 Tomcat을 활용한 배포 및 실행 환경 최적화
* **통계 쿼리 및 기본 API 구현**
    * `GROUP BY`, `SUBSTRING` 등을 활용한 월별/일자별 집계 SQL 작성
    * 연도별 전체 로그인 수 조회 API (`/api/v1/logins/{year}`) 개발

### 🗓️ 4주차: API 고도화 및 안정성 확보
> **목표:** 전체 API 구현 완료 및 예외 처리(Exception Handling) 적용

* **통계 API 5종 기능 구현 완료**
    1.  **월별 접속자 수 조회:** `/api/v1/logins/months/{year}`
    2.  **일자별 접속자 수 조회:** `/api/v1/logins/days/{year}/{month}`
    3.  **하루 평균 로그인 수 조회:** `/api/v1/logins/average/{year}`
    4.  **휴일 제외 로그인 수 조회:** `/api/v1/logins/excluding-holiday/{year}`
    5.  **부서별 월별 로그인 수 조회:** `/api/v1/logins/departments/{year}`
* **기능 고도화**
    * **동적 쿼리(Dynamic SQL):** MyBatis `<foreach>`를 활용하여 Java 단에서 관리하는 휴일 리스트를 쿼리에 동적으로 반영
    * **유효성 검증(Validation):** 연도(2자리), 월(1~12) 등 입력값 검증 로직 추가 및 정규식 적용
    * **예외 처리(Global Exception Handling):** `@RestControllerAdvice`를 적용하여 에러 발생 시 표준화된 JSON 응답 반환

## 4. API 명세 (API Specifications)

| 기능명 | HTTP Method | Endpoint URI | 설명 |
| :--- | :---: | :--- | :--- |
| **연도별 전체 로그인 수** | `GET` | `/api/v1/logins/{year}` | 특정 연도의 총 로그인 횟수 반환 |
| **월별 접속자 수** | `GET` | `/api/v1/logins/months/{year}` | 1월~12월 월별 로그인 추이 조회 |
| **일자별 접속자 수** | `GET` | `/api/v1/logins/days/{year}/{month}` | 특정 월의 일자별 로그인 현황 조회 |
| **하루 평균 로그인 수** | `GET` | `/api/v1/logins/average/{year}` | 해당 연도의 일 평균 접속 횟수 계산 |
| **휴일 제외 로그인 수** | `GET` | `/api/v1/logins/excluding-holiday/{year}` | 주말 및 공휴일을 제외한 평일(Workday) 접속 수 |
| **부서별 월별 로그인 수** | `GET` | `/api/v1/logins/departments/{year}` | 조직(부서)별 월별 로그인 통계 조회 |

## 5. 성과 및 배운 점 (Key Takeaways)
* **Legacy vs Boot 비교:** 두 환경을 모두 경험해보며, Spring Boot의 Auto Configuration과 내장 서버가 주는 생산성의 차이를 명확히 이해했습니다.
* **RESTful 설계 역량:** 단순한 URL 매핑을 넘어, 자원 중심의 URI 설계와 적절한 HTTP Status Code 활용의 중요성을 체득했습니다.
* **실무형 문서화:** 협업 관점에서 API 가이드 문서를 작성해봄으로써 프론트엔드 개발자와의 소통 방식을 익혔습니다.
* **유지보수성:** 하드코딩된 SQL 대신 MyBatis의 동적 쿼리 기능을 활용하여 유연한 로직 처리를 구현했습니다.
