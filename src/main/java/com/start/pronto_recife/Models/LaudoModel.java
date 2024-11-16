package com.start.pronto_recife.Models;

// ORM Jakarta dependencies
import jakarta.persistence.*;
// Importing classes Getter/Setter from lombok
import lombok.Getter;
import lombok.Setter;
// Built-in class to generate and interpret UUID
import java.util.UUID;
// database's entity
@Entity
// Define table name
@Table(name = "laudos")
// Generate getter and setter methods
@Getter @Setter
public class LaudoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String descricao;
}
