package com.example.kopoapi.PagePackage.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kopoapi.PagePackage.Domain.apiTableInfo;
import com.example.kopoapi.PagePackage.Repository.apiTableInfoRepository;

@Service
public class apiTableInfoServiceImpl implements apiTableInfoService{

    @Autowired
    private apiTableInfoRepository repository;

    @Override
    public List<apiTableInfo> getPageList(int numbers) throws Exception {
        int totalCount = repository.totalCount();
        System.out.println(totalCount);
        HashMap<String, Object> maps = new HashMap<String,Object>();
        //페이징 계산
        int limitedNumber = totalCount - (20 * (numbers-1));
        int pageNumber = totalCount - (20 * (numbers));
        if(pageNumber < 0){
            pageNumber = 0;
        }
        if( limitedNumber < 20){
            limitedNumber = 20;
        }
        //System.out.println(pageNumber);
        //System.out.println(limitedNumber);
        maps.put("pageNumber", pageNumber);
        maps.put("limitedNumber", limitedNumber);
        return repository.getPageList(maps);
    }

    @Override
    public apiTableInfo getDetailTable(int idx) throws Exception {
        return repository.getDetailTable(idx);
    }

    @Override
    public String getTableName(String uuid) throws Exception {
        return repository.getTableName(uuid);
    }

    @Override
    public int totalCount() throws Exception {
        return repository.totalCount();
    }
    
}
