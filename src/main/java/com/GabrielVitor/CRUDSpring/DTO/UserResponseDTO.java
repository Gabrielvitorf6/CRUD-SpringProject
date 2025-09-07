package com.GabrielVitor.CRUDSpring.DTO;

public record UserResponseDTO(String username,
                              String email,
                              String country,
                              String phone,
                              String adress, Integer id) {
}
