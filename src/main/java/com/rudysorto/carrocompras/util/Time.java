package com.rudysorto.carrocompras.util;

import java.sql.Timestamp;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: class created to obtain a timestamp that is added to the data of the exceptions
*/
public class Time {
	public static Timestamp getTime() {
		return new Timestamp(System.currentTimeMillis());
	}
}
