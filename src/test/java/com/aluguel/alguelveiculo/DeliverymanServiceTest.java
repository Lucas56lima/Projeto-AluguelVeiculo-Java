package com.aluguel.alguelveiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aluguel.aluguelveiculo.domain.commands.DeliverymanCommand;
import com.aluguel.aluguelveiculo.repositories.DeliverymanRepository;
import com.aluguel.aluguelveiculo.services.DelivermanService;

public class DeliverymanServiceTest {

    private DelivermanService delivermanService;
    private DeliverymanRepository deliverymanRepository;

    @BeforeEach
    public void setUp(){
        deliverymanRepository = mock(DeliverymanRepository.class);
        delivermanService = new DelivermanService();
        delivermanService.repository = deliverymanRepository;
    }

    @Test
    public void testPostAsyncDeliveryman_WithValidData_ShouldReturnSuccessReponse(){
        //Arrange
        DeliverymanCommand command = new DeliverymanCommand();
        command.setCnpj("89789745645656");
        command.setBirthday(LocalDate.of(1990,1,1));
        command.setCnhType("AB");
        command.setEmail("sdasdasdasd");
        command.setPassword("asdasdasdasd");
        command.setArchiveName("asdasd");

        //Mock repository response
        when(deliverymanRepository.findByCnpj("89789745645656")).thenReturn(null);

        //Act
        ResponseEntity<String> response = delivermanService.postAsyncDeliveryman(command);

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Dados inseridos com sucesso", response.getBody());

    }


}
