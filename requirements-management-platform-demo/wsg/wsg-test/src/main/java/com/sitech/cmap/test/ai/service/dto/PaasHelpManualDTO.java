package com.sitech.cmap.test.ai.service.dto;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
* <p>Title: PaasHelpManualDTO</p>
* <p>Description:  </p>
* <p>Copyright: Copyright (c) 2018</p>
* <p>Company: SI-TECH </p>
* @author licf_csd
* @version 1.0
* @createtime 2018-09-25 10:24:38
*
*/
@Data
@Builder
public class PaasHelpManualDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public PaasHelpManualDTO() {

    }

    public PaasHelpManualDTO(String id,String name,String remark,String userCreate,Date utcCreate,String mdSource,String mdHtml,String parentId,String catalogCode) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.userCreate = userCreate;
        this.utcCreate = utcCreate;
        this.mdSource = mdSource;
        this.mdHtml = mdHtml;
        this.parentId = parentId;
        this.catalogCode = catalogCode;
    }

    /**
    * 编号
    */
    private String id;
    /**
    * 名称
    */
    private String name;
    /**
    * 描述
    */
    private String remark;
    /**
    * 创建人
    */
    private String userCreate;
    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date utcCreate;
    /**
    * markdown源文件
    */
    private String mdSource;
    /**
    * markdown html页面
    */
    private String mdHtml;
    /**
    * 父编号
    */
    private String parentId;
    /**
    * 服务目录编号
    */
    private String catalogCode;
}
