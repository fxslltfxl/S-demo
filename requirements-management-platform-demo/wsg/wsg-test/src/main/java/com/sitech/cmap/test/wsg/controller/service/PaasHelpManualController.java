package com.sitech.cmap.test.wsg.controller.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sitech.cmap.test.ai.service.IPaasHelpManualApp;
import com.sitech.cmap.test.ai.service.dto.PaasHelpManualDTO;
import com.sitech.cmap.fw.core.common.EmptyValidator;
import com.sitech.cmap.fw.core.wsg.WsgPageResult;
import com.sitech.cmap.fw.core.wsg.WsgResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: PaasHelpManualController</p>
 * <p>Description:  Wsg控制层 </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: SI-TECH </p>
 * @author licf_csd
 * @version 1.0
 * @createtime 2018-09-25 10:24:38
 *
 */
@RestController
@RequestMapping("/v1/paas_help_manuals")
public class PaasHelpManualController {
    private static final String CONDITION = "_condition_";
    private static final String SORT = "_sort_";
    @Resource
    private IPaasHelpManualApp paasHelpManualApp;

    @ApiOperation(value = "查询  清单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Auth-Token", value = "请求Token参数", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "params", value = "请求参数对象测试，用户支持Get多参数接收", required = false, dataType = "Map", paramType = "query"),
            @ApiImplicitParam(name = "currentPage", value = "当前页数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageLimit", value = "每页记录条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = CONDITION, value = "模糊查询表达式，默认只支持一个String类型字符串模糊查询", required = false,
                    dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = SORT, value = "排序字段，例：-id(id降序)，+name（name升序）,目前支持单字段", required = false,
                    dataType = "String", paramType = "query")
    })
    @GetMapping("")
    public WsgPageResult<List<PaasHelpManualDTO>> list(@RequestParam Map<String,Object> params,
                                                           @RequestParam(name = "currentPage", required=false) Integer currentPage,
                                                           @RequestParam(name = "pageLimit", required=false) Integer pageLimit,
                                                           @RequestParam(name = CONDITION, required=false) String condition,
                                                           @RequestParam(name = SORT, required=false) String sort) {
        /**
         * 有分页条件：
         * ① 有查询条件
         *  （1）精确查询
         *  （2）模糊查询
         * ② 无查询条件
         *
         * 无分页条件：
         * ① 有查询条件
         * （1）精确查询
         * （2）模糊查询
         * ② 无查询条件
         */
        if(currentPage != null && pageLimit != null) {
            PaasHelpManualDTO paasHelpManualDTO = null;
            if (params.size() > 2 && condition != null) {// size大于2，代表还有其他查询条件并且查询为单字段模糊查询
                return new WsgPageResult<>(paasHelpManualApp.listFuzzy(condition, currentPage, pageLimit, sort),
                        currentPage, pageLimit, paasHelpManualApp.totalFuzzy(condition));
            } else if (params.size() > 2 && params.get(CONDITION) == null){// size大于2，代表还有其他查询条件并且为精确查询
                paasHelpManualDTO = JSON.parseObject(JSON.toJSONString(params),
                        new TypeReference<PaasHelpManualDTO>(){});
            }
            return new WsgPageResult<>(paasHelpManualApp.list(paasHelpManualDTO, currentPage, pageLimit, sort),
                    currentPage, pageLimit, paasHelpManualApp.total(paasHelpManualDTO));
        } else {
            PaasHelpManualDTO paasHelpManualDTO = null;
            if (EmptyValidator.isNotEmpty(params) && condition != null) {// 无分页，单字段模糊查询
                int total = paasHelpManualApp.totalFuzzy(condition);
                return new WsgPageResult<>(paasHelpManualApp.listFuzzy(condition, 1, total, sort),
                        1, total, total);
            } else if (EmptyValidator.isNotEmpty(params) && condition == null){// 无分页，精确查询
                paasHelpManualDTO = JSON.parseObject(JSON.toJSONString(params),
                        new TypeReference<PaasHelpManualDTO>(){});
            }
            int total = paasHelpManualApp.total(paasHelpManualDTO);
            return new WsgPageResult<>(paasHelpManualApp.list(paasHelpManualDTO, 1, total, sort),
                    1, total, total);
        }
    }

    @ApiOperation(value = "根据ID查询  对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Auth-Token", value = "请求Token参数", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "唯一标识（主键）", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("/{id}")
    public WsgResult<PaasHelpManualDTO> get(@PathVariable("id") String id) {
        return new WsgResult<>(paasHelpManualApp.get(id));
    }

    @ApiOperation(value = "根据ID更新  对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Auth-Token", value = "请求Token参数", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "唯一标识（主键）", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "paasHelpManualDTO", value = "更新数据消息体", required = true,
                    dataType = "PaasHelpManualDTO", paramType = "body")
    })
    @PutMapping("/{id}")
    public WsgResult<Integer> update(@PathVariable("id") String id, @RequestBody PaasHelpManualDTO paasHelpManualDTO) {
        paasHelpManualDTO.setId(id);
        return new WsgResult<>(paasHelpManualApp.update(paasHelpManualDTO));
    }

    @ApiOperation(value = "保存  对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Auth-Token", value = "请求Token参数", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "paasHelpManualDTO", value = "保存数据消息体", required = true,
                    dataType = "PaasHelpManualDTO", paramType = "body")
    })
    @PostMapping("")
    public WsgResult<Integer> save(@RequestBody PaasHelpManualDTO paasHelpManualDTO) {
        return new WsgResult<>(paasHelpManualApp.save(paasHelpManualDTO));
    }

    @ApiOperation(value = "批量保存  对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Auth-Token", value = "请求Token参数", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "paasHelpManualDTOs", value = "保存数据消息体", required = true,
                    dataType = "PaasHelpManualDTO", paramType = "body")
    })
    @PostMapping("/batch")
    public WsgResult<Integer> save(@RequestBody List<PaasHelpManualDTO> paasHelpManualDTOs) {
        return new WsgResult<>(paasHelpManualApp.save(paasHelpManualDTOs));
    }

    @ApiOperation(value = "删除  对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Auth-Token", value = "请求Token参数", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "唯一标识（主键），若批量，则ID以','分割", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "batch", value = "是否批量", required = false, dataType = "Boolean", paramType = "query")
    })
    @DeleteMapping("/{id}")
    public WsgResult<Integer> delete(@PathVariable("id") String id,@RequestParam(name = "batch", required=false, defaultValue = "true") Boolean batch) {
        if (batch) {
            String[] ids = id.split(",");
            return new WsgResult<>(paasHelpManualApp.deleteBatch(Arrays.asList(ids)));
        }
        return new WsgResult<>(paasHelpManualApp.delete(id));
    }
}
