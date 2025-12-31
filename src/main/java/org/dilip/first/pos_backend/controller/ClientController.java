package org.dilip.first.pos_backend.controller;
import jakarta.validation.Valid;
import org.dilip.first.pos_backend.model.data.ClientData;
import org.dilip.first.pos_backend.model.form.ClientForm;
import org.springframework.web.bind.annotation.*;
import org.dilip.first.pos_backend.dto.ClientDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientDto clientDto;

    public ClientController(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    @PostMapping("/createClient")
    public ClientData createClient(@Valid @RequestBody ClientForm form) {
        return clientDto.createClient(form);
    }

    @GetMapping("/getClients")
    public List<ClientData> getAll() {
        return clientDto.getAll();
    }
}
