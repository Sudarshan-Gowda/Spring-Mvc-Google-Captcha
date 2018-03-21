package com.star.sud.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class L2LMessageType implements Serializable {

	private static final long serialVersionUID = 502538846319334806L;

	private static final Map<String, L2LMessageType> TYPES = new LinkedHashMap<String, L2LMessageType>();

	public static final L2LMessageType ERROR = new L2LMessageType("ERROR", "danger");
	public static final L2LMessageType WARNING = new L2LMessageType("WARNING", "warning");
	public static final L2LMessageType SUCCESS = new L2LMessageType("SUCCESS", "success");
	public static final L2LMessageType INFO = new L2LMessageType("INFO", "primary");

	public L2LMessageType() {
	}

	public static L2LMessageType getInstance(final String type) {
		return TYPES.get(type);
	}

	protected String friendlyType;
	protected String type;

	public String getType() {
		return type;
	}

	private void setType(final String type) {
		this.type = type;
		if (!TYPES.containsKey(type)) {
			TYPES.put(type, this);
		}
	}

	public L2LMessageType(String type, String friendlyType) {
		this.friendlyType = friendlyType;
		setType(type);
	}

	public String getFriendlyType() {
		return friendlyType;
	}

	public void setFriendlyType(String friendlyType) {
		this.friendlyType = friendlyType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().isAssignableFrom(obj.getClass()))
			return false;
		L2LMessageType other = (L2LMessageType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public static List<L2LMessageType> getList() {
		List<L2LMessageType> list = new ArrayList<L2LMessageType>(TYPES.values());
		return list;
	}
}
