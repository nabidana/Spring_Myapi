package com.example.kopoapi.apiPackage.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kopoapi.apiPackage.Domain.hyulapData;
import com.example.kopoapi.apiPackage.Repository.hyulapDataDAO;

@Service
public class hyulapDataSerivceImpl implements hyulapDataService{

    @Autowired
    private hyulapDataDAO hDao;

    @Override
    public List<hyulapData> testgets() throws Exception{
        return hDao.getTest();
    }

    @Override
    public List<HashMap<String, Object>> getapiData(
        String searchTime, String searchDevice, String searchName,
        String searchCreate, String startNumber
    ) throws Exception {
        List<hyulapData> hdList = hDao.getApiList(searchTime, searchDevice, searchName, searchCreate, startNumber);
        List<HashMap<String,Object>> hList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0 ; i < hdList.size(); i++){
            hList.add(hdList.get(i).getMaps());
        }
        return hList;
    }

    @Override
    public List<HashMap<String, Object>> getapibyuuid(String searchTime, String searchDevice, String searchName,
            String searchCreate, String startNumber, String tableName) throws Exception {
        List<hyulapData> hdList = hDao.getApibytable(searchTime, searchDevice, searchName, searchCreate, startNumber, tableName);
        List<HashMap<String,Object>> hList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0 ; i < hdList.size(); i++){
            hList.add(hdList.get(i).getMaps());
        }
        return hList;
    }
    
}
