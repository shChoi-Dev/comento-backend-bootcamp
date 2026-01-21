package com.demo.devfun.controller;

import com.demo.devfun.dao.HomeDao;
import com.demo.devfun.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


// 메인 화면 및 요청 정보 조회를 담당하는 컨트롤러
@Controller
public class HomeController {

    @Autowired
    HomeService homeService; // 비즈니스 로직 처리를 위한 서비스 주입

    /**
     * 요청 정보 조회 API
     * URL: /requests
     * @return 전체 카운트와 DB에 저장된 요청 목록(sample)을 JSON으로 반환
     */
    @RequestMapping(value="/requests", produces = "application/json")
    @ResponseBody
    public Map<String, Object> getRequestInfo(){
        // 서비스 계층에 데이터 조회를 위임하여 결과 반환
        return homeService.getRequestInfo();
    }
}
