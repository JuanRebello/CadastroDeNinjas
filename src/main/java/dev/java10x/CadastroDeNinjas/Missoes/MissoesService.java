package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel criarMissao (MissoesModel missao){
        return missoesRepository.save(missao);
    }
}
