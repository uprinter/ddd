package com.kosharovskiy.ddd.eventsourceddomainmodel.command;

import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;

public record ChangeStatus(Status status) {
}
