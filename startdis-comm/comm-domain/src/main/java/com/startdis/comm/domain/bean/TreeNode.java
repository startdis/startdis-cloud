package com.startdis.comm.domain.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc ResultBean
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class TreeNode<T extends TreeNode> implements Serializable {
    
    private static final long serialVersionUID = 8676131899637805509L;
    
    /**
     * 当前节点ID
     */
    @ApiModelProperty("当前节点ID")
    private String id;
    
    /**
     * 父节点ID 顶级节点为0
     */
    @ApiModelProperty("父节点ID")
    private String parentId;
    
    /**
     * 子节点
     */
    @ApiModelProperty("子节点")
    private List<T> children;
    
    
    
}
