package com.sample.restapidemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Addition {

	private int num1;
	private int num2;

	public int Total() {
		return num1 + num2;
	}
}
