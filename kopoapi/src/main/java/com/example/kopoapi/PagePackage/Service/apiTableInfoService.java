package com.example.kopoapi.PagePackage.Service;

import java.util.List;

import com.example.kopoapi.PagePackage.Domain.apiTableInfo;

public interface apiTableInfoService {
    
    public List<apiTableInfo> getPageList(int numbers) throws Exception;

    public apiTableInfo getDetailTable(int idx) throws Exception;

    public String getTableName(String uuid) throws Exception;
    
    public int totalCount() throws Exception;
}
