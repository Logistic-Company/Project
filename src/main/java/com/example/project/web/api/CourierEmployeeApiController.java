package com.example.project.web.api;

import com.example.project.data.entity.CourierEmployee;
import com.example.project.services.CourierEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourierEmployeeApiController {

    private final CourierEmployeeService courierEmployeeService;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/courier_employee")
    public List<CourierEmployee> getCourierEmployees() {
        return courierEmployeeService.getCourierEmployees();
    }

    @RequestMapping("/api/courier_employee/{id}")
    public CourierEmployee getCourierEmployee(@PathVariable("id") int id) {
        return courierEmployeeService.getCourierEmployee(id);
    }

    @PostMapping(value = "/api/courier_employee")
    public CourierEmployee createCourierEmployee(@RequestBody CourierEmployee courierEmployee) {
        return courierEmployeeService.create(courierEmployee);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/courier_employee/{id}")
    public CourierEmployee updateCourierEmployee(@PathVariable("id") long id, @RequestBody CourierEmployee courierEmployee) {
        return courierEmployeeService.updateCourierEmployee(id, courierEmployee);
    }

    @DeleteMapping(value = "/api/courier_employee/{id}")
    public void deleteCourierEmployee(@PathVariable long id) {
        courierEmployeeService.deleteCourierEmployee(id);
    }

//    @RequestMapping("/api/courier_employee/names/{name}")
//    public List<CourierEmployee> findAllByName(@PathVariable String name) {
//        return courierEmployeeService.findAllByName(name);
//    }

}
