package com.example.demo.Domain;

@Entity
@Table(name = "Ride")

interface User
{
    @GeneratedValue(
            strategy= GenerationType.IDENTITY
    )

    public void Register(String userName , String email , String password , String phone);
    public void Login(String email , String password);    
}
