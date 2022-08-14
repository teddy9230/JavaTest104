package com.code.java104;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Base64;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    private DataService service;

    @GetMapping("/search")
    public String searchData(Model model){

        System.out.println("Search ...");
        List<Data> listData = service.listAll();
        System.out.println("listData ..." + listData);

        model.addAttribute("listData", listData);

        return "search";
    }

    @GetMapping("/create")
    public String createData(Model model){
        System.out.println("createForm ...");
        model.addAttribute("data", new Data());
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(Data data){
        System.out.println("data.getcBase64() " + data.getcBase64());

        byte[] encodedBytesData = Base64.getEncoder().encode(data.getcBase64().getBytes());
        System.out.println("encodedBytesData " + encodedBytesData);
        String base64EncodeData = new String(encodedBytesData);
        System.out.println("base64EncodeData " + base64EncodeData);
        data.setcBase64(base64EncodeData);

        service.save(data);
        return "redirect:/search";
    }
}
