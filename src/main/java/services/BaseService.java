package services;

import com.crowdar.api.rest.MethodsService;

public class BaseService extends MethodsService {

    public static final ThreadLocal<String> API_KEY = new ThreadLocal<String>();
    public static final ThreadLocal<String> ID_WORKSPACE = new ThreadLocal<String>();
    public static final ThreadLocal<String> NAME = new ThreadLocal<String>();
    public static final ThreadLocal<String> USER_ID = new ThreadLocal<String>();
    public static final ThreadLocal<String> ID_UPDATE = new ThreadLocal<String>();



}
