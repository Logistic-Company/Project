package com.example.project.web.api;

import com.example.project.data.entity.Shipment;
import com.example.project.services.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ShipmentApiController {

    private final ShipmentService shipmentService;

    /*public ShipmentApiController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }*/

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/shipment")
    public List<Shipment> getShipments() {
        return shipmentService.getShipments();
    }

    @RequestMapping("/api/shipment/{id}")
    public Shipment getShipment(@PathVariable("id") int id) {
        return shipmentService.getShipment(id);
    }

    @PostMapping(value = "/api/shipment")
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.create(shipment);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/shipment/{id}")
    public Shipment updateShipment(@PathVariable("id") long id, @RequestBody Shipment shipment) {
        return shipmentService.updateShipment(id, shipment);
    }

    @DeleteMapping(value = "/api/shipment/{id}")
    public void deleteShipment(@PathVariable long id) {
        shipmentService.deleteShipment(id);
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
}
