package com.startdis.comm.minio.domian;

import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@njydsz.com
 * @desc FileInfo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class FileInfoVO implements Serializable {
    
    private static final long serialVersionUID = 641456004804068691L;
    String filename;

    Boolean directory;
}
