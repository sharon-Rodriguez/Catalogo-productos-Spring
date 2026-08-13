package com.ProyectoPersonal.CatalogoProductos.service;

import com.ProyectoPersonal.CatalogoProductos.model.ApiDatos_traer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiDatos_Services {

    @Value("${clave.de.api}")
    private String CLAVE_API;
    private String URL = "https://v6.exchangerate-api.com/v6/";
    private RestTemplate restTemplate;

    @Autowired
    public ApiDatos_Services(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double convertidorMonedas (Double precio, String monedaDeCambio){
        String url = URL + CLAVE_API + "/latest/ COP"; // Pesos como moneda base
        ApiDatos_traer resultado = restTemplate.getForObject(url,ApiDatos_traer.class);
        Double tasa = resultado.getConversion_rates().get(monedaDeCambio);
        return precio * tasa;
    }
}
