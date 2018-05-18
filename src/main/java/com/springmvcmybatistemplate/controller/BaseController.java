package com.springmvcmybatistemplate.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Some common methods.
 * 
 * @author Xiaoxu Duan
 */
public abstract class BaseController {
	/**
	 * Transfer date?
	 * @param binder
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(true);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
    } 
}
