package com.kosharovskiy.ddd.businesslogic.domainmodel.product;

import com.kosharovskiy.ddd.businesslogic.domainmodel.product.valueobject.ProductId;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.TicketId;

import java.util.List;

public class Product {
    private ProductId productId;
    private List<TicketId> ticketIds;
}
