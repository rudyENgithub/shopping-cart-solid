package com.rudysorto.carrocompras.api.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class used to apply the DTO pattern to display data in our handler exceptions
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	//Atributes
	private Timestamp timestamp;
	private String data;
	private int respondeCode;
	private String status;
}