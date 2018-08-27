package com.example.gxtspringdemo.shared.service;

import com.example.gxtspringdemo.shared.DemoDTO;
import com.example.gxtspringdemo.shared.model.User;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface UserService extends RestService {
    @POST
    @Path("../api/user")
    void check(User user, MethodCallback<DemoDTO> callback);
}
