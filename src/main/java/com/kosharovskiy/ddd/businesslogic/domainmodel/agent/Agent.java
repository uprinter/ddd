package com.kosharovskiy.ddd.businesslogic.domainmodel.agent;

import com.kosharovskiy.ddd.businesslogic.domainmodel.agent.valueobject.AgentId;
import com.kosharovskiy.ddd.businesslogic.domainmodel.common.Email;
import com.kosharovskiy.ddd.businesslogic.domainmodel.agent.valueobject.Name;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.TicketId;

import java.util.List;

public class Agent {
    private AgentId agentId;
    private Email email;
    private Name name;
    private List<TicketId> ticketIds;
}