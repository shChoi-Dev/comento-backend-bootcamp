# 2주차 과제 진행 현황

## 1. 선행 학습
* **HTTP 통신 및 REST API 이해**
  - HTTP 프로토콜의 특징(비연결성, 무상태) 및 요청/응답(Request/Response) 구조 학습 (완료)
  - RESTful API 설계 원칙(자원-URI, 행위-Method, 표현-JSON) 이해 (완료)
  - Path Variable과 Query Parameter의 차이점 및 활용 사례 분석 (완료)

## 2. 주요 과제 수행
* **[이슈.01] 인터페이스 가이드 문서 작성 (SW 활용 현황 통계 API)**
  - **API 명세 설계 및 규격 정의**
    - RESTful URL 구조 설계 (`/api/login/...`) 및 HTTP Method(GET) 정의 (완료)
    - 공통 응답 포맷(JSON) 및 에러 코드(400, 401, 403 등) 표준화 (완료)
  - **세부 통계 API 5종 설계**
    - 월별/일자별 접속자 수 조회 (기간 검색 파라미터 `startDate`, `endDate` 적용) (완료)
    - 평균 하루 로그인 수 및 휴일 제외 로그인 수 조회 (완료)
    - 부서별 월별 로그인 수 조회 (페이징 `page`, `size` 및 정렬 `sort` 기능 명세) (완료)

## 3. 기타
* **문서화 및 형상 관리**
  - 선행 학습 내용(`HTTP 통신 원리와 REST API 학습 정리.docx`) 및 과제 결과물(`SW활용현황 API가이드문서.docx`) 작성 (완료)
  - 2주차 과제 파일 Git Repository 업로드 및 커밋 (완료)
  - README.md 주간 업무 보고 현행화 (진행)
