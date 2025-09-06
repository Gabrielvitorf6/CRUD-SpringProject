package com.GabrielVitor.CRUDSpring.infrastructure;

import com.GabrielVitor.CRUDSpring.infrastructure.entitys.User;
import com.GabrielVitor.CRUDSpring.infrastructure.repository.UserRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.xmlunit.util.Mapper;

import java.util.Optional;

import static jdk.internal.classfile.impl.DirectCodeBuilder.build;

@Service
public class UserService {

    private final UserRepository repository;
    public UserService(UserRepository repository){

        this.repository = repository;
    }
    public void saveUser(User User){

        repository.saveAndFlush(User);
    }
    User searchUserbyEmail(String email){
       return   repository.findByEmail(email).orElseThrow(() -> new RuntimeException("User/Email not found"));
    }
    public void deleteUserbyEmail(String email){
        repository.deleteByEmail(email);
    }
     public void updateUserbyEmail(String email, User  User){
       User userEntity;
        userEntity = repository.findByEmail(email).orElseThrow(() -> new RuntimeException("User/Email not found"));
    User userUpdated =User.builder()
            .email(User.getEmail() != null ? User.getEmail() : userEntity.getEmail())
            .phone(User.getPhone() != null ? User.getPhone() : userEntity.getPhone())
            .country(User.getCountry() != null User.getCountry() : userEntity.getCountry())
        .build();
    }

}
