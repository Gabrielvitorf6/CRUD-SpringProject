package com.GabrielVitor.CRUDSpring.DTO;

public record UserRequestDTO(
        String username,
        String email,
        String password ,
        String country,
        String phone,
        String adress
) {}



