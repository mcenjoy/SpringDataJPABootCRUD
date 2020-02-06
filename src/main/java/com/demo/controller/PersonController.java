package com.demo.controller;

import com.demo.model.Person;
import com.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by mcenjoy
 * on 04/02/2020
 */
@Controller
@RequestMapping("/")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/")
    public String showUpdate(Model model) throws InterruptedException {
        model.addAttribute("persons", personService.findAll());
        return "index";
    }

    @GetMapping(value = "/all")
    public String showUpdateForm(Model model) throws InterruptedException {
        model.addAttribute("persons", personService.findAll());
        return "index";
    }

    @GetMapping("add")
    public String showSignUpForm(Person person, Model model) {
        model.addAttribute("person", person);
        return "add-person";
    }

    @PostMapping(value = "/add")
    public String addPerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) return "add-person";
        model.addAttribute(personService.addPerson(person));
        return "redirect:/all";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) throws InterruptedException {
        Person person = personService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);
        return "update-person";
    }

    @PostMapping("update/{id}")
    public String updatePerson(@PathVariable("id") long id, @Valid Person person, BindingResult result,
                               Model model) throws InterruptedException {
        if (result.hasErrors()) {
            person.setId(id);
            return "update-person";
        }
        personService.updatePerson(person);
        model.addAttribute("person", person);
        model.addAttribute("persons", personService.findAll());
        return "redirect:/all";
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deletePerson(@PathVariable long id, ModelAndView modelAndView) throws InterruptedException {
        personService.removeById(id);
        modelAndView.addObject("persons", personService.findAll());
        modelAndView.setViewName("redirect:/all");
        return modelAndView;
    }

    /*For Search Options*/
    @PostMapping(value = "/findByName")
    public ModelAndView findPersonByName(@RequestParam("name") String name, ModelAndView modelAndView) {

        modelAndView.addObject("persons", personService.findPersonByName(name));
        //    modelAndView.setViewName("/persons/search-results");
        return modelAndView;
    }

    @PostMapping(value = "/findByEmail")
    public ModelAndView findPersonByNameAndPosition(@RequestParam("email") String email,
                                                    ModelAndView modelAndView) {
        modelAndView.addObject("persons", personService.findPersonByEmail(email));
        //modelAndView.setViewName("/persons/search-results");
        return modelAndView;
    }

    @PostMapping(value = "/findByNameAndEmail")
    public ModelAndView findPersonByNameAndPhone(@RequestParam("name") String name,
                                                 @RequestParam("email") String email,
                                                 ModelAndView modelAndView) {
        modelAndView.addObject("employees", personService.findPersonByNameAndEmail(
                name, email
        ));
        //  modelAndView.setViewName("/persons/search-results");
        return modelAndView;
    }
}