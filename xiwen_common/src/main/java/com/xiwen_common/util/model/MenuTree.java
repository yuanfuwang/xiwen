package com.xiwen_common.util.model;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {
	/**
     * 节点ID
     */
    private String id;
    /**
     * 显示节点文本
     */
    private String text;
    /**
     * 显示顺序
     */
    private String index;
    /**
     * 节点是否被选中 true false
     */
    private boolean checked = false;
    /**
     * 父ID
     */
    private String parentId;
    /**
     * 是否有父节点
     */
    private boolean isParent = false;
    /**
     * 是否有子节点
     */
    private boolean isChildren = false;
    /**
     * 节点的子节点
     */
    private List<MenuTree> children = new ArrayList<MenuTree>();
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public boolean getIsChildren() {
        return isChildren;
    }

    public void setIsChildren(boolean isChildren) {
        this.isChildren = isChildren;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
    
	public MenuTree(String id, String text, String index, boolean checked, List<MenuTree> children, String parentId,
			boolean isParent, boolean isChildren) {
		super();
		this.id = id;
		this.text = text;
		this.index = index;
		this.checked = checked;
		this.children = children;
		this.parentId = parentId;
		this.isParent = isParent;
		this.isChildren = isChildren;
	}

    public MenuTree() {
        super();
    }
}
