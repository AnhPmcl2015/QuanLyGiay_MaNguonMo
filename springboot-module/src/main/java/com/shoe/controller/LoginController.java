package com.shoe.controller;

import com.shoe.ObjectToJson.ConvertToJson;
import com.shoe.Service.JwtService;
import com.shoe.dao.UserDao;
import com.shoe.dto.Authorize;
import com.shoe.entities.User;
import com.shoe.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/authorized-login", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> checkLogin(@RequestBody UserForm user) {
        ResponseEntity resp = null;

        String token="";
        Authorize au = userDao.authorized(user);
        if (au.getStatus().equals("OK")) {
            resp = new ResponseEntity<>(ConvertToJson.ToJson(au), HttpStatus.OK);
        } else {
            resp = new ResponseEntity<>(ConvertToJson.ToJson(au), HttpStatus.BAD_REQUEST);
        }
        return resp;
    }

    @RequestMapping(value = "/authorized-token", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> checkToken(@RequestBody Authorize auth) {

        Authorize au = userDao.checkToken(auth);
        ResponseEntity resp = new ResponseEntity<>(ConvertToJson.ToJson(au),HttpStatus.OK);
        return resp;
    }
}
