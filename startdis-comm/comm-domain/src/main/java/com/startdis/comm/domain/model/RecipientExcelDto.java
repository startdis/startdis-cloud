package com.startdis.comm.domain.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "电商采购领用")
public class RecipientExcelDto {
    @ApiModelProperty("序号")
    @ExcelProperty(index = 0, value = "序号")
    private Integer sort;

    @ApiModelProperty("公司名称")
    @ExcelProperty(index = 1, value = "公司名称")
    private String companyName;

    @ApiModelProperty("市级属地")
    @ExcelProperty(index = 2, value = "市级属地")
    private String cityTerritory;

    @ApiModelProperty("县级属地")
    @ExcelProperty(index = 3, value = "县级属地")
    private String countyTerritory;

    @ApiModelProperty("请购部门")
    @ExcelProperty(index = 4, value = "请购部门")
    private String applyDept;

    @ApiModelProperty("归口专业管理部门")
    @ExcelProperty(index = 5, value = "归口专业管理部门")
    private String proManageDept;

    @ApiModelProperty("项目名称")
    @ExcelProperty(index = 6, value = "项目名称")
    private String projectName;

    @ApiModelProperty("专区")
    @ExcelProperty(index = 7, value = "专区")
    private String zone;

    @ApiModelProperty("大类名称")
    @ExcelProperty(index = 8, value = "大类名称")
    private String bigClassName;

    @ApiModelProperty("中类名称")
    @ExcelProperty(index = 9, value = "中类名称")
    private String middleClassName;

    @ApiModelProperty("小类名称")
    @ExcelProperty(index = 10, value = "小类名称")
    private String smallClassName;

    @ApiModelProperty("商品编码")
    @ExcelProperty(index = 11, value = "商品编码")
    private String goodsCode;

    @ApiModelProperty("商品名称")
    @ExcelProperty(index = 12, value = "商品名称")
    private String goodsName;

    @ApiModelProperty("请购数量")
    @ExcelProperty(index = 13, value = "请购数量")
    private Integer purchaseNum;

    @ApiModelProperty("商品单价")
    @ExcelProperty(index = 14, value = "商品单价")
    private BigDecimal goodsUnitPrice;

    @ApiModelProperty("商品总价")
    @ExcelProperty(index = 15, value = "商品总价")
    private BigDecimal goodsSumPrice;

    @ApiModelProperty("供应商名称")
    @ExcelProperty(index = 16, value = "供应商名称")
    private String supplierName;

    @ApiModelProperty("预计交货期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(index = 17, value = "预计交货期")
    private LocalDateTime planSubTime;

    @ApiModelProperty("是否同品牌、同型号最低价")
    @ExcelProperty(index = 18, value = "是否同品牌、同型号最低价")
    private String isMinPrice;

    private String imageUnit;
}
