package com.kosharovskiy.ddd.domainmodel.customer;

import com.kosharovskiy.ddd.domainmodel.common.Email;
import com.kosharovskiy.ddd.domainmodel.customer.valueobject.CustomerId;
import com.kosharovskiy.ddd.domainmodel.customer.valueobject.Name;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.TicketId;

import java.util.List;

public class Customer {
    private CustomerId customerId;
    private Email email;
    private Name name;
    private List<TicketId> ticketIds;
}