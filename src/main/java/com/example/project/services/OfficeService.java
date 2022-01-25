package com.example.project.services;

import com.example.project.data.entity.Office;
import java.util.List;

public interface OfficeService {

    List<Office> getOffices();

    Office getOffice(long id);

    Office create(Office office);

    Office updateOffice(long id, Office office);

    void deleteOffice(long id);
}
