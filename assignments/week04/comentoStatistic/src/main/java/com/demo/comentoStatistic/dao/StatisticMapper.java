package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);

    List<Map<String, Object>> selectMonthlyLogin(String year);
    List<Map<String, Object>> selectDailyLogin(String yearMonth);
    Double selectAverageDailyLogin(String year);
    Integer selectLoginCountExcludingHoliday(Map<String, Object> params);
    List<Map<String, Object>> selectDeptMonthlyLogin(String year);

}
