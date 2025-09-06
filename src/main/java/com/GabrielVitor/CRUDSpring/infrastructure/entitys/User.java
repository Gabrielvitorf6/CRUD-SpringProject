package com.GabrielVitor.CRUDSpring.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    @Column(name = "E-mail", unique = true)
    private String email;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone", unique = true)
    private String phone;

  @Column(name = "Adress")
    private String adress;

  @Column(name = "Country")
  private String country;



}
