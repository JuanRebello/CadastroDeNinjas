package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de Boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }


    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado Com sucesso: " + novoNinja.getNome() + " (ID) " + novoNinja.getId());
    }


    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }



    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por id", description = "Rota lista o ninja por id")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){


       NinjaDTO ninjasPorId = ninjaService.listarNinjasPorId(id);

       if (ninjasPorId != null){
           return ResponseEntity.ok(ninjasPorId);
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o id: "+id+" Não existe nos nossos registros");
       }


    }


    @PutMapping("/alterar/{id}")
    @Operation(summary = "altera o novo ninja por id", description = "Rota altera ninja por id")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Ninja alteradp com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado. Erro na alteração do ninja")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario manda id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja = ninjaService.atualizaNinja(id, ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: "+id+" não encontrado");
        }
    }


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
