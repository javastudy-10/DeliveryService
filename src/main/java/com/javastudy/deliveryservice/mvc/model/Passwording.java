package com.javastudy.deliveryservice.mvc.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maxim Sambulat
 */
public interface Passwording {
   String getPassword();
   void setPassword(String password);
}
