package com.teletrac.navman.teletrac.navman.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teletrac.navman.teletrac.navman.model.Payload;
import com.teletrac.navman.teletrac.navman.repository.TeletracRepository;
import com.teletrac.navman.teletrac.navman.service.TeletracService;

@Service
public class TeletricServiceImpl  implements TeletracService{
	
	@Autowired
	private TeletracRepository teletracRepository;

	@Override
	public void saveData(Payload data) throws Exception {
		teletracRepository.save(data);
		
	}

}
