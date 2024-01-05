package com.app.service;

import java.util.List;

import com.app.dto.AddAppoDTO;
import com.app.dto.RespAppoDTO;

public interface AppoService {

	List<RespAppoDTO> getAllAppoints();

	RespAppoDTO bookAppo(AddAppoDTO apodto);

}
