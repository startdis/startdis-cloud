package com.startdis.comm.minio.domian;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class BucketVO implements Serializable {
    
    private static final long serialVersionUID = 641456004804068691L;
    
    /**
     * bucketName
     */
    private String bucketName;
    
}
