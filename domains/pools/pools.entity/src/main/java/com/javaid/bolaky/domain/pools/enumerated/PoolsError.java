package com.javaid.bolaky.domain.pools.enumerated;

public enum PoolsError {

	POOLS_USERNAME_NULL("P10","username cannot be null"),
	POOLS_POOLNAME_NULL("P11","pool name cannot be null"),
	POOLS_SHARECOST_NULL("P12","share cost cannot be null"),
	POOLS_POOL_TYPE_NULL("P20","pool type cannot be null"),
	POOLS_VALID_LICENSE_NULL("P30","valid license cannot be null"),
	POOLS_SMOKER_NULL("P40","smoker cannot be null"),
	POOLS_ONE_WAY_TRAVEL_NULL("P50","one way travel cannot be null"),
	POOLS_GENDER_TO_TRAVEL_WITH_NULL("P60","preffered gender to travel with cannot be null"),
	POOLS_GENDER_NULL("P61","gender cannot be null"),
	POOLS_NUMBER_OF_PASSENGERS_EXCEEDS_MAX_SEATS_NUMBER("P62","number of current passenger should be less than maximun seats available"),
	POOLS_AGE_GROUP_NULL("P63","age group cannot be null"),
	POOLS_VEHICLE_OWNER_NULL("P70","vehicle owner cannot be null"),
	POOLS_VEHICLE_MAX_SEATS_NUMBER_NULL("P80","vehicle maximum seats number cannot be null"),
	POOLS_VEHICLE_MAKE_CODE_NULL("P90","vehicle make code cannot be null"),
	POOLS_VEHICLE_MODEL_CODE_NULL("P100","vehicle model code cannot be null"),
	POOLS_VEHICLE_TYPE_CODE_NULL("P110","vehicle type code cannot be null"),
	POOLS_STARTING_DATE_SHOULD_BE_IN_FUTURE("P120","staring date should be in the future"),
	POOLS_STARTING_DATE_NULL("P130","starting date cannot be null"),
	POOLS_DEPARTURE_TIME_NULL("P140","departure time cannot be null"),
	POOLS_FROM_AREA_CODE_NULL("P150","from area code cannot be null"),
	POOLS_FROM_DISTRICT_CODE_NULL("P160","from district code cannot be null"),
	POOLS_END_DATE_NULL("P170","end date cannot be null"),
	POOLS_END_DATE_SHOULD_BE_IN_FUTURE("P171","end date should be in the future"),
	POOLS_END_DATE_SHOULD_BE_AFTER_START_DATE("P172","end date should after start date"),
	POOLS_TO_AREA_CODE_NULL("P180","to area code cannot be null"),
	POOLS_TO_DISTRICT_CODE_NULL("P190","to district code cannot be null"),
	
	POOLS_SEATS_NOT_AVAILABLE("P200","seats not available"),
	POOLS_MONDAY_SEATS_NOT_AVAILABLE("P201"," monday seats not available"),
	POOLS_TUESDAY_SEATS_NOT_AVAILABLE("P202","tuesday seats not available"),
	POOLS_WEDNESDAY_SEATS_NOT_AVAILABLE("P203","wednesday seats not available"),
	POOLS_THURSDAY_SEATS_NOT_AVAILABLE("P204","thursday seats not available"),
	POOLS_FRIDAY_SEATS_NOT_AVAILABLE("P205","friday seats not available"),
	POOLS_SATURDAY_SEATS_NOT_AVAILABLE("P206","saturday seats not available"),
	POOLS_SUNDAY_SEATS_NOT_AVAILABLE("P207","sunday seats not available");
	
	private String errorCode;
	private String errorDescription;
	
	private PoolsError(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	
	public static PoolsError getPoolsError(String poolsErrorCode){
		
		if(poolsErrorCode!=null){
			
			for (PoolsError poolsError : values()) {
				
				if(poolsError.getErrorCode().equalsIgnoreCase(poolsErrorCode)){
					return poolsError;
				}
			}
		}
		
		return null;
	}
}
