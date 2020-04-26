package org.jeecg.modules.udid.controller;

import org.jeecg.modules.udid.entity.SrUdidInfo;
import org.jeecg.modules.udid.service.ISrUdidInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: UDID 管理
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Api(tags="UDID 管理")
@RestController
@RequestMapping("/udid/srUdidInfo")
@Slf4j
public class SrUdidInfoController extends JeecgController<SrUdidInfo, ISrUdidInfoService> {
	@Autowired
	private ISrUdidInfoService srUdidInfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param srUdidInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "UDID 管理-分页列表查询")
	@ApiOperation(value="UDID 管理-分页列表查询", notes="UDID 管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(SrUdidInfo srUdidInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<SrUdidInfo> queryWrapper = QueryGenerator.initQueryWrapper(srUdidInfo, req.getParameterMap());
		Page<SrUdidInfo> page = new Page<SrUdidInfo>(pageNo, pageSize);
		IPage<SrUdidInfo> pageList = srUdidInfoService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param srUdidInfo
	 * @return
	 */
	@AutoLog(value = "UDID 管理-添加")
	@ApiOperation(value="UDID 管理-添加", notes="UDID 管理-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody SrUdidInfo srUdidInfo) {
		srUdidInfoService.save(srUdidInfo);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param srUdidInfo
	 * @return
	 */
	@AutoLog(value = "UDID 管理-编辑")
	@ApiOperation(value="UDID 管理-编辑", notes="UDID 管理-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody SrUdidInfo srUdidInfo) {
		srUdidInfoService.updateById(srUdidInfo);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "UDID 管理-通过id删除")
	@ApiOperation(value="UDID 管理-通过id删除", notes="UDID 管理-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		srUdidInfoService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "UDID 管理-批量删除")
	@ApiOperation(value="UDID 管理-批量删除", notes="UDID 管理-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.srUdidInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "UDID 管理-通过id查询")
	@ApiOperation(value="UDID 管理-通过id查询", notes="UDID 管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		SrUdidInfo srUdidInfo = srUdidInfoService.getById(id);
		if(srUdidInfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(srUdidInfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param srUdidInfo
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, SrUdidInfo srUdidInfo) {
        return super.exportXls(request, srUdidInfo, SrUdidInfo.class, "UDID 管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, SrUdidInfo.class);
    }

}
