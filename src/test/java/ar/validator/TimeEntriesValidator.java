package ar.validator;


import api.model.project.TimeEntriesResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class TimeEntriesValidator {
    public static void validarlistadeIdNoNull() {
        TimeEntriesResponse[] response = (TimeEntriesResponse[]) APIManager.getLastResponse().getResponse();
        for (TimeEntriesResponse timeentry : response) {
            Assert.assertNotNull(timeentry.getId());
        }

    }

    public static void validaridnonull() {
        TimeEntriesResponse response = (TimeEntriesResponse) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response.getId());


    }

    public static void validaridnull() {
        TimeEntriesResponse response = (TimeEntriesResponse) APIManager.getLastResponse().getResponse();
        Assert.assertNull(response.getId());
    }
}
