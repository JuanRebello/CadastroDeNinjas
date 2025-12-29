package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // Mostrar todos os Ninjas
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Mostrando todos os ninjas";
    }
    // Mostrar ninja por id
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrando todos os ninjas por id";
    }
    // Alterar dados dos Ninjas
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar ninja po id";
    }

    // Deletar Ninja
    @DeleteMapping("/deletarID")
    public String DeletarNinjaPorId(){
        return "Deletar ninja por ID";
    }



}
