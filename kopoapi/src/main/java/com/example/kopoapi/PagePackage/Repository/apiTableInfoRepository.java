package com.example.kopoapi.PagePackage.Repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.kopoapi.PagePackage.Domain.apiTableInfo;

@Repository
public class apiTableInfoRepository {
    
    @Autowired
    private SqlSession sql;

    private static String namespace = "com.example.mappers.apitableMapper";

    public List<apiTableInfo> getPageList(HashMap<String, Object> maps) throws Exception{
        // int totalCount = (Integer) sql.selectOne(namespace+".tablecount");
        // HashMap<String, Integer> maps = new HashMap<String,Integer>();
        // maps.put("pageNumber", pageNumber);
        // maps.put("limitedNumber", limitedNumber);
        // //총 페이지 개수
        // int csnum = totalCount/20;
        // //페이징 계산
        // int limitedNumber = totalCount - (20 * (numbers-1));
        // int pageNumber = totalCount - (20 * (numbers));
        // maps.put("pageNumber", pageNumber);
        // maps.put("limitedNumber", limitedNumber);
        return sql.selectList(namespace+".getpage", maps);
    }

    public apiTableInfo getDetailTable(int idx) throws Exception{
        return (apiTableInfo) sql.selectOne(namespace+".getdetail",idx);
    }

    public String getTableName(String uuid) throws Exception{
        return (String) sql.selectOne(namespace+".gettablename",uuid);
    }

    public int totalCount(){
        return (Integer) sql.selectOne(namespace+".tablecount");
    }
}
