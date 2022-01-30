package com.student.management.sms.controller;

import com.student.management.sms.entity.ClassRoom;
import com.student.management.sms.service.ClassRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "create_classroom";
    }

    @PostMapping("/classrooms")
    public String saveClassRoom(@ModelAttribute("classroom") ClassRoom classRoom)
    {
        classRoomService.saveClassRoom(classRoom);

        return "redirect:/classrooms";
    }

    @GetMapping("classrooms/edit/{id}")
    public String editClassRoomById(@PathVariable Long id, Model model)
    {
        model.addAttribute("classroom", classRoomService.getClassRoomById(id));
        return "edit_classroom";
    }

    @PostMapping("/classrooms/{id}")
    public String updateClassRoom(@PathVariable Long id, @ModelAttribute("classroom") ClassRoom classRoom, Model model)
    {
        ClassRoom existingClassRoom = classRoomService.getClassRoomById(id);

        existingClassRoom.setClassName(classRoom.getClassName());
        existingClassRoom.setLimitStudent(classRoom.getLimitStudent());
        existingClassRoom.setDescription(classRoom.getDescription());
        classRoomService.updateClassRoom(existingClassRoom);
        return "redirect:/classrooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteClassRoom(@PathVariable Long id)
    {
        classRoomService.deleteClassRoomById(id);

        return "redirect:/classrooms";
    }
}
