package com.tulipsoftwaresolutions.mobileapp.services.userservices;

import com.tulipsoftwaresolutions.mobileapp.services.ui.model.request.UserDetailsRequestModel;
import com.tulipsoftwaresolutions.mobileapp.services.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserService {
    UserRest createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel);
}
