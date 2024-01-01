package com.example.kopoapi.PagePackage.Domain;

import java.util.Date;

import lombok.Data;

@Data
public class apiTableInfo {
    
    private Long idx;
    private String title;
    private String content;
    private String uuid;
    private Date makedate;
    private String tablename;
}
