package com.example.corebase.entity.affiliate;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "hashtag_ref")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HashtagRefEntity extends AuditEntity implements Serializable {

    @Id
    private String hashtagRefSeq;

    private String refSeq;

    private String typeCd;
}
