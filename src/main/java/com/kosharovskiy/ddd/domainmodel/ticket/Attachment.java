package com.kosharovskiy.ddd.domainmodel.ticket;

import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.AttachmentId;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.FileName;
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
