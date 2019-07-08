package com.kgisl.springxml.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.kgisl.springxml.dao.ContactDAO;
import com.kgisl.springxml.model.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * ContactController
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
    
    @Autowired
    private ContactDAO contactDAO;
 
//     public ContactController(ContactDAO contactDAO){
// this.contactDAO=new ContactDAOImpl();
//     }


    @RequestMapping(value="/")
public ModelAndView listContact(ModelAndView model) throws IOException{
    List<Contact> listContact = contactDAO.list();
    System.out.println(Arrays.toString(listContact.toArray())); 
    model.addObject("listContact", listContact);
    model.setViewName("contact");
 
    return model;
}
@RequestMapping(value = "/newContact", method = RequestMethod.GET)
public ModelAndView newContact(ModelAndView model) {
    Contact newContact = new Contact();
    model.addObject("contact", newContact);
    model.setViewName("contactform");
    return model;
}
@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
public ModelAndView saveContact(@ModelAttribute Contact contact) {
    contactDAO.saveOrUpdate(contact);
    return new ModelAndView("redirect:/");
}
}