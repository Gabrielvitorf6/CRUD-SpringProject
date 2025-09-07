package com.GabrielVitor.CRUDSpring.infrastructure;

import com.GabrielVitor.CRUDSpring.DTO.UserRequestDTO;
import com.GabrielVitor.CRUDSpring.DTO.UserResponseDTO;
import com.GabrielVitor.CRUDSpring.UserMapper.UserMapper;
import com.GabrielVitor.CRUDSpring.infrastructure.entitys.User;
import com.GabrielVitor.CRUDSpring.infrastructure.repository.UserRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.xmlunit.util.Mapper;

import java.util.Optional;


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
       return   repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email not found"));
    }
    public void deleteUserbyEmail(String email){
        repository.deleteByEmail(email);

    }
     public void updateUserbyEmail(String email, User  User){
        User userEntity = repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email not found"));
             User updatedUser = User.builder()
                     .email(userEntity.getEmail())
            .id(userEntity.getId())
            .username(User.getUsername() != null ? User.getUsername() : userEntity.getUsername())
                 .phone(User.getPhone() != null ? User.getPhone() : userEntity.getPhone())
                 .country(User.getCountry() != null ? User.getCountry() : userEntity.getCountry())
                 .adress(User.getAdress() != null ? User.getAdress() : userEntity.getAdress())
            .password(User.getPassword() != null ? User.getPassword() : userEntity.getPassword())
        .build();

             repository.saveAndFlush(updatedUser);
    }
    public UserResponseDTO save(UserRequestDTO dto){
        User user = UserMapper.toEntity(dto);
        repository.save(user);
        return UserMapper.toDto(user);
    }
}
