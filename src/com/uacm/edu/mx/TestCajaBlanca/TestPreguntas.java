package com.uacm.edu.mx.TestCajaBlanca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.beans.Preguntas;

class TestPreguntas {

	//CP8
	@Test
	void test() {
		
		Preguntas pregunta = new Preguntas(1, "5", "Es una IP", "192.168.1.10", "255.255.255.0", "ad:05:55:ar");
		
		assertTrue(pregunta.getAlta());
	}

}
