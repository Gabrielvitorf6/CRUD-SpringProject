package com.GabrielVitor.CRUDSpring.UserMapper;

import com.GabrielVitor.CRUDSpring.DTO.UserRequestDTO;
import com.GabrielVitor.CRUDSpring.DTO.UserResponseDTO;
import com.GabrielVitor.CRUDSpring.infrastructure.entitys.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto){
        return User.builder()
                .email(dto.email())
                .password(dto.password())
                .adress(dto.adress())
                .phone(dto.phone())
                .username(dto.username())
                .country(dto.country())
                .build();
    }
    public static UserResponseDTO toDto(User user){
        return new UserResponseDTO(
        user.getAdress(),
        user.getCountry(),
        user.getEmail(),
        user.getPhone(),
        user.getUsername(),
        user.getId());
    }
}
