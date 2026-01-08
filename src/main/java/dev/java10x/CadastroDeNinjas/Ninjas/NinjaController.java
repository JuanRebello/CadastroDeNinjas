package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado Com sucesso: " + novoNinja.getNome() + " (ID) " + novoNinja.getId());
    }

    // Mostrar todos os Ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){


       NinjaDTO ninjasPorId = ninjaService.listarNinjasPorId(id);

       if (ninjasPorId != null){
           return ResponseEntity.ok(ninjasPorId);
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o id: "+id+" Não existe nos nossos registros");
       }


    }

    // Alterar dados dos Ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja = ninjaService.atualizaNinja(id, ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: "+id+" não encontrado");
        }
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com " +id+" Deletado sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com id: "+id+" não encontrado");
        }


    }



}
