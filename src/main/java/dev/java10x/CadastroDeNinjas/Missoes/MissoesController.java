package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @PostMapping("/criar") // Post == Criar
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissao(missoes);

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
