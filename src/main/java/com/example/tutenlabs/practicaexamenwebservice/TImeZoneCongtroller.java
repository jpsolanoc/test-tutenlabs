package com.example.tutenlabs.practicaexamenwebservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TImeZoneCongtroller {

	@GetMapping("/gethola")
	public String getHola() {
		return "<h1>Hola Mundo</h1>";
	}
	
	
	@PostMapping("/postZonaHoraria")
	public String getHola(@RequestBody DatosEntrada datosEntrada) {
		TimeZone timeZone = new TimeZone();
		return timeZone.dataRetorno(datosEntrada).toString();
	}

	
}
