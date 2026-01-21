package com.demo.devfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 서버 연결 상태 확인(Health Check)용 컨트롤러
 * 간단한 Ping 테스트를 위해 사용
 */
@Controller
public class PingController {

    /**
     * 서버 헬스 체크 API
     * URL: /ping
     * @return 현재 월과 일 정보를 담은 JSON 객체
     */
    @RequestMapping(value="/ping", produces = "application/json")
    @ResponseBody
    public Object healthCheck(){
        Map<String, Object> map = new HashMap<>();
        // 현재 시간의 월과 일을 조합하여 "today" 키로 저장 (예: 1:21)
        map.put("today", ZonedDateTime.now().getMonth() + ":" + ZonedDateTime.now().getDayOfMonth());
        return map;
    }

}