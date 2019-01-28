package com.sitech.cmap.test.ai.service;

import com.sitech.cmap.test.ai.service.dto.PaasHelpManualDTO;

import java.util.List;

/**
 * <p>Title: PaasHelpManualApp</p>
 * <p>Description:   </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: SI-TECH </p>
 * @author licf_csd
 * @version 1.0
 * @createtime 2018-09-25 10:24:38
 *
 */
public interface IPaasHelpManualApp {
	/**
	 *
	 * @Title: get
	 * @Description: 根据ID查询PaasHelpManualDTO 实体数据
	 * @param [ id ]
	 * @return PaasHelpManualDTO
	 * @author licf_csd   ooooo
	 * @version 1.0
	 * @createtime 2018-09-25 10:24:38
	 */
	PaasHelpManualDTO get(String id);

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
	List<PaasHelpManualDTO> list(PaasHelpManualDTO paasHelpManualDTO, String... sortKeys);

	/**
	 *
	 * @Title: list
	 * @Description: 根据条件及分页条件查询数据列表
	 * @param [ paasHelpManualDTO, pageIndex, pageLimit]
	 * @return List<PaasHelpManualDTO>
	 * @author licf_csd
	 * @version 1.0
	 * @createtime 2018-09-25 10:24:38
	 */
    List<PaasHelpManualDTO> list(PaasHelpManualDTO paasHelpManualDTO, Integer pageIndex, Integer pageLimit, String... sortKeys);

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
    List<PaasHelpManualDTO> listFuzzy(String condition, Integer pageIndex, Integer pageLimit, String... sortKeys);

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
	int total(PaasHelpManualDTO paasHelpManualDTO);

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
    int totalFuzzy(String condition);

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
    int save(PaasHelpManualDTO paasHelpManualDTO);

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
    int save(List<PaasHelpManualDTO> paasHelpManualDTOs);

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
    int update(PaasHelpManualDTO paasHelpManualDTO);

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
    int update(List<PaasHelpManualDTO> paasHelpManualDTOs);

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
    int delete(String id);

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
	int deleteBatch(List<String> ids);
}
