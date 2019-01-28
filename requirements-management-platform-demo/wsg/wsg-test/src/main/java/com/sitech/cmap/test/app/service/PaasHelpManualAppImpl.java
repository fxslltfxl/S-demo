package com.sitech.cmap.test.app.service;

import com.sitech.cmap.dao.simple.test.mapper.PaasHelpManualMapper;
import com.sitech.cmap.dao.simple.test.po.PaasHelpManual;
import com.sitech.cmap.fw.core.common.EmptyValidator;
import com.sitech.cmap.fw.core.common.bean.BeanConvertor;
import com.sitech.cmap.fw.core.common.reflect.ReflectUtil;
import com.sitech.cmap.fw.core.common.string.UUIDGenerator;

import com.github.pagehelper.PageHelper;
import org.springframework.util.Assert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.sitech.cmap.test.ai.service.dto.PaasHelpManualDTO;
import com.sitech.cmap.test.ai.service.IPaasHelpManualApp;
import tk.mybatis.mapper.entity.Example;


/**
 * <p>Title: PaasHelpManualAppImpl</p>
 * <p>Description:  单表业务逻辑操作接口实现类 </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: SI-TECH </p>
 * @author licf_csd
 * @version 1.0
 * @createtime 2018-09-25 10:24:38
 *
 */
@Service
public class PaasHelpManualAppImpl implements IPaasHelpManualApp {
    private static final String UTC_CREATE = "utcCreate";
	@Resource
	private PaasHelpManualMapper paasHelpManualMapper;

