package com.xiwen_common.util;

public class EntityReference {
	private String entityname;
	private String entityid;
	
	public EntityReference(String entityname, String entityid) {
		this.entityid = entityid;
		this.entityname = entityname;
	}
	
	public String getEntityName() {
        return entityname;
    }

    public void setEntityName(String entityname) {
        this.entityname = entityname;
    }
    
    public String getEntityId() {
        return entityid;
    }

    public void setEntityId(String entityid) {
        this.entityid = entityid;
    }
}
