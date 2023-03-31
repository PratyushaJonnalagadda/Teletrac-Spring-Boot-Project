package com.teletrac.navman.teletrac.navman.service;

import org.springframework.stereotype.Service;

import com.teletrac.navman.teletrac.navman.model.Payload;


public interface TeletracService {

	public void saveData(Payload data)throws Exception;
}
