package com.student.management.sms.controller;

import com.student.management.sms.entity.ClassRoom;
import com.student.management.sms.service.ClassRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClassRoomController {

    private ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    //handler method to handle list student and return mode and view
    @GetMapping("/classrooms")
    public String listClassRoom(Model model)
    {
        model.addAttribute("classrooms", classRoomService.getAllClassRoom());
        return "class_rooms";
    }
    @GetMapping("/classrooms/view")
    public String createClassRoomForm(Model model)
    {
        ClassRoom classRoom = new ClassRoom();
        model.addAttribute("classrooms", classRoom);
        return "create_classrooms";
    }

    @PostMapping("/classrooms")
    public String saveClassRoom(@ModelAttribute("classrooms") ClassRoom classRoom)
    {
        classRoomService.saveClassRoom(classRoom);

        return "redirect:/classrooms";
    }
}