    /**
     *
     * @Title: get
     * @Description: 根据ID查询PaasHelpManualDTO 实体数据
     * @param [ id ]
     * @return PaasHelpManualDTO
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
	@Override
	public PaasHelpManualDTO get(String id){
		PaasHelpManual paasHelpManual = paasHelpManualMapper.selectByPrimaryKey(id);
		return BeanConvertor.getCopyObject(PaasHelpManualDTO.class, paasHelpManual);
	}

    /**
     *
     * @Title: list
     * @Description: 根据条件查询数据列表
     * @param [ paasHelpManualDTO ]
     * @return List<PaasHelpManualDTO>
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public List<PaasHelpManualDTO> list(PaasHelpManualDTO paasHelpManualDTO
            , String... sortKeys){
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO)) {
            Example example = initExample(paasHelpManualDTO);
            List<PaasHelpManual> paasHelpManualList = paasHelpManualMapper.selectByExample(example);
            return BeanConvertor.getCopyList(PaasHelpManualDTO.class, paasHelpManualList);
        } else {
            return BeanConvertor.getCopyList(PaasHelpManualDTO.class, paasHelpManualMapper.selectByExample(
                    initExample(new PaasHelpManualDTO())));
        }
	}

    /**
     *
     * @Title: list
     * @Description: 根据条件及分页条件查询数据列表
     * @param [ paasHelpManualDTO, pageIndex, pageLimit]
     * @return List<PaasHelpManualDTO>
     * @author huojla
     * @version 1.0
     * @createtime 2018/2/9 下午2:06
     */
    @Override
    public List<PaasHelpManualDTO> list(PaasHelpManualDTO paasHelpManualDTO, Integer pageIndex, Integer pageLimit
            , String... sortKeys){
        Assert.notNull(pageIndex, "分页查询，参数pageIndex不能为Null!");
        Assert.notNull(pageLimit, "分页查询，参数pageLimit不能为Null!");
        initPage(pageIndex, pageLimit, sortKeys);
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO)) {
            Example example = initExample(paasHelpManualDTO);
            List<PaasHelpManual> paasHelpManualList = paasHelpManualMapper.selectByExample(example);
            return BeanConvertor.getCopyList(PaasHelpManualDTO.class, paasHelpManualList);
        } else {
            return BeanConvertor.getCopyList(PaasHelpManualDTO.class, paasHelpManualMapper.selectByExample(
                    initExample(new PaasHelpManualDTO())));
        }
	}

    /**
     *
     * @Title: listFuzzy
     * @Description: 根据模糊查询条件及分页条件模糊查询数据列表，模糊所有字段，但只有一个条件
     * @param [ condition, pageIndex, pageLimit]
     * @return List<PaasHelpManualDTO>
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public List<PaasHelpManualDTO> listFuzzy(String condition, Integer pageIndex, Integer pageLimit
            , String... sortKeys){
        Assert.notNull(pageIndex, "分页查询，参数pageIndex不能为Null!");
        Assert.notNull(pageLimit, "分页查询，参数pageLimit不能为Null!");
        initPage(pageIndex, pageLimit, sortKeys);
        if (EmptyValidator.isNotEmpty(condition)) {
            List<PaasHelpManual> paasHelpManualList = paasHelpManualMapper.selectByExample(initFuzzyExample(condition));
            return BeanConvertor.getCopyList(PaasHelpManualDTO.class, paasHelpManualList);
        } else {
            return BeanConvertor.getCopyList(PaasHelpManualDTO.class, paasHelpManualMapper.selectByExample(
                    initExample(new PaasHelpManualDTO())));
        }
    }

    /**
     *
     * @Title: total
     * @Description: 根据条件查询数据总量
     * @param [ paasHelpManualDTO ]
     * @return int
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int total(PaasHelpManualDTO paasHelpManualDTO){
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO)) {
            Example example = initExample(paasHelpManualDTO);
            return paasHelpManualMapper.selectCountByExample(example);
        } else {
            return paasHelpManualMapper.selectCount(null);
        }
	}

    /**
     *
     * @Title: totalFuzzy
     * @Description: 根据模糊查询条件及分页条件模糊查询数据列表，模糊所有字段，但只有一个条件
     * @param [ condition ]
     * @return int
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int totalFuzzy(String condition) {
        if (EmptyValidator.isNotEmpty(condition)) {
            return paasHelpManualMapper.selectCountByExample(initFuzzyExample(condition));
        } else {
            return paasHelpManualMapper.selectCount(null);
        }
    }

    /**
     *
     * @Title: save
     * @Description: 保存数据
     * @param [ paasHelpManualDTO ]
     * @return int （被操作记录条数）
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int save(PaasHelpManualDTO paasHelpManualDTO){
        if (EmptyValidator.isEmpty(paasHelpManualDTO.getId())) {
            paasHelpManualDTO.setId(UUIDGenerator.create());
        }
            initDtoDateField(paasHelpManualDTO, UTC_CREATE);
        return paasHelpManualMapper.insert(BeanConvertor.getCopyObject(PaasHelpManual.class, paasHelpManualDTO));
	}

    /**
     *
     * @Title: save
     * @Description: 批量保存数据
     * @param [ paasHelpManualDTOs ]
     * @return int （被操作记录条数）
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int save(List<PaasHelpManualDTO> paasHelpManualDTOs){
        List<PaasHelpManual> paasHelpManualList = new ArrayList<>();
        for (PaasHelpManualDTO paasHelpManualDTO : paasHelpManualDTOs) {
            if (EmptyValidator.isEmpty(paasHelpManualDTO.getId())) {
                paasHelpManualDTO.setId(UUIDGenerator.create());
            }
            initDtoDateField(paasHelpManualDTO, UTC_CREATE);
            paasHelpManualList.add(BeanConvertor.getCopyObject(PaasHelpManual.class, paasHelpManualDTO));
        }
        return paasHelpManualMapper.save(paasHelpManualList);
    }

    /**
     *
     * @Title: update
     * @Description: 更新数据
     * @param [ paasHelpManualDTO ]
     * @return int （被操作记录条数）
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int update(PaasHelpManualDTO paasHelpManualDTO){
        return paasHelpManualMapper.updateByPrimaryKeySelective(BeanConvertor.getCopyObject(PaasHelpManual.class, paasHelpManualDTO));
	}

    /**
     *
     * @Title: update
     * @Description: 批量更新数据By主键
     * @param [ paasHelpManualDTOs ]
     * @return int （被操作记录条数）
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int update(List<PaasHelpManualDTO> paasHelpManualDTOs){
        List<PaasHelpManual> paasHelpManualList = new ArrayList<>();
        for (PaasHelpManualDTO paasHelpManualDTO : paasHelpManualDTOs) {
            paasHelpManualList.add(BeanConvertor.getCopyObject(PaasHelpManual.class, paasHelpManualDTO));
        }
        return paasHelpManualMapper.updateBatchByIds(paasHelpManualList);
    }

    /**
     *
     * @Title: delete
     * @Description: 根据主键删除数据
     * @param [ id ]
     * @return int （被操作记录条数）
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int delete(String id){
        return paasHelpManualMapper.deleteByPrimaryKey(id);
	}

    /**
     *
     * @Title: deleteBatch
     * @Description: 根据主键批量删除数据
     * @param [ ids ]
     * @return int （被操作记录条数）
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    @Override
    public int deleteBatch(List<String> ids){
        Assert.notNull(ids, "批量删除，参数ids不能为Null!");
        List<PaasHelpManual> paasHelpManuals = new ArrayList<>();
        ids.stream().forEach(id -> {
            PaasHelpManual paasHelpManual = new PaasHelpManual();
            paasHelpManual.setId(id);
            paasHelpManuals.add(paasHelpManual);
        });
        return paasHelpManualMapper.deleteBatchByIds(paasHelpManuals);
    }

    /**
     *
     * @Title: initFuzzyExample
     * @Description: 根据唯一模糊条件构建模糊查询Example
     * @param [condition]
     * @return Example
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    private Example initFuzzyExample(String condition) {
        Example example = new Example(PaasHelpManual.class);

        Example.Criteria criteriaName = example.createCriteria();
        criteriaName.andLike("name", "%" + condition +"%");
        Example.Criteria criteriaRemark = example.createCriteria();
        criteriaRemark.andLike("remark", "%" + condition +"%");
        example.or(criteriaRemark);
        Example.Criteria criteriaUserCreate = example.createCriteria();
        criteriaUserCreate.andLike("userCreate", "%" + condition +"%");
        example.or(criteriaUserCreate);
        Example.Criteria criteriaMdSource = example.createCriteria();
        criteriaMdSource.andLike("mdSource", "%" + condition +"%");
        example.or(criteriaMdSource);
        Example.Criteria criteriaMdHtml = example.createCriteria();
        criteriaMdHtml.andLike("mdHtml", "%" + condition +"%");
        example.or(criteriaMdHtml);
        Example.Criteria criteriaParentId = example.createCriteria();
        criteriaParentId.andLike("parentId", "%" + condition +"%");
        example.or(criteriaParentId);
        Example.Criteria criteriaCatalogCode = example.createCriteria();
        criteriaCatalogCode.andLike("catalogCode", "%" + condition +"%");
        example.or(criteriaCatalogCode);
        return example;
    }

    /**
    *
    * @Title: initExample
    * @Description: 根据查詢条件构建精确查询Example，可根据实际情况进行字段模糊查询修改
    * @param [ paasHelpManualDTO ]
    * @return tk.mybatis.mapper.entity.Example
    * @author licf_csd
    * @version 1.0
    * @createtime 2018-09-25 10:24:38
    */
    private Example initExample(PaasHelpManualDTO paasHelpManualDTO) {
        Example example = new Example(PaasHelpManual.class);

        Example.Criteria criteriaName = example.createCriteria();
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getId())) {
            criteriaName.andEqualTo("id", paasHelpManualDTO.getId());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getName())) {
            criteriaName.andEqualTo("name", paasHelpManualDTO.getName());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getRemark())) {
            criteriaName.andEqualTo("remark", paasHelpManualDTO.getRemark());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getUserCreate())) {
            criteriaName.andEqualTo("userCreate", paasHelpManualDTO.getUserCreate());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getUtcCreate())) {
            criteriaName.andEqualTo("utcCreate", paasHelpManualDTO.getUtcCreate());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getMdSource())) {
            criteriaName.andEqualTo("mdSource", paasHelpManualDTO.getMdSource());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getMdHtml())) {
            criteriaName.andEqualTo("mdHtml", paasHelpManualDTO.getMdHtml());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getParentId())) {
            criteriaName.andEqualTo("parentId", paasHelpManualDTO.getParentId());
        }
        if (EmptyValidator.isNotEmpty(paasHelpManualDTO.getCatalogCode())) {
            criteriaName.andEqualTo("catalogCode", paasHelpManualDTO.getCatalogCode());
        }
        return example;
    }

    /**
     *
     * @Title: initPage
     * @Description: 实例化分页
     * @param [pageIndex, pageLimit, sortKeys]
     * @return void
     * @author licf_csd
     * @version 1.0
     * @createtime 2018-09-25 10:24:38
     */
    private void initPage(int pageIndex, int pageLimit, String... sortKeys) {
        if (EmptyValidator.isNotEmpty(sortKeys)) {
            String sortkey = sortKeys[0];
            if (sortkey.startsWith("-")) {// 降序
                PageHelper.startPage(pageIndex, pageLimit, sortkey.replace("-","") + " desc");
            } else if (sortkey.startsWith("+")) {// 升序
                PageHelper.startPage(pageIndex, pageLimit, sortkey.replace("+",""));
            }
        } else {// 默认无排序
            PageHelper.startPage(pageIndex, pageLimit);
        }
    }

    /**
    *
    * @Title: initDtoDateField
    * @Description: 构建数据日期字段
    * @param [paasHelpManualDTO]
    * @return void
    * @author licf_csd
    * @version 1.0
    * @createtime 2018-09-25 10:24:38
    */
    private void initDtoDateField(PaasHelpManualDTO paasHelpManualDTO, String dateFieldName) {
        if (ReflectUtil.fieldIsExist(paasHelpManualDTO, dateFieldName) &&
            ReflectUtil.fieldIsNull(paasHelpManualDTO, dateFieldName)) {
            ReflectUtil.fieldSetValue(paasHelpManualDTO, dateFieldName, new Date());
        }
    }
}
