package com.code.java104;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository repo;

    public List<Data> listAll(){
        return (List<Data>) repo.findAll();
    }

    public void save(Data data) {
        repo.save(data);
    }

}
