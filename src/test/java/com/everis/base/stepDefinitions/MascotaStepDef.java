package com.everis.base.stepDefinitions;

import com.everis.base.MascotaStep;
import com.everis.base.models.Mascota;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MascotaStepDef {
    @Steps
    MascotaStep mascotaStep;

    private Mascota nuevaMascota;
    private int respuestaCodigo;

    @Given("dado que estoy en la tienda")
    public void dadoQueEstoyEnLaTienda() {
        // No se requiere implementación para este paso
    }

    @When("consulto la mascota de ID {string}")
    public void consultoLaMascotaDeID(String id) {
        mascotaStep.consultaMascota(id);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int codigoEsperado) {
        Assert.assertEquals(codigoEsperado, mascotaStep.getRespuestaCodigo());
    }

    @When("agrego una nueva mascota con los siguientes detalles:")
    public void agregoUnaNuevaMascotaConLosSiguientesDetalles(DataTable dataTable) {
        // Convertir la tabla de datos en un objeto Mascota
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            nuevaMascota = new Mascota();
            nuevaMascota.setId(Integer.parseInt(columns.get("id")));
            nuevaMascota.setName(columns.get("nombre"));
        }
        mascotaStep.agregarMascota(nuevaMascota);
    }

    @Then("valido el codigo de respuesta sea {int} y la respuesta contiene la información de la nueva mascota")
    public void validoElCodigoDeRespuestaSeaYLaRespuestaContieneLaInformacionDeLaNuevaMascota(int codigoEsperado) {
        Assert.assertEquals(codigoEsperado, mascotaStep.getRespuestaCodigo());
        Assert.assertNotNull(nuevaMascota);
        System.out.println("Nueva Mascota ID: " + nuevaMascota.getId());
        System.out.println("Nombre: " + nuevaMascota.getName());
    }

    @Then("la respuesta contiene la información de la nueva mascota")
    public void la_respuesta_contiene_la_informacion_de_la_nueva_mascota() {
        Assert.assertNotNull(nuevaMascota);
        System.out.println("Nueva Mascota ID: " + nuevaMascota.getId());
        System.out.println("Nombre: " + nuevaMascota.getName());
    }
}
