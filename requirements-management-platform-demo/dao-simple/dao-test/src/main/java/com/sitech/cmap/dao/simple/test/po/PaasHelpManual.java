package com.sitech.cmap.dao.simple.test.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "paas_help_manual")
public class PaasHelpManual {
    /**
     * 编号
     */
    @Id
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
    @Column(name = "user_create")
    private String userCreate;

    /**
     * 创建时间
     */
    @Column(name = "utc_create")
    private Date utcCreate;

    /**
     * markdown源文件
     */
    @Column(name = "md_source")
    private String mdSource;

    /**
     * markdown html页面
     */
    @Column(name = "md_html")
    private String mdHtml;

    /**
     * 父编号
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 服务目录编号
     */
    @Column(name = "catalog_code")
    private String catalogCode;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return remark - 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述
     *
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人
     *
     * @return user_create - 创建人
     */
    public String getUserCreate() {
        return userCreate;
    }

    /**
     * 设置创建人
     *
     * @param userCreate 创建人
     */
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    /**
     * 获取创建时间
     *
     * @return utc_create - 创建时间
     */
    public Date getUtcCreate() {
        return utcCreate;
    }

    /**
     * 设置创建时间
     *
     * @param utcCreate 创建时间
     */
    public void setUtcCreate(Date utcCreate) {
        this.utcCreate = utcCreate;
    }

    /**
     * 获取markdown源文件
     *
     * @return md_source - markdown源文件
     */
    public String getMdSource() {
        return mdSource;
    }

    /**
     * 设置markdown源文件
     *
     * @param mdSource markdown源文件
     */
    public void setMdSource(String mdSource) {
        this.mdSource = mdSource;
    }

    /**
     * 获取markdown html页面
     *
     * @return md_html - markdown html页面
     */
    public String getMdHtml() {
        return mdHtml;
    }

    /**
     * 设置markdown html页面
     *
     * @param mdHtml markdown html页面
     */
    public void setMdHtml(String mdHtml) {
        this.mdHtml = mdHtml;
    }

    /**
     * 获取父编号
     *
     * @return parent_id - 父编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父编号
     *
     * @param parentId 父编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取服务目录编号
     *
     * @return catalog_code - 服务目录编号
     */
    public String getCatalogCode() {
        return catalogCode;
    }

    /**
     * 设置服务目录编号
     *
     * @param catalogCode 服务目录编号
     */
    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }
}