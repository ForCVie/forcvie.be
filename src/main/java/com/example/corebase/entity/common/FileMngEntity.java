package com.example.corebase.entity.common;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "FILE_MNG")
public class FileMngEntity extends AuditEntity {

    @Id
    private String fimId;
    private String fimSubFileId;
    private String fimFileCategory;
    private String fimFileName;
    private String fimFilePath;
    private String fimFileExt;
    private Long fimFileSize;
    private String fimUseYn;
    private String fimReferKeyId;
    private String fimFileOrgName;
    private String fimSectionName;
}
