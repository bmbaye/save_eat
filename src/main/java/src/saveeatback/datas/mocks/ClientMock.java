package src.saveeatback.datas.mocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Order(1)
public class ClientMock implements CommandLineRunner {
    private final ClientRepository clientRepository;

    ClientMock(ClientRepository clientRepository){
        this.clientRepository =clientRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        List<Client> clients = new ArrayList<>();
        for (int i=1; i<=2; i++){
            Client client = new Client();
            client.setNom("xxxx"+i);
            client.setPrenom("yyyy"+i);
            client.setTelephone("77456325"+i);
            client.setVille("Guediawaye");
            client.setRue("WN rue-246");
            client.setImage("default.jpeg");

            clients.add(client);
        }
        this.clientRepository.saveAll(clients);
        System.out.println("Clients en registrer avec succes !!");
    }
}
