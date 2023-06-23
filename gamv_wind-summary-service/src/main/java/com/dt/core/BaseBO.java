package com.dt.core;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseBO {

    @Id
    private String id;

    private boolean enabled = true;

    private String createdby;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdon;

    private String updatedby;

//    @LastModifiedDate
    private LocalDateTime updatedon;

    public BaseBO(String createdby) {
        super();
        this.createdby = createdby;
        this.createdon = LocalDateTime.now();
        this.updatedby = createdby;
        this.updatedon = createdon;
    }
}
