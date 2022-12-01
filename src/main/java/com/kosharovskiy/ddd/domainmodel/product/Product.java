package com.kosharovskiy.ddd.domainmodel.product;

import com.kosharovskiy.ddd.domainmodel.product.valueobject.ProductId;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.TicketId;

import java.util.List;

public class Product {
    private ProductId productId;
    private List<TicketId> ticketIds;
}
