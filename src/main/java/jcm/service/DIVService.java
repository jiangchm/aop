package jcm.service;

import jcm.annotation.LogAnnotation;

import org.springframework.stereotype.Service;

@Service
public class DIVService {

	@LogAnnotation
	public void div(Object obj){
		System.out.println(obj);
	}
}
