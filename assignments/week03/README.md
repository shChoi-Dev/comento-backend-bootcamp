# 3주차 과제 진행 현황

## 1. 개발 환경 구축 및 분석
* **Spring Boot 기반 프로젝트 신규 구성**
    * Spring Initializr를 활용하여 Spring Boot 3.5.10 및 Java 17 환경의 프로젝트 생성
    * `pom.xml` 설정을 통해 Spring Web, MyBatis Starter, MariaDB Client, Lombok 등 필수 의존성 추가
    * `application.properties`를 활용하여 서버 포트(8031) 및 DB 연결 정보 등 주요 환경 설정 최적화
* **레거시 Spring 대비 차이점 분석**
    * 1주차 Spring MVC 환경과 비교하여 web.xml 등 XML 기반 설정이 생략된 간소화 과정 확인

## 2. 주요 과제 수행
* **[이슈.01] MariaDB 및 MyBatis 연동**
    * MariaDB 연동을 위한 데이터 소스 및 MyBatis 매퍼 경로를 설정 (완료)
    * 통계 분석을 위한 사용자 정보, 요청 코드, 요청 정보 등 샘플 데이터 DB 테이블 적재 (완료)
* **[이슈.02] 연도별 총 로그인 수 조회 API 구현**
    * `/api/v1/logins/{year}` 경로를 통해 연도별 접속자 리스트 및 총 로그인 수 반환 기능 개발 (완료)
    * Controller, Service, DTO, Mapper 계층 간 연동을 통한 JSON 포맷 데이터 응답 처리 (완료)
* **[이슈.03] 현황 통계 API 구축을 위한 SQL 작성**
    * 통계 API 구현에 필요한 월별/일자별 접속자 수 조회 쿼리 설계 (완료)
    * 하루 평균 로그인 수 및 휴일을 포함한 로그인 수 조회 쿼리 설계 (완료)
    * 부서별 월별 로그인 수 조회 쿼리 설계 (완료)

## 3. 기타
* **프로젝트 문서화 및 형상 관리**
    * 3주차 과제 파일 업로드 및 소스 코드 GitHub 저장소 업로드
    * README.md 주간 업무 보고 현행화
