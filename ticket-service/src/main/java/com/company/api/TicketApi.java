package com.company.api;

import com.company.dto.TicketDTO;
import com.company.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketApi {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.save(ticketDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@RequestParam(value = "id") String id,
                                                  @RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.update(id, ticketDTO));
    }

    public ResponseEntity<Page<TicketDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }
}
