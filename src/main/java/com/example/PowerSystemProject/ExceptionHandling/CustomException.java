package com.example.PowerSystemProject.ExceptionHandling;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Component
@AllArgsConstructor
public class CustomException extends RuntimeException {
	
    private static final long serialVersionUID=1L;
	private int errorCode;
	private String errorMessage;
	
	
		
}
