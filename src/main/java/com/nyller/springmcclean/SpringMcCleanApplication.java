package com.nyller.springmcclean;

import com.nyller.springmcclean.gateway.mysql.model.PaymentByCardDatabase;
import com.nyller.springmcclean.gateway.mysql.model.PaymentWithBankSlipDatabase;
import com.nyller.springmcclean.domain.enums.ClientType;
import com.nyller.springmcclean.domain.enums.PaymentStatus;
import com.nyller.springmcclean.gateway.mysql.model.*;
import com.nyller.springmcclean.gateway.mysql.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@SpringBootApplication
public class SpringMcCleanApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemOrderRepository itemOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMcCleanApplication.class, args);
    }

    @Override
    public void run(String... args) throws ParseException {

        CategoryDatabase category1 = new CategoryDatabase(null, "Escritório");
        CategoryDatabase category2 = new CategoryDatabase(null, "Informática");
        categoryRepository.saveAll(Arrays.asList(category1, category2));

        ProductDatabase product1 = new ProductDatabase(null, "Computador", 1500.00, Arrays.asList(category1, category2));
        ProductDatabase product2 = new ProductDatabase(null, "Mesa", 500.00, Collections.singletonList(category1));
        productRepository.saveAll(Arrays.asList(product1, product2));

        StateDatabase state1 = new StateDatabase(null, "São Paulo");
        StateDatabase state2 = new StateDatabase(null, "Rio de Janeiro");

        CityDatabase city1 = new CityDatabase(null, "Iracemápolis", state1);
        CityDatabase city2 = new CityDatabase(null, "Limeira", state1);
        state1.setCityDatabases(Arrays.asList(city1, city2));

        stateRepository.saveAll(Arrays.asList(state1, state2));
        cityRepository.saveAll(Arrays.asList(city1, city2));

        ClientDatabase client1 = new ClientDatabase(null, "Maria", "maria@hotmail.com", "41649716818", ClientType.PESSOAFISICA);
        ClientDatabase client2 = new ClientDatabase(null, "Celso", "celsonyl@hotmail.com", "465.009.410-04", ClientType.PESSOAFISICA);
        client1.setPhones(Set.of("454545", "5454"));
        client2.setPhones(Set.of("121212", "5453232124"));

        AddressDatabase address1 = new AddressDatabase(null, "Rua flores", "300", "Apto 203", "Jardim", "3822024", client1, city1);
        AddressDatabase address2 = new AddressDatabase(null, "Avenida matos", "120", "Sala 800", "Centro", "1221214", client1, city2);
        AddressDatabase address3 = new AddressDatabase(null, "Teste matos", "1220", "Quarto 800", "Centro Avenida", "114", client2, city2);

        client1.setAddressDatabase(Arrays.asList(address1, address2));
        client2.setAddressDatabase(Collections.singletonList(address3));
        clientRepository.saveAll(Arrays.asList(client1, client2));
        addressRepository.saveAll(Arrays.asList(address1, address2, address3));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        OrderDatabase order1 = new OrderDatabase(null, dateFormat.parse("30/09/2021 13:23"), client1, address1);
        OrderDatabase order2 = new OrderDatabase(null, dateFormat.parse("10/12/2021 08:23"), client1, address2);

        PaymentDatabase payment1 = new PaymentByCardDatabase(null, PaymentStatus.QUITED, order1, 6);
        order1.setPaymentDatabase(payment1);
        PaymentDatabase payment2 = new PaymentWithBankSlipDatabase(null, PaymentStatus.PENDENT, order2, dateFormat.parse("13/12/2021 00:00"), dateFormat.parse("00/00/0000 00:00"));
        order2.setPaymentDatabase(payment2);

        client1.getOrderDatabaseList().addAll(Arrays.asList(order1, order2));

        orderRepository.saveAll(Arrays.asList(order1, order2));
        paymentRepository.saveAll(Arrays.asList(payment1, payment2));

        ItemOrderDatabase itemOrder1 = new ItemOrderDatabase(product1, order1, 0.0, 3, 1400.0);
        ItemOrderDatabase itemOrder2 = new ItemOrderDatabase(product2, order2, 100.0, 10, 100.0);
        ItemOrderDatabase itemOrder3 = new ItemOrderDatabase(product1, order2, 10.0, 1, 1000.0);
        product1.setItens(Set.of(itemOrder1, itemOrder3));
        product2.setItens(Set.of(itemOrder2));
        order1.setItens(Set.of(itemOrder1));
        order2.setItens(Set.of(itemOrder2, itemOrder3));
        
        itemOrderRepository.saveAll(Arrays.asList(itemOrder1, itemOrder2, itemOrder3));
    }
}