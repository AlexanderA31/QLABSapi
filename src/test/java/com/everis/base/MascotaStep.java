package com.everis.base;

import com.everis.base.models.Mascota;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class MascotaStep {
    private String URL_BASE = "https://petstore.swagger.io/v2";
    private int respuestaCodigo;

    public void consultaMascota(String id) {
        Response response =
                given()
                        .baseUri(URL_BASE)
                        .log()
                        .all()
                        .when()
                        .get("pet/" + id);

        respuestaCodigo = response.getStatusCode();

        Mascota mascota = response.as(Mascota.class);

        System.out.println("OUT: " + mascota.getName());
        System.out.println("OUT: " + mascota.getCategory().getId());
        System.out.println("OUT: " + mascota.getStatus());
    }

    public void agregarMascota(Mascota nuevaMascota) {
        Response response =
                given()
                        .baseUri(URL_BASE)
                        .contentType("application/json")
                        .body(nuevaMascota)
                        .log()
                        .all()
                        .when()
                        .post("pet");

        respuestaCodigo = response.getStatusCode();

        Mascota mascotaResponse = response.as(Mascota.class);

        System.out.println("OUT: " + mascotaResponse.getId());
        System.out.println("OUT: " + mascotaResponse.getName());
    }

    public int getRespuestaCodigo() {
        return respuestaCodigo;
    }
}
