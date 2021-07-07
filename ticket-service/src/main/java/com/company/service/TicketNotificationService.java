package com.company.service;

import com.company.model.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
