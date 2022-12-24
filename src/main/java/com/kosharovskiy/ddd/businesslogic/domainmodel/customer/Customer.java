package com.kosharovskiy.ddd.businesslogic.domainmodel.customer;

import com.kosharovskiy.ddd.businesslogic.domainmodel.common.Email;
import com.kosharovskiy.ddd.businesslogic.domainmodel.customer.valueobject.CustomerId;
import com.kosharovskiy.ddd.businesslogic.domainmodel.customer.valueobject.Name;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.TicketId;

import java.util.List;

public class Customer {
    private CustomerId customerId;
    private Email email;
    private Name name;
    private List<TicketId> ticketIds;
}