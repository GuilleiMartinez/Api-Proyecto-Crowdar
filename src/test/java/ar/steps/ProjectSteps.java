package ar.steps;


import ar.validator.TimeEntriesValidator;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import services.BaseService;

public class ProjectSteps extends PageSteps {

    @And("^un nombre de proyecto (.*)$")
    public void unNombreDeProyectoName(String name) {
        BaseService.NAME.set(name);
    }

    @Then("^Obtengo los datos de mi Proyecto (.*)$")
    public void obtengoLosDatosDeMiProyectoName(String name) {
        TimeEntriesValidator.validarlistadeIdNoNull();
    }

    @And("un id workspace valido")
    public void unIdWorkspaceValido() {
        BaseService.ID_WORKSPACE.set("616dc9e0747e1a1f68147c87");
    }

    //@And("guardo el id del proyecto")
    /*public void guardoElIdDelProyecto() {
        TimeEntriesResponse response = (TimeEntriesResponse) APIManager.getLastResponse().getResponse();
        ProjectModificarService.ID_P.set(response.getId());
    }*/
}
