package org.dilip.first.pos_backend.api;

import org.dilip.first.pos_backend.dao.ClientDao;
import org.dilip.first.pos_backend.entity.ClientEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientApi {

    private final ClientDao clientDao;

    public ClientApi(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientEntity createClient(String name, String email, String phone) {
        if (clientDao.findByEmail(email) != null) {
            throw new RuntimeException("Client already exists");
        }
        ClientEntity entity = new ClientEntity();
        entity.setName(name);
        entity.setEmail(email);
        entity.setPhone(phone);

        return clientDao.save(entity);
    }

    public List<ClientEntity> getAll() {
        return clientDao.findAll();
    }
}

