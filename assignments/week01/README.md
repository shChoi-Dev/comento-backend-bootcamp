1. 개발환경 셋팅
    ○ Spring MVC 프로젝트 기반 환경 구성
      - Maven 빌드 설정 및 `pom.xml` 의존성(Spring, MyBatis, MariaDB 등) 추가 (완료)
      - `web.xml` DispatcherServlet 및 인코딩 필터 설정 (완료)
    
    ○ 스프링 컨텍스트 및 DB 연동 설정
       - `applicationContext-webapp.xml` 컴포넌트 스캔 및 View Resolver 설정 (완료)
       - `applicationContext-datasource.xml` MariaDB DataSource 및 MyBatis SqlSessionFactory 설정 (완료)

2. 주요 기능 개발
    ○ [이슈.01] 비즈니스 로직 및 DB 액세스 계층 구현
       - MyBatis Mapper XML (`mapper.test.xml`) 쿼리 작성 및 DAO/Service 연동 (완료)
       - 데이터 조회용 `HomeDao`, `HomeService` 구현 (완료)
    
    ○ [이슈.02] API 컨트롤러 개발
       - 서버 헬스 체크용 `/ping` API 구현 및 JSON 응답 처리 (완료)
       - DB 데이터 조회 및 반환을 위한 `/requests` API 구현 (완료)

3. 기타
    ○ 프로젝트 문서화 및 형상 관리
       - Github 저장소 업로드 및 Readme.md 작성 (진행)