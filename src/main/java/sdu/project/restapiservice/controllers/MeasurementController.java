package sdu.project.restapiservice.controllers;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdu.project.restapiservice.dto.MeasurementDto;
import sdu.project.restapiservice.dto.MeasurementSaveDto;

@Data
@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsController measurementsController;

    @PostMapping("/add")
    public ResponseEntity<MeasurementDto> save(@RequestBody @Validated MeasurementSaveDto dto){

    }
}
