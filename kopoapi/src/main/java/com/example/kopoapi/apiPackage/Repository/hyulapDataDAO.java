package com.example.kopoapi.apiPackage.Repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.kopoapi.apiPackage.Domain.hyulapData;

@Repository
public class hyulapDataDAO {
    
    @Autowired
    private SqlSession sql;

    private static String namespace = "com.example.mappers.kopoapiMapper";

    public List<hyulapData> getTest() throws Exception{
        HashMap<String, Object> inputMap = new HashMap<String,Object>();
        inputMap.put("startNumber", 0);
        inputMap.put("limitedNumber", 100);
        return sql.selectList(namespace+".testapi", inputMap);
    }

    public List<hyulapData> getApiList(
        String searchTime, String searchDevice, String searchName,
        String searchCreate, String startNumber
    ) throws Exception{
        HashMap<String, Object> inputData = new HashMap<String,Object>();
        inputData.put("limitedNumber", 100);
        inputData.put("searchTime", searchTime);
        inputData.put("searchDevice", searchDevice);
        inputData.put("searchName", searchName);
        inputData.put("searchCreate", searchCreate);
        int numbers = Integer.parseInt(startNumber) * 100;
        inputData.put("startNumber", numbers);
        return sql.selectList(namespace+".getapidata", inputData);
    }

    public List<hyulapData> getApibytable(
        String searchTime, String searchDevice, String searchName,
        String searchCreate, String startNumber, String tableName
    ) throws Exception{
        HashMap<String, Object> inputData = new HashMap<String,Object>();
        inputData.put("limitedNumber", 100);
        inputData.put("searchTime", searchTime);
        inputData.put("searchDevice", searchDevice);
        inputData.put("searchName", searchName);
        inputData.put("searchCreate", searchCreate);
        int numbers = Integer.parseInt(startNumber) * 100;
        inputData.put("startNumber", numbers);
        inputData.put("tableName", tableName);
        return sql.selectList(namespace+".getapidata", inputData);
    }
}
