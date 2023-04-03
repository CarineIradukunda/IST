package com.example.school.controller;

import com.example.school.model.Subject;
import com.example.school.service.GroupManagementOperator;
import org.springframework.web.bind.annotation.*;

/**
 * @author Carine Iradukunda
 */

@RestController
@CrossOrigin
@RequestMapping("group/system")
public class AppController {
    final GroupManagementOperator groupManagementOperator;


    public AppController(GroupManagementOperator groupManagementOperator) {
        this.groupManagementOperator = groupManagementOperator;
    }

    @GetMapping("/getGroup")
    public Object getAvailableGroup(@RequestBody Subject subject) {
        return groupManagementOperator.getAvailableGroup(subject.getName(),2,10);
    }
}
