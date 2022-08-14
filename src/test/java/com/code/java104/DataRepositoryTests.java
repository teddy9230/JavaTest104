package com.code.java104;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DataRepositoryTests {
    @Autowired
    private DataRepository repo;

    @Test
    public void testAdd() {
        Data data = new Data();
        data.setcAes256("sdf");
        data.setcBase64("sadf");
        Data saveData = repo.save(data);

        Assertions.assertThat(saveData).isNotNull();

    }

    @Test
    public void testListAll() {
        Iterable<Data> datas = repo.findAll();
        Assertions.assertThat(datas).hasSizeGreaterThan(0);

        for (Data data : datas) {
            System.out.println(data);
        }
    }
//
//    @Test
//    public void testUpdate() {
//        Integer userId = 1;
//        Optional<User> optionalUser = repo.findById(userId);
//
//        User user = optionalUser.get();
//        user.setPassword("testpassword");
//        repo.save(user);
//
//        User updateUser = repo.findById(userId).get();
//        Assertions.assertThat(updateUser.getPassword()).isEqualTo("testpassword");
//    }
//
//    @Test
//    public void testGet(){
//        Integer userId = 12;
//        Optional<User> optionalUser = repo.findById(userId);
//
//        Assertions.assertThat(optionalUser).isPresent();
//        System.out.println(optionalUser.get());
//    }
//
//    @Test
//    public void testDelete(){
//        Integer userId = 12;
//        repo.deleteById(userId);
//
//        Optional<User> optionalUser = repo.findById(userId);
//        Assertions.assertThat(optionalUser).isNotPresent();
//    }

}
