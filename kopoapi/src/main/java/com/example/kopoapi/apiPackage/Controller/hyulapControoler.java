package com.example.kopoapi.apiPackage.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kopoapi.PagePackage.Service.apiTableInfoService;
import com.example.kopoapi.apiPackage.Domain.hyulapData;
import com.example.kopoapi.apiPackage.Service.hyulapDataService;

@Controller
public class hyulapControoler {

    @Autowired
    private hyulapDataService hService;
    @Autowired
    private apiTableInfoService apiservice;

    @ResponseBody
    @RequestMapping(value = "/tat")
    public ResponseEntity<?> asdf() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        return new ResponseEntity<String>("TEST\nTEST\nAAA", headers, HttpStatus.OK);
    }
    
    // @ResponseBody
    // @RequestMapping(value = "/")
    // public ResponseEntity<?> testData() throws Exception{
    //     List<hyulapData> hList = hService.testgets();
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.add("Content-Type", "application/json; charset=UTF-8");
    //     System.out.println(hList.size());
    //     return new ResponseEntity<String>(hList.toString(), headers, HttpStatus.OK);
    // }

    // @ResponseBody
    // @RequestMapping(value = "test")
    // public ResponseEntity<String> testa() throws Exception{
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.add("Content-Type", "application/json; charset=UTF-8");
    //     HashMap<String, Object> maps = new HashMap<String,Object>();
    //     maps.put("A", "WEGSDASF");
    //     maps.put("DAFADf", "WEGSDASF");
    //     maps.put("GADGADF", "adfadf");
    //     maps.put("CVBZVZ", "erfaergaerg");
    //     maps.put("qqrda",134134);
    //     maps.put("asdfasd", "44das");
    //     return new ResponseEntity<String>(maps.toString(), headers, HttpStatus.CREATED);
    // }

    @ResponseBody
    @RequestMapping(value = "api/getdata")
    public ResponseEntity<?> sendapi(
        HttpServletRequest request
        // @RequestParam(value = "pageno", defaultValue = "")String startNumber,
        // @RequestParam(value = "time", defaultValue = "")String searchTime,
        // @RequestParam(value = "device", defaultValue = "")String searchDevice,
        // @RequestParam(value = "name", defaultValue = "")String searchName,
        // @RequestParam(value = "date", defaultValue = "")String searchCreate
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        String startNumber = request.getParameter("pageno");
        String searchTime = request.getParameter("time");
        String searchDevice = request.getParameter("device");
        String searchName = request.getParameter("name");
        String searchCreate = request.getParameter("date");
        if( "".equals(startNumber) || startNumber == null){
            return new ResponseEntity<String>("Error.\n Err Code : 2\n확인 후, 재요청 해주세요.",headers,HttpStatus.BAD_REQUEST);
        }
        if( "".equals(searchTime) || searchTime == null){
            searchTime = "";
        }
        if( "".equals(searchDevice) || searchDevice == null){
            searchDevice = "";
        }
        if( "".equals(searchName) || searchName == null){
            searchName = "";
        }
        if( "".equals(searchCreate) || searchCreate == null){
            searchCreate = "";
        }
        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String,Object>>();
        try {
            maps = hService.getapiData(searchTime, searchDevice, searchName, searchCreate, startNumber);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>("Error.\n Err Code : 1\n관리자에게 문의해주세요.",headers, HttpStatus.BAD_GATEWAY);
        }
        // if(resultList.isEmpty() || resultList == null){
        //     return new ResponseEntity<String>("Error.\n Err Code : 2\n확인 후, 재요청 해주세요.",headers,HttpStatus.BAD_REQUEST);
        // }

        return new ResponseEntity<String>(maps.toString(), headers, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "api/getdata/{uuid}")
    public ResponseEntity<?> parsingJson(
        HttpServletRequest request,
        @PathVariable("uuid")String uuid
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        String startNumber = request.getParameter("pageno");
        String searchTime = request.getParameter("time");
        String searchDevice = request.getParameter("device");
        String searchName = request.getParameter("name");
        String searchCreate = request.getParameter("date");
        if( "".equals(startNumber) || startNumber == null){
            return new ResponseEntity<String>("Error.\n Err Code : 2\n확인 후, 재요청 해주세요.",headers,HttpStatus.BAD_REQUEST);
        }
        if( "".equals(searchTime) || searchTime == null){
            searchTime = "";
        }
        if( "".equals(searchDevice) || searchDevice == null){
            searchDevice = "";
        }
        if( "".equals(searchName) || searchName == null){
            searchName = "";
        }
        if( "".equals(searchCreate) || searchCreate == null){
            searchCreate = "";
        }
        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String,Object>>();
        String tableName = "";
        try {
            tableName = apiservice.getTableName(uuid);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>("Error.\n Err Code : 1\n관리자에게 문의해주세요.",headers, HttpStatus.BAD_GATEWAY);
        }
        try {
            maps = hService.getapibyuuid(searchTime, searchDevice, searchName, searchCreate, startNumber, tableName);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>("Error.\n Err Code : 1\n관리자에게 문의해주세요.",headers, HttpStatus.BAD_GATEWAY);
        }
        // if(resultList.isEmpty() || resultList == null){
        //     return new ResponseEntity<String>("Error.\n Err Code : 2\n확인 후, 재요청 해주세요.",headers,HttpStatus.BAD_REQUEST);
        // }

        return new ResponseEntity<String>(maps.toString(), headers, HttpStatus.OK);
    }

}
