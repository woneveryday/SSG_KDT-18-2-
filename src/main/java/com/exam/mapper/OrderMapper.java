package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.OrderDTO;

@Mapper
public interface OrderMapper {
	
	public void insertOrder(OrderDTO orderDTO);
	public List<OrderDTO> orderList(String userId);
}
