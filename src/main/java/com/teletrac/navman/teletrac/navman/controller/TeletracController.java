package com.teletrac.navman.teletrac.navman.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teletrac.navman.teletrac.navman.model.Payload;
import com.teletrac.navman.teletrac.navman.service.TeletracService;

@RestController
public class TeletracController {

	private static Logger logger = LoggerFactory.getLogger(TeletracController.class);

	@Autowired
	private TeletracService teletracService;

	@PostMapping(value = "/{path}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> uploadData(HttpServletRequest request, @Validated @RequestBody Payload payload,
			@PathVariable String path) throws Exception {
		String url = request.getRequestURL().toString();
		Payload requestPayload = (Payload) payload.clone();
		teletracService.saveData(payload);
		if (url.endsWith("/nocontent")) {
			logger.info("/nocontent end point is triggered {}", requestPayload);
			return new ResponseEntity<>("file Uploaded Successfully", HttpStatus.NO_CONTENT);
		} else if (url.contains("/echo")) {
			logger.info("/echo end point is triggered {}", requestPayload);
			return new ResponseEntity<Payload>(requestPayload, HttpStatus.OK);
		} else if (url.contains("/device")) {
			logger.info("/device end point is triggered {}", requestPayload);
			return new ResponseEntity<String>("{\"DeviceId\":" + payload.getDeviceId() + "}", HttpStatus.OK);
		}
		logger.info("default end point is triggered {}", requestPayload);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
