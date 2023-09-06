package com.example.kopoapi.apiPackage.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;


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

    public String getCreate_dttm() {
		return create_dttm;
	}

	public void setCreate_dttm(String create_dttm) {
		this.create_dttm = create_dttm;
	}

	public String getGet_time() {
		return get_time;
	}

	public void setGet_time(String get_time) {
		this.get_time = get_time;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDevice_desc() {
		return device_desc;
	}

	public void setDevice_desc(String device_desc) {
		this.device_desc = device_desc;
	}

	public String getMemb_id() {
		return memb_id;
	}

	public void setMemb_id(String memb_id) {
		this.memb_id = memb_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Long total_count) {
		this.total_count = total_count;
	}

	public Long getHr() {
		return hr;
	}

	public void setHr(Long hr) {
		this.hr = hr;
	}

	public Long getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(Long diastolic) {
		this.diastolic = diastolic;
	}

	public Long getSystolic() {
		return systolic;
	}

	public void setSystolic(Long systolic) {
		this.systolic = systolic;
	}

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
