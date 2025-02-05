package sdu.project.restapiservice.dto.mapping;

import org.mapstruct.Mapper;
import sdu.project.restapiservice.dto.SensorSaveDto;
import sdu.project.restapiservice.models.Sensor;

@Mapper
public interface UserMapping {
    Sensor toEntity(SensorSaveDto dto);
}
