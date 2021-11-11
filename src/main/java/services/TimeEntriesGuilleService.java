package services;


import api.model.project.TimeEntriesResponse;
import com.crowdar.core.PropertyManager;
import com.crowdar.api.rest.Response;
import java.util.HashMap;
import java.util.Map;


public class TimeEntriesGuilleService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, TimeEntriesResponse[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("api-key", API_KEY.get());
        params.put("workspaceId", ID_WORKSPACE.get());
        params.put("userId", USER_ID.get());
        ID_UPDATE.set("");
        return params;
    }

    public static Response post(String jsonName) {
        return post(jsonName, TimeEntriesResponse.class, setParamspost());

    }

    private static Map<String, String> setParamspost() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("api-key", API_KEY.get());
        params.put("workspaceId", ID_WORKSPACE.get());
        params.put("id", ID_UPDATE.get());
        return params;
    }

    public static Response put(String jsonName) {
        return put(jsonName, TimeEntriesResponse.class, setParamsput());
    }

    private static Map<String, String> setParamsput() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("api-key", API_KEY.get());
        params.put("workspaceId", ID_WORKSPACE.get());
        params.put("id", ID_UPDATE.get());
        return params;
    }

    public static Response get2(String jsonName) {
        return get(jsonName, TimeEntriesResponse.class, setParamsput());
    }
    public static Response delete(String jsonName) {
        return delete(jsonName, TimeEntriesResponse.class, setParamsput());
    }



}

