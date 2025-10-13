package br.com.microservices.application;

import br.com.microservices.application.dto.SaveClientRequestDTO;
import br.com.microservices.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService service;

    @GetMapping
    public String status(){
        log.info("microservice clients");
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody SaveClientRequestDTO dto){
        Client client = new Client(dto.cpf(), dto.name(), dto.age());
        service.save(client);
        URI header = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(header).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getClient(@RequestParam String cpf){
        var client = service.getByCPF(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }
}
