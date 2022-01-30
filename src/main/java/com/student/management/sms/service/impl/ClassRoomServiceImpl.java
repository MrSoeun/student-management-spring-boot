package com.student.management.sms.service.impl;

import com.student.management.sms.entity.ClassRoom;
import com.student.management.sms.repository.ClassRoomReposistory;
import com.student.management.sms.service.ClassRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomReposistory classRoomReposistory;

    public ClassRoomServiceImpl(ClassRoomReposistory classRoomReposistory) {
        this.classRoomReposistory = classRoomReposistory;
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return classRoomReposistory.findAll();
    }

    @Override
    public ClassRoom saveClassRoom(ClassRoom classRoom) {
        return classRoomReposistory.save(classRoom);
    }

    @Override
    public ClassRoom getClassRoomById(Long id) {
        return classRoomReposistory.findById(id).get();
    }

    @Override
    public ClassRoom updateClassRoom(ClassRoom classRoom) {
        return classRoomReposistory.save(classRoom);
    }

    @Override
    public void deleteClassRoomById(Long id) {
        classRoomReposistory.deleteById(id);
    }
}
