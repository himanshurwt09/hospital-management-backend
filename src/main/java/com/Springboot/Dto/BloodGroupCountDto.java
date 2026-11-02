package com.Springboot.Dto;

import com.Springboot.entity.Type.bloodgroupType;

public class BloodGroupCountDto {
	
	
	private bloodgroupType bloodgrouptype;
	private Long count;
	
	
	
	public bloodgroupType getBloodgrouptype() {
		return bloodgrouptype;
	}
	public void setBloodgrouptype(bloodgroupType bloodgrouptype) {
		this.bloodgrouptype = bloodgrouptype;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public BloodGroupCountDto(bloodgroupType bloodgrouptype, Long count) {
		super();
		this.bloodgrouptype = bloodgrouptype;
		this.count = count;
	}
	public BloodGroupCountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BloodGroupCountDto [bloodgrouptype=" + bloodgrouptype + ", count=" + count + "]";
	}
	

}
