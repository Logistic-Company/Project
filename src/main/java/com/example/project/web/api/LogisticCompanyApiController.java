package com.example.project.web.api;

import com.example.project.data.entity.LogisticsCompany;
import com.example.project.services.LogisticsCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.modelmapper.ModelMapper;

@RestController
//@RequestMapping("/api/logistics_company")
@AllArgsConstructor
public class LogisticCompanyApiController {

    private final LogisticsCompanyService logisticsCompanyService;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/logistics_company")
    public List<LogisticsCompany> getLogisticCompanies() {
        return logisticsCompanyService.getLogisticsCompanies();
    }

    @RequestMapping("/api/logistics_company/{id}")
    public LogisticsCompany getLogisticsCompany(@PathVariable("id") int id) {
       return logisticsCompanyService.getLogisticCompany(id);
    }

    @PostMapping(value = "/api/logistics_company")
    public LogisticsCompany createLogisticsCompany(@RequestBody LogisticsCompany logisticsCompany) {
       return logisticsCompanyService.create(logisticsCompany);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/logistics_company/{id}")
    public LogisticsCompany updateLogisticsCompany(@PathVariable("id") long id, @RequestBody LogisticsCompany logisticsCompany) {
        return logisticsCompanyService.updateLogisticCompany(id, logisticsCompany);
    }

    @DeleteMapping(value = "/api/logistics_company/{id}")
    public void deleteLogisticsCompany(@PathVariable long id) {
        logisticsCompanyService.deleteLogisticCompany(id);
    }

//    @RequestMapping("/api/schools/max-students/{maxStudents}")
//    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable int maxStudents) {
//        return schoolService.getSchoolsByMaxNumberOfStudents(maxStudents);
//    }
//    @RequestMapping("/api/schools/names/{name}")
//    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name) {
//        return schoolService.getSchoolsByName(name);
//    }
//
//    @RequestMapping("/api/schools/names/{name}/max-students/{maxStudents}")
//    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name, @PathVariable int maxStudents) {
//        return schoolService.getSchoolsByNameAndMaxNumberOfStudents(name, maxStudents);
//    }
//
//    @RequestMapping("/api/highschools")
//    public List<School> getHighSchools() {
//        return schoolService.getAllHighSchools();
//    }
//
//    @RequestMapping("/api/schools/{id}/teachers")
//    public List<Teacher> getSchoolTeachers(@PathVariable long id) {
//        return schoolService.getAllTeachersBySchoolId(id);
//    }
//


}
