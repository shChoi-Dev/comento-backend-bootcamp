package com.demo.devfun.service;

import com.demo.devfun.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 비즈니스 로직을 수행하는 서비스 클래스
 * 여러 DAO 메소드를 호출하여 결과 데이터를 가공
 */
@Service
public class HomeService {

    @Autowired
    HomeDao homeDao; // DB 접근을 위한 DAO 객체 주입

    /**
     * 화면에 보여줄 요청 정보를 종합하여 반환
     * 테스트 카운트 조회
     * 요청 리스트 조회
     */
    public Map<String,Object> getRequestInfo(){
        Map<String, Object> map = new HashMap<>();

        // DAO를 통해 DB에서 데이터 조회
        map.put("count", homeDao.getTestCount()); // 단순 숫자 조회 (SELECT 1)
        map.put("sample", homeDao.getRequests()); // 실제 테이블 데이터 조회
        return map;
    }
}
