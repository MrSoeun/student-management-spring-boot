package com.student.management.sms.service;

import com.student.management.sms.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    List<ClassRoom> getAllClassRoom();

    ClassRoom saveClassRoom(ClassRoom classRoom);
}
