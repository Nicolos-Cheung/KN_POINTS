package com.zn.interfaces.assembler;

import com.zn.domain.leave.entity.valueobject.Approver;
import com.zn.interfaces.dto.ApproverDTO;

public class ApproverAssembler {

    public static ApproverDTO toDTO(Approver approver){
        ApproverDTO dto = new ApproverDTO();
        dto.setPersonId(approver.getPersonId());
        dto.setPersonName(approver.getPersonName());
        return dto;
    }

    public static Approver toDO(ApproverDTO dto){
        Approver approver = new Approver();
        approver.setPersonId(dto.getPersonId());
        approver.setPersonName(dto.getPersonName());
        return approver;
    }

}
