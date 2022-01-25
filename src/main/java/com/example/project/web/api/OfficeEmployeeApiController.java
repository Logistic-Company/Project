package com.example.project.web.api;

import com.example.project.data.entity.OfficeEmployee;
import com.example.project.services.OfficeEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OfficeEmployeeApiController {

    private final OfficeEmployeeService officeEmployeeService;

    /*public OfficeEmployeeApiController(OfficeEmployeeService officeEmployeeService) {
        this.officeEmployeeService = officeEmployeeService;
    }*/

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/office_employee")
    public List<OfficeEmployee> getOfficeEmployees() {
        return officeEmployeeService.getOfficeEmployees();
    }

    @RequestMapping("/api/office_employee/{id}")
    public OfficeEmployee getOfficeEmployee(@PathVariable("id") int id) {
        return officeEmployeeService.getOfficeEmployee(id);
    }

    @PostMapping(value = "/api/office_employee")
    public OfficeEmployee createOfficeEmployee(@RequestBody OfficeEmployee officeEmployee) {
        return officeEmployeeService.create(officeEmployee);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/office_employee/{id}")
    public OfficeEmployee updateOfficeEmployee(@PathVariable("id") long id, @RequestBody OfficeEmployee officeEmployee) {
        return officeEmployeeService.updateOfficeEmployee(id, officeEmployee);
    }

    @DeleteMapping(value = "/api/office_employee/{id}")
    public void deleteOfficeEmployee(@PathVariable long id) {
        officeEmployeeService.deleteOfficeEmployee(id);
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
