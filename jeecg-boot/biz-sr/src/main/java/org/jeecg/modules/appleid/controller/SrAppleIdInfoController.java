package org.jeecg.modules.appleid.controller;

import org.jeecg.modules.appleid.entity.SrAppleIdInfo;
import org.jeecg.modules.appleid.service.ISrAppleIdInfoService;
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
 * @Description: Apple Id 管理
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Api(tags="Apple Id 管理")
@RestController
@RequestMapping("/appleid/srAppleIdInfo")
@Slf4j
public class SrAppleIdInfoController extends JeecgController<SrAppleIdInfo, ISrAppleIdInfoService> {
	@Autowired
	private ISrAppleIdInfoService srAppleIdInfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param srAppleIdInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "Apple Id 管理-分页列表查询")
	@ApiOperation(value="Apple Id 管理-分页列表查询", notes="Apple Id 管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(SrAppleIdInfo srAppleIdInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<SrAppleIdInfo> queryWrapper = QueryGenerator.initQueryWrapper(srAppleIdInfo, req.getParameterMap());
		Page<SrAppleIdInfo> page = new Page<SrAppleIdInfo>(pageNo, pageSize);
		IPage<SrAppleIdInfo> pageList = srAppleIdInfoService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param srAppleIdInfo
	 * @return
	 */
	@AutoLog(value = "Apple Id 管理-添加")
	@ApiOperation(value="Apple Id 管理-添加", notes="Apple Id 管理-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody SrAppleIdInfo srAppleIdInfo) {
		srAppleIdInfoService.save(srAppleIdInfo);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param srAppleIdInfo
	 * @return
	 */
	@AutoLog(value = "Apple Id 管理-编辑")
	@ApiOperation(value="Apple Id 管理-编辑", notes="Apple Id 管理-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody SrAppleIdInfo srAppleIdInfo) {
		srAppleIdInfoService.updateById(srAppleIdInfo);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "Apple Id 管理-通过id删除")
	@ApiOperation(value="Apple Id 管理-通过id删除", notes="Apple Id 管理-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		srAppleIdInfoService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "Apple Id 管理-批量删除")
	@ApiOperation(value="Apple Id 管理-批量删除", notes="Apple Id 管理-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.srAppleIdInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "Apple Id 管理-通过id查询")
	@ApiOperation(value="Apple Id 管理-通过id查询", notes="Apple Id 管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		SrAppleIdInfo srAppleIdInfo = srAppleIdInfoService.getById(id);
		if(srAppleIdInfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(srAppleIdInfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param srAppleIdInfo
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, SrAppleIdInfo srAppleIdInfo) {
        return super.exportXls(request, srAppleIdInfo, SrAppleIdInfo.class, "Apple Id 管理");
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
        return super.importExcel(request, response, SrAppleIdInfo.class);
    }

}
