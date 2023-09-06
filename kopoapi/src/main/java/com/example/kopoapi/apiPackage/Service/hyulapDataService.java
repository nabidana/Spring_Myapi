package com.example.kopoapi.apiPackage.Service;

import java.util.HashMap;
import java.util.List;

import com.example.kopoapi.apiPackage.Domain.hyulapData;

public interface hyulapDataService {
    public List<hyulapData> testgets() throws Exception;

    public List<HashMap<String,Object>> getapiData(
        String searchTime, String searchDevice, String searchName,
        String searchCreate, String startNumber
    ) throws Exception;

    public List<HashMap<String,Object>> getapibyuuid(
        String searchTime, String searchDevice, String searchName,
        String searchCreate, String startNumber, String tableName
    ) throws Exception;
}
