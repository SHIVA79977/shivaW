package com.slokam.da.hc.MapperDTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.slokam.da.hc.DTO.DoctorDTO;
import com.slokam.da.hc.entity.Doctor;

@Mapper

public interface DoctorMapper {
    
@Mappings({@Mapping(source  ="id",target="did"),
	      @Mapping(source  ="name",target="dname"),
	      @Mapping(source  ="speci",target="dspeci")})
          
     public abstract List<DoctorDTO> getDoctorNamesByPatientName(List<Doctor> list);
@Mappings({@Mapping(source  ="id",target="did"),
    @Mapping(source  ="name",target="dname"),
    @Mapping(source  ="speci",target="dspeci")})

public abstract DoctorDTO getDoctorNameByPatientName(Doctor doctor);

}
