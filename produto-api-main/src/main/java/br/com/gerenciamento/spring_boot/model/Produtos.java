package br.com.gerenciamento.spring_boot.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;

@Entity
@Table(name= "produtos")
@Data
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int quantity;
}
