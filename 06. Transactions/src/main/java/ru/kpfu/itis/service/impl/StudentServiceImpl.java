package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Adress;
import ru.kpfu.itis.model.Document;
import ru.kpfu.itis.model.Elective;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.model.enums.GenderType;
import ru.kpfu.itis.repository.DocumentRepository;
import ru.kpfu.itis.repository.ElectiveRepository;
import ru.kpfu.itis.repository.StudentRepository;
import ru.kpfu.itis.service.StudentService;

import java.util.ArrayList;
import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ElectiveRepository electiveRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void debugThis() {
        //int a = 5;
        studentRepository.findAll();
        Student s=new Student();
        s.setName("Ivan");
        Adress a=new Adress();
        a.setCity("London");
        a.setCountry("England");
        a.setHouse("90-207");
        a.setStreet("Backer street");
        s.setAdress(a);
        s.setGender(GenderType.MALE);
        Elective e=new Elective();
        e.setId(12312l);
        e.setName("Java");
        e.setDates(new ArrayList<Date>() {{new Date();}});
        Document d=new Document();
        d.setSerialNumber("1122");
        //d.setStudent(s);
        d.setDate(new Date());
        s.setMiddlename("Ivanovich");
        s.setSurname("Ivanov");
        studentRepository.save(s);

    }


}
