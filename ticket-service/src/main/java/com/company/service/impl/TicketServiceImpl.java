package com.company.service.impl;

import com.company.dto.TicketDTO;
import com.company.model.PriorityType;
import com.company.model.Ticket;
import com.company.model.TicketStatus;
import com.company.model.es.TicketModel;
import com.company.repository.TicketRepository;
import com.company.repository.es.TicketElasticRepository;
import com.company.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public TicketDTO save(TicketDTO ticketDto) {
        // Ticket -> Entity
        Ticket ticket = new Ticket();

        if(ticketDto.getDescription()==null)
            throw new IllegalArgumentException("Description bosh olmaz");

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));

        // Mysql save
        ticket = ticketRepository.save(ticket);

        //create TicketModel object
        TicketModel model = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
//                .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        //Elastic save
        ticketElasticRepository.save(model);

        // return object
        ticketDto.setId(ticket.getId());

        return ticketDto;
    }

    @Override
    public TicketDTO update(String id, TicketDTO ticketDto) {
        return null;
    }

    @Override
    public TicketDTO getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDTO> getPagination(Pageable pageable) {
        return null;
    }
}
