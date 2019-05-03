package com.tulipsoftwaresolutions.mobileapp.services.userservices.impl;

import com.tulipsoftwaresolutions.mobileapp.services.common.Utils;
import com.tulipsoftwaresolutions.mobileapp.services.ui.model.request.UserDetailsRequestModel;
import com.tulipsoftwaresolutions.mobileapp.services.ui.model.response.UserRest;
import com.tulipsoftwaresolutions.mobileapp.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl(){}

    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {
        UserRest user = new UserRest();
        user.setFirstName(userDetailsRequestModel.getFirstName());
        user.setLastName(userDetailsRequestModel.getLastName());
        user.setEmail(userDetailsRequestModel.getEmail());
        String userId = utils.generateUID();
        user.setUserId(userId);
        user.setPassword(userDetailsRequestModel.getPassword());

        if(users == null) users = new HashMap<>();
        users.put(userId, user);
        return user;
    }
}
