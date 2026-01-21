package com.demo.devfun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * DB 접근을 담당하는 DAO 구현 클래스
 * MyBatis SqlSessionTemplate을 사용하여 매퍼(XML)에 정의된 쿼리를 실행
 */
@Repository
public class HomeDaoImpl implements HomeDao{


    @Autowired
    SqlSessionTemplate template; // 쿼리 실행을 도와주는 MyBatis 템플릿 객체

    // 생성자를 통한 의존성 주입
    public HomeDaoImpl(SqlSessionTemplate template){
        super();
        this.template = template;
    }

    /**
     * 연결 테스트용 쿼리 실행
     * Mapper ID: com.test.springTest.testxml.selectTest
     */
    @Override
    public int getTestCount() {
        return template.selectOne("com.test.springTest.testxml.selectTest");
    }

    /**
     * request_info 테이블 목록 조회
     * Mapper ID: com.test.springTest.testxml.selectTest2
     */
    @Override
    public List<Map<String, Object>> getRequests() {
        return template.selectList("com.test.springTest.testxml.selectTest2");
    }
}
