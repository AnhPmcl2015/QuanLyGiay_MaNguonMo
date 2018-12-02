package com.shoe.dao;

import com.shoe.dto.Authorize;
import com.shoe.form.UserForm;

public interface UserDao {
    public Authorize authorized(UserForm u);
    public Authorize checkToken(Authorize auth);
}
