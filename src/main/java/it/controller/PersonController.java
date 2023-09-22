package it.controller;

import it.model.Person;
import it.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("p", personRepository.findAll());
        return "find-all";
    }

    @GetMapping("find/by/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("s", personRepository.findById(id));
        return "find-by";
    }

    @GetMapping("save/form")
    public String saveForm() {
        return "save-form";
    }

    @PostMapping("save")
    public String save(
            @RequestParam("name") String name,
            @RequestParam("age") int age
    ) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personRepository.save(person);
        return "redirect:/";
    }

    @GetMapping("update/form/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("st", personRepository.findById(id));
        return "update-form";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable int id, @RequestParam("name") String name, @RequestParam("age") int age) {
        Person person = personRepository.findById(id);
        person.setName(name);
        person.setAge(age);
        personRepository.update(person, id);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        personRepository.delete(id);
        return "redirect:/";
    }
}