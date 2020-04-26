package org.jeecg.modules.udid.entity;

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
 * @Description: UDID 管理
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Data
@TableName("sr_udid_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sr_udid_info对象", description="UDID 管理")
public class SrUdidInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**udid*/
	@Excel(name = "udid", width = 15)
    @ApiModelProperty(value = "udid")
    private java.lang.String udid;
	/**deviceProduct*/
	@Excel(name = "deviceProduct", width = 15)
    @ApiModelProperty(value = "deviceProduct")
    private java.lang.String deviceProduct;
	/**deviceImei*/
	@Excel(name = "deviceImei", width = 15)
    @ApiModelProperty(value = "deviceImei")
    private java.lang.String deviceImei;
	/**deviceVersion*/
	@Excel(name = "deviceVersion", width = 15)
    @ApiModelProperty(value = "deviceVersion")
    private java.lang.String deviceVersion;
	/**关联的appleId*/
	@Excel(name = "关联的appleId", width = 15)
    @ApiModelProperty(value = "关联的appleId")
    private java.lang.String appleId;
	/**createrTime*/
	@Excel(name = "createrTime", width = 15)
    @ApiModelProperty(value = "createrTime")
    private java.lang.String createrTime;
	/**1:可用  0:不可用*/
	@Excel(name = "1:可用  0:不可用", width = 15)
    @ApiModelProperty(value = "1:可用  0:不可用")
    private java.lang.Integer statu;
}
