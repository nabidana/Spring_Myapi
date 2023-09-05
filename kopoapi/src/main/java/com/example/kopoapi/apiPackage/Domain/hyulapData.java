package com.example.kopoapi.apiPackage.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class hyulapData {
    
    private String create_dttm;
    private String get_time;
    private String fullname;
    private String device_desc;
    private String memb_id;
    private Long id;
    private Long total_count;
    private Long hr;
    private Long diastolic;
    private Long systolic;

    public HashMap<String, Object> getMaps(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("Index",total_count);
        map.put("ID",id);
        map.put("MemberID",memb_id);
        map.put("DEVICE",device_desc);
        map.put("NAME",fullname);
        map.put("TIME",get_time);
        map.put("SYSTOLIC",systolic);
        map.put("DIASTOLIC",diastolic);
        map.put("HR",hr);
        map.put("DATE",create_dttm);
        return map;
    }
}
