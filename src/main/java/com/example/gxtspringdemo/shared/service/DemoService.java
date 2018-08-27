package com.example.gxtspringdemo.shared.service;

import com.example.gxtspringdemo.shared.DemoDTO;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface DemoService extends RestService {
    @POST
    @Path("../api/hello")
    void hello(MethodCallback<DemoDTO> callback);
}
