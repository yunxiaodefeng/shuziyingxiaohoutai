package com.ruoyi.project.mbkj.systemwechatmenu.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: gen
 * @description:
 * @author: 云晓得峰
 * @create: 2020-08-12 13:07
 **/
public class TreeNode implements Serializable {

    private Integer id;

    private String icon;
    private String btnname;
    private Integer parentid;
    private Integer iscreate;
    private String pathurl;
    private Integer ispay;
    private List<TreeNode> children;

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }

    public String getPathurl() {
        return pathurl;
    }

    public void setPathurl(String pathurl) {
        this.pathurl = pathurl;
    }

    public Integer getIscreate() {
        return iscreate;
    }

    public void setIscreate(Integer iscreate) {
        this.iscreate = iscreate;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBtnname() {
        return btnname;
    }

    public void setBtnname(String btnname) {
        this.btnname = btnname;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
