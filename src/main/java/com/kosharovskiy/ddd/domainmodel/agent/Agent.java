package com.kosharovskiy.ddd.domainmodel.agent;

import com.kosharovskiy.ddd.domainmodel.agent.valueobject.AgentId;
import com.kosharovskiy.ddd.domainmodel.agent.valueobject.Name;
import com.kosharovskiy.ddd.domainmodel.common.Email;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.TicketId;

import java.util.List;

public class Agent {
    private AgentId agentId;
    private Email email;
    private Name name;
    private List<TicketId> ticketIds;
}