package com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.command;

import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.Status;

public record ChangeStatus(Status status) {
}
