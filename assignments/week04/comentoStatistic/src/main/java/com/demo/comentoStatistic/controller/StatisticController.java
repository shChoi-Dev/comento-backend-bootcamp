package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.exception.InvalidInputException;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    // 검증 로직을 위한 private 메서드 추가
    private void validateYear(String year) {
        if (!year.matches("\\d{2}")) { // 숫자 2자리인지 확인
            throw new InvalidInputException("년도는 2자리 숫자여야 합니다. (예: 23)");
        }
    }

    private void validateMonth(String month){
        try{
            int m = Integer.parseInt(month);
            if (m < 1 || m > 12) {
                throw new InvalidInputException("월은 01 ~ 12 사이여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("월은 숫자여야 합니다.");
        }
    }

    // 연도별 로그인 수 조회
    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){
        validateYear(year); // 검증 호출
        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    // 월별 로그인 수 조회 (sample)
    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){
        validateYear(year); // 검증 호출
        validateMonth(month); // 검증 호출
        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    // 월별 로그인 수 조회 (제작)
    @RequestMapping(value="/api/v1/logins/months/{year}", produces = "application/json")
    @ResponseBody
    public Object getMonthlyLoginCount(@PathVariable("year") String year){
        validateYear(year);
        return ResponseEntity.ok(statisticService.getMonthlyLogins(year));
    }

    // 일자별 로그인 수 조회
    @RequestMapping(value="/api/v1/logins/days/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getDailyLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){
        validateYear(year);
        validateMonth(month);
        return ResponseEntity.ok(statisticService.getDailyLogins(year,month));
    }

    // 평균 하루 로그인 수 조회
    @RequestMapping(value="/api/v1/logins/average/{year}", produces = "application/json")
    @ResponseBody
    public Object getAverageDailyLoginCount(@PathVariable("year") String year){
        validateYear(year);
        return ResponseEntity.ok(statisticService.getAverageDailyLogins(year));
    }

    // 휴일 제외 로그인 수 조회
    @RequestMapping(value="/api/v1/logins/excluding-holiday/{year}", produces = "application/json")
    @ResponseBody
    public Object getLoginCountExcludingHoliday(@PathVariable("year") String year){
        validateYear(year);
        return ResponseEntity.ok(statisticService.getLoginCountExcludingHoliday(year));
    }

    // 부서별 월별 로그인 수 조회
    @RequestMapping(value="/api/v1/logins/departments/{year}", produces = "application/json")
    @ResponseBody
    public Object getDeptMonthlyLoginCount(@PathVariable("year") String year){
        validateYear(year);
        return ResponseEntity.ok(statisticService.getDeptMonthlyLogins(year));
    }

}