package ar.steps;

import api.config.EntityConfiguration;
import api.model.project.TimeEntriesResponse;
import ar.validator.TimeEntriesValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import services.BaseService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WorkspaceSteps extends PageSteps {

    @Given("que genere un X-Api-Key valido")
    public void miCuentaCreadaEnClockifyYMiXApiKeyGeneada() {
        BaseService.API_KEY.set("NmE1NjJiOGEtZjQwYy00MDAyLWJiNjYtNzkyMzNjZjJjNmZl");
    }




    @When("I perform a {string} to {string} endpoint with the {string} and {string}")
    public void doRequest(String methodName, String entity, String jsonName, String jsonReplacementValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonReplacementValues);
        String jsonPath = "request/".concat(jsonName);
        if (parameters == null) {
            entityService.getMethod(methodName.toLowerCase(), String.class).invoke("", jsonPath);
        } else {
            entityService.getMethod(methodName.toLowerCase(), String.class, Map.class).invoke("", jsonPath, parameters);
        }
    }

        private Map<String, String> getParameters(String jsonReplacementValues) {
            Map<String, String> parameters = null;
            if (!StringUtils.isEmpty(jsonReplacementValues)) {
                parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
            }
            return parameters;
        }


    @Then("Valido los datos obtenidos")
    public void validoLosDatosObtenidos() {
        TimeEntriesValidator.validarlistadeIdNoNull();

    }

    @And("un workspace ID valido")
    public void unWorkspaceIDValido() {
        BaseService.ID_WORKSPACE.set("6189afd61d6df928cd904164");
    }

    @And("un User Id valido")
    public void unUserIdValido() {
        BaseService.USER_ID.set("616f3fbd99d16c30b318e7d3");
    }

    @Then("valido el ID")
    public void validoElID() {
        TimeEntriesValidator.validaridnonull();


    // preguntar si puedo utilizar esta misma declaracion para el punto 3.
    }


    @And("Guardo time entries ID")
    public void guardoTimeEntriesID() {
        TimeEntriesResponse response = (TimeEntriesResponse) APIManager.getLastResponse().getResponse();
        BaseService.ID_UPDATE.set(response.getId());
    }

    @And("Tengo un time entry ID valido")
    public void tengoUnTimeEntryIDValido() {
        Assert.assertNotNull(BaseService.ID_UPDATE.get());
    }

    @Then("valido el ID NULO")
    public void validoElIDNULO() {
        TimeEntriesValidator.validaridnull();
    }
}
