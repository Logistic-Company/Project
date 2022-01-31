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

    @RequestMapping(method = RequestMethod.PUT, value = "/api/office_employee/{id}")
    public OfficeEmployee updateOfficeEmployee(@PathVariable("id") long id, @RequestBody OfficeEmployee officeEmployee) {
        return officeEmployeeService.updateOfficeEmployee(id, officeEmployee);
    }

    @DeleteMapping(value = "/api/office_employee/{id}")
    public void deleteOfficeEmployee(@PathVariable long id) {
        officeEmployeeService.deleteOfficeEmployee(id);
    }

}
