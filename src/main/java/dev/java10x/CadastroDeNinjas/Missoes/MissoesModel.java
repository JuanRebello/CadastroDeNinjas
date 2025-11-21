package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    // @OneToMany uma missão para varios ninjas
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;


}
