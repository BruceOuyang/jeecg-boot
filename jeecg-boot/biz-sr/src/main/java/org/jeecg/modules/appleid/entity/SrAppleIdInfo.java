package org.jeecg.modules.appleid.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: Apple Id 管理
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Data
@TableName("sr_apple_id_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sr_apple_id_info对象", description="Apple Id 管理")
public class SrAppleIdInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**appleAccount*/
	@Excel(name = "appleAccount", width = 15)
    @ApiModelProperty(value = "appleAccount")
    private java.lang.String appleAccount;
	/**applePassword*/
	@Excel(name = "applePassword", width = 15)
    @ApiModelProperty(value = "applePassword")
    private java.lang.String applePassword;
	/**deviceNum*/
	@Excel(name = "deviceNum", width = 15)
    @ApiModelProperty(value = "deviceNum")
    private java.lang.Integer deviceNum;
	/**1:正常 0:冻结*/
	@Excel(name = "1:正常 0:冻结", width = 15)
    @ApiModelProperty(value = "1:正常 0:冻结")
    private java.lang.Integer statu;
	/**createrTime*/
	@Excel(name = "createrTime", width = 15)
    @ApiModelProperty(value = "createrTime")
    private java.lang.String createrTime;
	/**tip*/
	@Excel(name = "tip", width = 15)
    @ApiModelProperty(value = "tip")
    private java.lang.String tip;
	/**bundleId*/
	@Excel(name = "bundleId", width = 15)
    @ApiModelProperty(value = "bundleId")
    private java.lang.String bundleId;
	/**ownerId*/
	@Excel(name = "ownerId", width = 15)
    @ApiModelProperty(value = "ownerId")
    private java.lang.Integer ownerId;
	/**1:正常 0:出错*/
	@Excel(name = "1:正常 0:出错", width = 15)
    @ApiModelProperty(value = "1:正常 0:出错")
    private java.lang.Integer errorStatu;
	/**错误信息*/
	@Excel(name = "错误信息", width = 15)
    @ApiModelProperty(value = "错误信息")
    private java.lang.String errorMsg;
	/**0：可用  1：不可用*/
	@Excel(name = "0：可用  1：不可用", width = 15)
    @ApiModelProperty(value = "0：可用  1：不可用")
    private java.lang.Integer isDelect;
}
