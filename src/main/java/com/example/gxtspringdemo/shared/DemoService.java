package com.example.gxtspringdemo.shared;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface DemoService extends RestService {
    @POST
    @Path("../api/hello")
    public void hello(MethodCallback<DemoDTO> callback);
}
