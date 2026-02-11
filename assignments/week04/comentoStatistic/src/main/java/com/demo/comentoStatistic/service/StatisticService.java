package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }

    public List<Map<String, Object>> getMonthlyLogins(String year) {
        return statisticMapper.selectMonthlyLogin(year);
    }

    public List<Map<String, Object>> getDailyLogins(String year, String month) {
        return statisticMapper.selectDailyLogin(year + month);
    }

    public Double getAverageDailyLogins(String year) {
        return statisticMapper.selectAverageDailyLogin(year);
    }

    public Integer getLoginCountExcludingHoliday(String year) {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);


        List<String> holidayList = new ArrayList<>();
        holidayList.add("0101"); // 신정
        holidayList.add("0301"); // 삼일절
        holidayList.add("0505"); // 어린이날
        holidayList.add("0606"); // 현충일
        holidayList.add("0815"); // 광복절
        holidayList.add("1003"); // 개천절
        holidayList.add("1009"); // 한글날
        holidayList.add("1225"); // 성탄절

        params.put("holidayList", holidayList);

        return statisticMapper.selectLoginCountExcludingHoliday(params);
    }

    public List<Map<String, Object>> getDeptMonthlyLogins(String year) {
        return statisticMapper.selectDeptMonthlyLogin(year);
    }
}