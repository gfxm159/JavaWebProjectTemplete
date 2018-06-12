package com.self.cms.controller;

import com.self.common.persistence.mapper.TestTableMapper;
import com.self.common.persistence.model.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private TestTableMapper testTableMapper;
    @GetMapping("test")
    public String test(){
            TestTable testTable = testTableMapper.selectByPrimaryKey(1);
            if(testTable!=null){
                return testTable.getName();
            }else {
                return "null";
            }

    }
}
