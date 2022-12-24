package com.kosharovskiy.ddd.businesslogic.domainmodel.ticket;

import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.FileName;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.AttachmentId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Attachment {
    private AttachmentId attachmentId;
    private FileName fileName;
}
