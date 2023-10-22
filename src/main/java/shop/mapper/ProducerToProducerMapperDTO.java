package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.ProducerDTO;
import shop.entity.Producer;

@Component
public class ProducerToProducerMapperDTO {
    public Producer toEntity(final ProducerDTO producerDTO){
        final Producer producer = new Producer();

        producer.setMultiplier(producerDTO.getMultiplier());
        producer.setName(producerDTO.getName());

        return producer;
    }

    public ProducerDTO toDTO(final Producer producer){
        final ProducerDTO producerDTO = new ProducerDTO();

        producerDTO.setMultiplier(producer.getMultiplier());
        producerDTO.setName(producer.getName());

        return producerDTO;
    }
}
