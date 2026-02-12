# 4주차 과제 진행 현황

## 1. SW 활용 현황 통계 API 개발 및 고도화

* **[이슈.01] 핵심 통계 API 5종 구현**
  * **API 개발 완료**
    * 월별 접속자 수 조회: `/api/v1/logins/months/{year}` (완료)
    * 일자별 접속자 수 조회: `/api/v1/logins/days/{year}/{month}` (완료)
    * 하루 평균 로그인 수 조회: `/api/v1/logins/average/{year}` (완료)
    * 휴일 제외 로그인 수 조회: `/api/v1/logins/excluding-holiday/{year}` (완료)
    * 부서별 월별 로그인 수 조회: `/api/v1/logins/departments/{year}` (완료)
  * **URL 설계 개선**
    * RESTful 원칙에 따라 리소스명을 명사형(복수형)으로 수정하여 API 직관성 향상 (예: `monthly` → `months`)
* **[이슈.02] Java-SQL 복합 로직 구현**
  * **동적 쿼리 처리**
    * MyBatis `<foreach>` 구문을 활용하여 Java Service 단에서 관리하는 휴일 리스트를 쿼리에 동적으로 반영 (완료)
  * **휴일 제외 로직**
    * 단순 SQL 처리가 아닌 애플리케이션 레벨에서 유연하게 제어 가능한 필터링 로직 구축 (완료)

## 2. API 안정성 확보 및 예외 처리

* **[이슈.03] 유효성 검증(Validation) 적용**
  * **입력값 검증**
    * 연도(2자리 숫자) 및 월(01~12) 파라미터에 대한 정규식 기반 검증 로직 추가 (완료)
  * **Global Exception Handling**
    * `@RestControllerAdvice`와 커스텀 예외(`InvalidInputException`)를 활용하여 전역 예외 처리 구현 (완료)
  * **에러 응답 표준화**
    * 잘못된 요청 시 `400 Bad Request` 상태 코드와 명확한 에러 메시지(JSON) 반환하도록 개선 (완료)

## 3. 문서화
* **API 가이드 문서 보완**
  * 구현된 5가지 API의 상세 명세(URL, 파라미터, 응답 예시 등) 최신화 (완료)
  * 에러 코드 및 응답 규격 추가 (완료)
 
## 4. 기타
* **프로젝트 문서화 및 형상 관리**
  * 4주차 과제 파일 업로드 및 소스 코드 GitHub 저장소 업로드
  * README.md 주간 업무 보고 현행화
