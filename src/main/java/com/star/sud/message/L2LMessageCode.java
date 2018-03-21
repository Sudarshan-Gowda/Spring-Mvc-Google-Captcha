package com.star.sud.message;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class L2LMessageCode {

	private static final Map<String, L2LMessageCode> TYPES = new LinkedHashMap<String, L2LMessageCode>();

	public static final L2LMessageCode INFORMATION = new L2LMessageCode("INFORMATION", " Information.");

	public static final L2LMessageCode INVALID_CREDENTIALS = new L2LMessageCode("INVALID_CREDENTIALS",
			" Invalid Credentials.");

	public static final L2LMessageCode ENTITY_NOT_FOUND = new L2LMessageCode("ENTITY_NOT_FOUND", " Not Found.");

	public static final L2LMessageCode OPERATION_FAILED = new L2LMessageCode("OPERATION_FAILED",
			" Operation Failed while performing this Operation.");

	public static final L2LMessageCode ENTITY_ADDED = new L2LMessageCode("ENTITY_ADDED", " Added Successfully.");

	public static final L2LMessageCode ENTITY_SAVED = new L2LMessageCode("ENTITY_SAVED", " Updated Successfully.");

	public static final L2LMessageCode ENTITY_DELETED = new L2LMessageCode("ENTITY_DELETED", " Deleted Successfully.");

	public static final L2LMessageCode ENTITY_AUTHORIZED = new L2LMessageCode("ENTITY_AUTHORIZED",
			" Authorized Successfully.");

	public static final L2LMessageCode ENTITY_LOKED = new L2LMessageCode("ENTITY_LOKED",
			" No Changes made on this Screen.");

	public static final L2LMessageCode NOT_PERMITTED = new L2LMessageCode("NOT_PERMITTED", " : Permission is Denied.");

	public static final L2LMessageCode DELETION_NOT_PERMITTED = new L2LMessageCode("DELETION_NOT_PERMITTED",
			"Deletion Permission is Denied for this Account.");

	public static final L2LMessageCode CLAIMED = new L2LMessageCode("CLAIMED", "Queue has been claimed Successfully.");

	public static final L2LMessageCode REASSIGN = new L2LMessageCode("REASSIGN",
			"  has been successfully reassigned to  ");

	public static final L2LMessageCode SESSION_EXPIRED = new L2LMessageCode("SESSION_EXPIRED",
			"User Session Expired. Please login again.");

	// jdss

	public static final L2LMessageCode CONNECTION_SUCCESS = new L2LMessageCode("CONNECTION_SUCCESS",
			" : Successfully Connected.");

	public static final L2LMessageCode CONNECTION_FAILURE = new L2LMessageCode("CONNECTION_FAILURE",
			" : Connection Failed.");

	public static final L2LMessageCode NOT_FOUND = new L2LMessageCode("NOT_FOUND", " : Not Found.");

	public static final L2LMessageCode NOT_MATCH = new L2LMessageCode("NOT_MATCH", " : Not Match.");

	public static final L2LMessageCode SAVED_SUCCESS = new L2LMessageCode("SAVED_SUCCESS", " : Saved Successfully.");

	public static final L2LMessageCode UPDATE_SUCCESS = new L2LMessageCode("UPDATE_SUCCESS",
			" : Updated Successfully.");

	public static final L2LMessageCode REMOVED_SUCCESS = new L2LMessageCode("REMOVED_SUCCESS",
			" : Removed Successfully.");

	public static final L2LMessageCode EOD_FAIL = new L2LMessageCode("EOD_FAIL", " Eod Failed for the Branch");

	public static final L2LMessageCode BOD_FAIL = new L2LMessageCode("BOD_FAIL", " Bod Failed for the Branch");

	public static final L2LMessageCode EOD_SUCCESS = new L2LMessageCode("EOD_SUCCESS",
			" Successfully completed EOD for the Branch");

	public static final L2LMessageCode BOD_SUCCESS = new L2LMessageCode("BOD_SUCCESS",
			" Successfully completed BOD for the Branch");

	public static final L2LMessageCode EOD_STARTED = new L2LMessageCode("EOD_STARTED",
			"Eod Has already started for the branch");

	public static final L2LMessageCode BOD_STARTED = new L2LMessageCode("BOD_STARTED",
			"Bod Has already started for the branch");

	public static final L2LMessageCode REPAYMENT_SUCCESS = new L2LMessageCode("REPAYMENT_SUCCESS",
			"Successfully completed Repayment of the account number");

	public static final L2LMessageCode REPAYMENT_FAIL = new L2LMessageCode("REPAYMENT_FAIL",
			"Repayment failed of the account number");

	public static final L2LMessageCode CHOOSE_ACC_NUM = new L2LMessageCode("CHOOSE_ACCOUNT_NUMBER",
			"Choose one Account number");

	public static final L2LMessageCode COMMENT = new L2LMessageCode("COMMENT IS MANDATORY", "Comment Mandatory");

	public static final L2LMessageCode PWD_VAL_ERROR = new L2LMessageCode("PASSWORD", "Password validation error");
	// CASA

	public static final L2LMessageCode CASA_CLOSE_SCSUCCESS = new L2LMessageCode("ACCOUNT",
			"Account Closed Successfully.");

	public static final L2LMessageCode CASA_CLOSE_ERROR = new L2LMessageCode("ACCOUNT", "Account is allready Close."); // end
																														// of
																														// casa

	// JDSS

	public L2LMessageCode() {
	}

	public static L2LMessageCode getInstance(final String type) {
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

	public L2LMessageCode(String type, String friendlyType) {
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
		L2LMessageCode other = (L2LMessageCode) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public static List<L2LMessageCode> getList() {
		List<L2LMessageCode> list = new ArrayList<L2LMessageCode>(TYPES.values());
		return list;
	}
}
