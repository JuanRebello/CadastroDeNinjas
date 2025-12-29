package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar") // Post == Criar
    public String criarMissao(){
        return "Missao Criada com sucesso";

    }

    @GetMapping("/listar") // Get == mostrar/mandar
    public String listaMissao(){
        return "Missoes Listadas com sucesso";
    }

    @PutMapping("/alterar") // Put == alterar/mudar
    public String alterarMissao(){
        return "Missão alterada com sucesso";

    }

    @DeleteMapping("/Deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";

    }

}
