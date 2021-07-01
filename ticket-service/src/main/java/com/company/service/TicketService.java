package com.company.service;

import com.company.dto.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TicketService {

    TicketDTO save(TicketDTO ticketDto);

    TicketDTO update(String id, TicketDTO ticketDto);

    TicketDTO getById(String ticketId);

    Page<TicketDTO> getPagination(Pageable pageable);
}
