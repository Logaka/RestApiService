package sdu.project.restapiservice.dto.mapping;

import org.mapstruct.Mapper;
import sdu.project.restapiservice.dto.MeasurementDto;
import sdu.project.restapiservice.dto.MeasurementSaveDto;
import sdu.project.restapiservice.models.Measurement;

@Mapper
public interface MeasurementsMapping {
    Measurement toEntity(MeasurementSaveDto dto);
    MeasurementDto toDto(Measurement measurement);
}
